package edu.vassar.cmpu203.triviagame.controller;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import edu.vassar.cmpu203.triviagame.view.ActiveQuestion;
import edu.vassar.cmpu203.triviagame.view.CategoriesModeFragment;
import edu.vassar.cmpu203.triviagame.view.IActiveQuestionView;
import edu.vassar.cmpu203.triviagame.model.Choice;
import edu.vassar.cmpu203.triviagame.model.IGameShow;
import edu.vassar.cmpu203.triviagame.model.Player;
import edu.vassar.cmpu203.triviagame.model.Question;
import edu.vassar.cmpu203.triviagame.model.RandMultiChoice;
import edu.vassar.cmpu203.triviagame.view.GameConfigFragment;
import edu.vassar.cmpu203.triviagame.view.GameLostFragment;
import edu.vassar.cmpu203.triviagame.view.GameModeFragment;
import edu.vassar.cmpu203.triviagame.view.GameWonFragment;
import edu.vassar.cmpu203.triviagame.view.ICategoriesModeView;
import edu.vassar.cmpu203.triviagame.view.ICorrectAnsView;
import edu.vassar.cmpu203.triviagame.view.IGameConfigView;
import edu.vassar.cmpu203.triviagame.view.IGameLostView;
import edu.vassar.cmpu203.triviagame.view.IGameModeView;
import edu.vassar.cmpu203.triviagame.view.IGameWonView;
import edu.vassar.cmpu203.triviagame.view.IMainView;
import edu.vassar.cmpu203.triviagame.view.MainView;
//import edu.vassar.cmpu203.triviagame.view.QuestionFragment;
import edu.vassar.cmpu203.triviagame.view.CorrectAnsFragment;

public class MainActivity extends AppCompatActivity implements IGameConfigView.Listener, IGameLostView.Listener, ICorrectAnsView.Listener, IGameModeView.Listener,
        IGameWonView.Listener, /*IQuestionView.Listener,*/ IActiveQuestionView.Listener, ICategoriesModeView.Listener {

    private IMainView mainView; // a reference to the main screen template
    //private IGameShow questionBase;

    private Player player; // player object in charge of tracking object
    private Question activeQuestion; // the question being asked, used to store its info
    public IGameShow questionBase; // where we pull questions from

    boolean continueGame; // whether a player gets a question right
    //private int answerStreak = 0;

    String curCategory;

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
        //this.questionBase = new RandMultiChoice(this.getAssets()); // database reset
    }

    /**
     * Sets activeQuestion to a random unused question from questionBase
     * @return a random question from database
     */
    @Override
    public Question getQuestion(){
        if(curCategory.length()>0){
            this.activeQuestion = questionBase.getQuestion(curCategory); // pulls the question and removes
            return this.activeQuestion;
        }
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
    public String getCategory(){
        return curCategory;
    }
    /**
     * Takes the user to the first question screen fragment
     */
    @Override
    public void onWWM(){
        ActiveQuestion questionFragment = new ActiveQuestion(this);
        curCategory = "";
        //this.setCurQuestion(questionBase);
        //questionFragment.setQuestionDisplay(activeQuestion);
        this.mainView.displayFragment(questionFragment, true, "first-question");
    }

    @Override
    public void onCategoriesMode(){
        CategoriesModeFragment categoriesModeFragment = new CategoriesModeFragment(this);
        this.mainView.displayFragment(categoriesModeFragment,true,"category-mode");
    }


    @Override
    public void onGeo(){
        curCategory = "geography";
        Log.d("curCategory", curCategory);
        ActiveQuestion questionFragment = new ActiveQuestion(this);
        this.mainView.displayFragment(questionFragment, true, "first-question");
    }

    @Override
    public void onTV(){
        curCategory = "television";
        Log.d("curCategory", curCategory);
        ActiveQuestion questionFragment = new ActiveQuestion(this);
        this.mainView.displayFragment(questionFragment, true, "first-question");
    }
    @Override
    public void onHobbies(){
        curCategory = "hobbies";
        Log.d("curCategory", curCategory);
        ActiveQuestion questionFragment = new ActiveQuestion(this);
        this.mainView.displayFragment(questionFragment, true, "first-question");
    }

    @Override
    public void onSports(){
        curCategory = "sports";
        Log.d("curCategory", curCategory);
        ActiveQuestion questionFragment = new ActiveQuestion(this);
        this.mainView.displayFragment(questionFragment, true, "first-question");
    }

    /**
     * This currently will only do the same as onWMM, but next iteration, when we add an additional
     * game mode it should be implemented
     */
    @Override
    public void onRandom(){
        curCategory = "";
        Log.d("curCategory", curCategory);
        Random r = new Random();
        if(r.nextBoolean()){
            onCategoriesMode();
        }else{
            onWWM();
        }

        /*ActiveQuestion questionFragment = new ActiveQuestion(this);
        this.mainView.displayFragment(questionFragment, true, "first-question");*/
    }

    @Override
    public void onRandomCat(){

        Random r = new Random();
        int i = r.nextInt(4);
        switch(i){
            case 0:
                onTV();
                break;
            case 1:
                onGeo();
                break;
            case 2:
                onHobbies();
                break;
            case 3:
                onSports();
                break;
        }

        //onWWM(); // performs same action as previous method

    }

    /**
     * Takes user to the more_info slide
     */
    @Override
    public void onMoreInfo(){
        GameModeFragment game_mode_fragment = new GameModeFragment(this);
        this.mainView.displayFragment(game_mode_fragment, true, "info-slide");
    }

    /**
     * WIll take user to a brand new game, starting with question one.
     * Implements resets as well to start from question 1 again.
     */
    @Override
    public void onPlayAgain(){

        resetGame(); // reset of stats
        Log.d("curCategoryPlayAgain", curCategory);
        switch(curCategory){
            case "":
                onWWM();
                break;
            case "television":
                onTV();
                break;
            case "geography":
                onGeo();
                break;
            case "hobbies":
                onHobbies();
                break;
            case "sports":
                onSports();
                break;
        }

        //onWWM(); // performs same action as previous method

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
        Log.d("curCategory", curCategory);
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
            GameWonFragment game_won_fragment = new GameWonFragment(this);
            this.mainView.displayFragment(game_won_fragment, true, "won-the-game"); // game won screen displayed
        }
        else if (continueGame){ // activated if player got answer right and needs to keep going
            CorrectAnsFragment correct_ans_fragment = new CorrectAnsFragment(this);
            this.mainView.displayFragment(correct_ans_fragment, true, "right-ans"); // correct ans screen displayed
        }
        else{ // activated if player gets question wrong and loses
            GameLostFragment game_lost_fragment = new GameLostFragment(this);
            this.mainView.displayFragment(game_lost_fragment, true, "lost-game"); // game lost screen displayed
        }
    }


}