package edu.vassar.cmpu203.triviagame.controller;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import edu.vassar.cmpu203.triviagame.ActiveQuestion;
import edu.vassar.cmpu203.triviagame.IActiveQuestionView;
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
import edu.vassar.cmpu203.triviagame.view.IQuestionView;
import edu.vassar.cmpu203.triviagame.view.MainView;
//import edu.vassar.cmpu203.triviagame.view.QuestionFragment;
import edu.vassar.cmpu203.triviagame.view.correct_ans_Fragment;

public class MainActivity extends AppCompatActivity implements IGameConfigView.Listener, IGameLostView.Listener, ICorrectAnsView.Listener, IGameModeView.Listener,
        IGameWonView.Listener, /*IQuestionView.Listener,*/ IActiveQuestionView.Listener {

    private IMainView mainView; // a reference to the main screen template
    //private IGameShow questionBase;

    private Player player;
    private Question activeQuestion;
    public IGameShow questionBase = new RandMultiChoice();
    //private int answerStreak = 0;



    //private IGameShow database;

    public MainActivity(){
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mainView = new MainView(this);
        questionBase = new RandMultiChoice();
        player = new Player();
        this.setContentView(mainView.getRootView());
        this.mainView.displayFragment(new GameConfigFragment(this),true, "game-config");
    }
    public void setCurQuestion(IGameShow gameShow){
        this.activeQuestion = gameShow.getQuestion();
        //Viewbag.activeQuestion = this.activeQuestion;
    }

    //public void checkPlayerAns(int index){
       // this.activeQuestion.isCorrect(index);
    //}
    public void checkAnswer(Question q, int index){
        boolean isCorrect = q.isCorrect(index);
        activeQuestion = q;
        player.rightAns();
        onSubmit(isCorrect);
    }
    @Override
    public Choice rightAnswer(){
        return activeQuestion.getCorrectChoice();
    }

    public int questionNumber(){
        return player.questionNumber;
    }
    /**
     * Takes the user to the first question screen fragment
     */
    @Override
    public void onWWM(){
        ActiveQuestion questionFragment = new ActiveQuestion(this);
        this.setCurQuestion(questionBase);
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
     * WIll take user to a brand new game, starting with question one
     */
    @Override
    public void onPlayAgain(){
        onWWM();
    }

    /**
     * WIll take user back to Game Configuration, where they can choose mode
     */
    @Override
    public void onMenu(){
        GameConfigFragment gameConfigFragment = new GameConfigFragment(this);
        this.mainView.displayFragment(gameConfigFragment, true, "restart");
    }

    @Override
    public void onNext(){
        ActiveQuestion questionFragment = new ActiveQuestion(this);
        this.mainView.displayFragment(questionFragment, true, "not-fin-next");
    }

    @Override
    public void onGoBack(){
        GameConfigFragment gameConfigFragment = new GameConfigFragment(this);
        this.mainView.displayFragment(gameConfigFragment, true, "back-to-menu");
    }

    @Override
    public void onSubmit(boolean rightAns){
        //boolean rightAns = true;
        if (player.answerStreak == 5){
            Game_Won_Fragment game_won_fragment = new Game_Won_Fragment(this);
            this.mainView.displayFragment(game_won_fragment, true, "won-the-game");
        }
        else if (rightAns){
            correct_ans_Fragment correct_ans_fragment = new correct_ans_Fragment(this);
            this.mainView.displayFragment(correct_ans_fragment, true, "right-ans");
        }
        else{
            Game_Lost_Fragment game_lost_fragment = new Game_Lost_Fragment(this);
            this.mainView.displayFragment(game_lost_fragment, true, "lost-game");
        }
    }


}