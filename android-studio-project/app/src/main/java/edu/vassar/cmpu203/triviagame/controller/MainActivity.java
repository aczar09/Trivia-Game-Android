package edu.vassar.cmpu203.triviagame.controller;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;

import edu.vassar.cmpu203.triviagame.R;
import edu.vassar.cmpu203.triviagame.model.QuestionDatabase;
import edu.vassar.cmpu203.triviagame.view.ActiveQuestion;
import edu.vassar.cmpu203.triviagame.view.IActiveQuestionView;
import edu.vassar.cmpu203.triviagame.model.Choice;
import edu.vassar.cmpu203.triviagame.model.IGameShow;
import edu.vassar.cmpu203.triviagame.model.Player;
import edu.vassar.cmpu203.triviagame.model.Question;
import edu.vassar.cmpu203.triviagame.model.RandMultiChoice;
import edu.vassar.cmpu203.triviagame.view.GameConfigFragment;
import edu.vassar.cmpu203.triviagame.view.Game_Lost_Fragment;
import edu.vassar.cmpu203.triviagame.view.Game_Mode_Fragment;
import edu.vassar.cmpu203.triviagame.view.Game_Won_Fragment;
import edu.vassar.cmpu203.triviagame.view.ICorrectAnsView;
import edu.vassar.cmpu203.triviagame.view.IGameConfigView;
import edu.vassar.cmpu203.triviagame.view.IGameLostView;
import edu.vassar.cmpu203.triviagame.view.IGameModeView;
import edu.vassar.cmpu203.triviagame.view.IGameWonView;
import edu.vassar.cmpu203.triviagame.view.IMainView;
import edu.vassar.cmpu203.triviagame.view.MainView;
//import edu.vassar.cmpu203.triviagame.view.QuestionFragment;
import edu.vassar.cmpu203.triviagame.view.correct_ans_Fragment;

public class MainActivity extends AppCompatActivity implements IGameConfigView.Listener, IGameLostView.Listener, ICorrectAnsView.Listener, IGameModeView.Listener,
        IGameWonView.Listener, /*IQuestionView.Listener,*/ IActiveQuestionView.Listener {

    private IMainView mainView; // a reference to the main screen template
    //private IGameShow questionBase;

    private Player player; // player object in charge of tracking object
    private Question activeQuestion; // the question being asked, used to store its info
    public IGameShow questionBase; // where we pull questions from

    boolean continueGame; // whether a player gets a question right
    //private int answerStreak = 0;



    //private IGameShow database;

    public MainActivity(){ // constructor
    }


    /**
     * Called by the Android framework whenever the activity is (re)created.
     * @param savedInstanceState saved data from prior instantiation (ignore for now)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //new QuestionDatabase(this.getAssets()); // rui example read question database


        this.mainView = new MainView(this);
        questionBase = new RandMultiChoice(this.getAssets()); // sets questionBase
        player = new Player(); // sets player object
        continueGame = true; // sets to true as player hasn't gotten question wrong yet
        this.setContentView(mainView.getRootView());
        this.mainView.displayFragment(new GameConfigFragment(this),true, "game-config");



    }

    /**
     * Resets player's answerStreak along with QuestionNumber. Creates new database as well
     */
    private void resetGame(){
        this.player.resetStreak(); // player reset
        this.questionBase = new RandMultiChoice(this.getAssets()); // database reset
    }

    /**
     * Sets activeQuestion to a random unused question from questionBase
     * @return a random question from database
     */
    @Override
    public Question getQuestion(){
        this.activeQuestion = questionBase.getQuestion(); // pulls the question and removes
        return this.activeQuestion; // returns so can be taken into account
    }


    /**
     * gets the right Answer Choice from the question.
     * To be called when player gets question wrong
     * and we want to print correct answer.
     * @return the correct answer choice
     */
    @Override
    public Choice rightAnswer(){
        return activeQuestion.getCorrectChoice();
    }

    /**
     * Gives us the current questionNumber that the player is on
     * @return the integer number of which question player is onm
     */
    public int questionNumber(){
        return player.questionNumber;
    }
    /**
     * Takes the user to the first question screen fragment
     */
    @Override
    public void onWWM(){
        ActiveQuestion questionFragment = new ActiveQuestion(this);
        //this.setCurQuestion(questionBase);
        //questionFragment.setQuestionDisplay(activeQuestion);
        this.mainView.displayFragment(questionFragment, true, "first-question");
    }

    /**
     * This currently will only do the same as onWMM, but next iteration, when we add an additional
     * game mode it should be implemented
     */
    @Override
    public void onRandom(){
        ActiveQuestion questionFragment = new ActiveQuestion(this);
        this.mainView.displayFragment(questionFragment, true, "first-question");
    }

    /**
     * Takes user to the more_info slide
     */
    @Override
    public void onMoreInfo(){
        Game_Mode_Fragment game_mode_fragment = new Game_Mode_Fragment(this);
        this.mainView.displayFragment(game_mode_fragment, true, "info-slide");
    }

    /**
     * WIll take user to a brand new game, starting with question one.
     * Implements resets as well to start from question 1 again.
     */
    @Override
    public void onPlayAgain(){
        resetGame(); // reset of stats
        onWWM(); // performs same action as previous method
    }

    /**
     * WIll take user back to Game Configuration, where they can choose mode.
     * Resets the stats as well to start from question 1 again
     */
    @Override
    public void onMenu(){
        resetGame(); // reset of stats
        GameConfigFragment gameConfigFragment = new GameConfigFragment(this);
        this.mainView.displayFragment(gameConfigFragment, true, "restart");
    }

    /**
     * Used on CorrectAns Screen. Will go to next question that needs to be implemented
     */
    @Override
    public void onNext(){
        ActiveQuestion questionFragment = new ActiveQuestion(this);
        this.mainView.displayFragment(questionFragment, true, "not-fin-next");
    }

    /**
     * Used in Game Info screen, allows user to get back to GameConfig Screen
     */
    @Override
    public void onGoBack(){
        GameConfigFragment gameConfigFragment = new GameConfigFragment(this);
        this.mainView.displayFragment(gameConfigFragment, true, "back-to-menu");
    }

    /**
     * Will check whether player got right answer and whether to continue game further
     * @param index the index of which answer choice the user selected
     */
    @Override
    public void onSubmit(int index){
        continueGame = activeQuestion.isCorrect(index);
        if (continueGame) {
            player.rightAns(); // marks that player got right answer
        }
        if (player.answerStreak == 5){ // activated if player won the game
            Game_Won_Fragment game_won_fragment = new Game_Won_Fragment(this);
            this.mainView.displayFragment(game_won_fragment, true, "won-the-game"); // game won screen displayed
        }
        else if (continueGame){ // activated if player got answer right and needs to keep going
            correct_ans_Fragment correct_ans_fragment = new correct_ans_Fragment(this);
            this.mainView.displayFragment(correct_ans_fragment, true, "right-ans"); // correct ans screen displayed
        }
        else{ // activated if player gets question wrong and loses
            Game_Lost_Fragment game_lost_fragment = new Game_Lost_Fragment(this);
            this.mainView.displayFragment(game_lost_fragment, true, "lost-game"); // game lost screen displayed
        }
    }


}