package edu.vassar.cmpu203.triviagame.controller;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Random;

import edu.vassar.cmpu203.triviagame.model.Choice;
import edu.vassar.cmpu203.triviagame.model.IGameShow;
import edu.vassar.cmpu203.triviagame.model.Player;
import edu.vassar.cmpu203.triviagame.model.Question;
import edu.vassar.cmpu203.triviagame.model.RandMultiChoice;
import edu.vassar.cmpu203.triviagame.persistence.IPersistenceFacade;
import edu.vassar.cmpu203.triviagame.persistence.LocalStorageFacade;
import edu.vassar.cmpu203.triviagame.view.ActiveQuestion;
import edu.vassar.cmpu203.triviagame.view.CategoriesModeFragment;
import edu.vassar.cmpu203.triviagame.view.CorrectAnsFragment;
import edu.vassar.cmpu203.triviagame.view.GameConfigFragment;
import edu.vassar.cmpu203.triviagame.view.GameLostFragment;
import edu.vassar.cmpu203.triviagame.view.GameModeFragment;
import edu.vassar.cmpu203.triviagame.view.GameWonFragment;
import edu.vassar.cmpu203.triviagame.view.IActiveQuestionView;
import edu.vassar.cmpu203.triviagame.view.ICategoriesModeView;
import edu.vassar.cmpu203.triviagame.view.ICorrectAnsView;
import edu.vassar.cmpu203.triviagame.view.IGameConfigView;
import edu.vassar.cmpu203.triviagame.view.IGameLostView;
import edu.vassar.cmpu203.triviagame.view.IGameModeView;
import edu.vassar.cmpu203.triviagame.view.IGameWonView;
import edu.vassar.cmpu203.triviagame.view.IMainView;
import edu.vassar.cmpu203.triviagame.view.IStatsView;
import edu.vassar.cmpu203.triviagame.view.MainView;
import edu.vassar.cmpu203.triviagame.view.StatsFragment;
import edu.vassar.cmpu203.triviagame.view.TriviaTimeFragFactory;

public class MainActivity extends AppCompatActivity implements IGameConfigView.Listener, IGameLostView.Listener, ICorrectAnsView.Listener, IGameModeView.Listener,
        IGameWonView.Listener, /*IQuestionView.Listener,*/ IActiveQuestionView.Listener, ICategoriesModeView.Listener, IPersistenceFacade.Listener, IStatsView.Listener {

    private static final String PLAYER = "player";
    private static final String AQUESTION = "activequestion";
    private IMainView mainView; // a reference to the main screen template
    //private IGameShow questionBase;

    private Player player; // player object in charge of tracking object
    private Question activeQuestion; // the question being asked, used to store its info
    public IGameShow questionBase; // where we pull questions from

    private IPersistenceFacade persistenceFacade;

    boolean continueGame; // whether a player gets a question right
    //private int answerStreak = 0;

    String curCategory = "";

    String curMode = "";
    String bestCategory = "";
    String bestMode = "";
    //private IGameShow database;

    public MainActivity(){ // constructor
    }


    /**
     * Called by the Android framework whenever the activity is (re)created.
     * @param savedInstanceState saved data from prior instantiation (ignore for now)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportFragmentManager().setFragmentFactory(new TriviaTimeFragFactory(this));
        super.onCreate(savedInstanceState);

        //new QuestionDatabase(this.getAssets()); // rui example read question database


        this.mainView = new MainView(this);
        //questionBase = new RandMultiChoice(this.getAssets()); // sets questionBase
        player = new Player(); // sets player object
        continueGame = true; // sets to true as player hasn't gotten question wrong yet
        this.setContentView(mainView.getRootView());

        this.persistenceFacade = new LocalStorageFacade(this.getFilesDir()); // instantiate persistence facade


        if (savedInstanceState == null) {
            this.persistenceFacade.retrieveDatabase(this);
            if (this.questionBase == null){
                this.questionBase = new RandMultiChoice(this.getAssets());
            }

            this.mainView.displayFragment(new GameConfigFragment(this), false, "game-config");
        }
        else{
            this.player = (Player) savedInstanceState.getSerializable(PLAYER);
            this.activeQuestion = (Question) savedInstanceState.getSerializable(AQUESTION);
        }


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outstate){
        super.onSaveInstanceState(outstate);
        outstate.putSerializable(PLAYER, this.player);
        outstate.putSerializable(AQUESTION, this.activeQuestion);
        this.persistenceFacade.saveDatabase(this.questionBase);
    }

    public void onDatabaseReceived(@NonNull IGameShow database){
        this.questionBase = database;
    }

    /**
     * Resets player's answerStreak along with QuestionNumber. Creates new database as well
     */
    private void resetGame(){
        if (player.answerStreak == 5) { // activated if player won the game
            if (player.modeScores.containsKey(curMode)) {
                Log.d(curMode, "is here");
                //player.addModeWin(curMode);
            } else {
                player.modeScores.put(curMode, 1);
            }

            player.addWin();
        }
        this.player.resetStreak(); // player reset
        //this.curMode = "";
        //this.questionBase = new RandMultiChoice(this.getAssets()); // database reset
    }

    public Question getActiveQuestion(){
        return this.activeQuestion;
    }

    /**
     * Sets activeQuestion to a random unused question from questionBase
     * @return a random question from database
     */
    @Override
    public Question getQuestion(){
        if(!curMode.equals("Who Wants To Be A Millionaire?")){
            this.activeQuestion = questionBase.getQuestion(curCategory); // pulls the question and removes
            curCategory = activeQuestion.getCategory();
            return this.activeQuestion;
        }
        this.activeQuestion = questionBase.getQuestion(); // pulls the question and removes
        curCategory = activeQuestion.getCategory();
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

    public String getBestCategory(){
        bestCategory = "None";
        if(player.categoryScores.size()>0){
            bestCategory = Collections.max(player.categoryScores.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        }

        return bestCategory;
    }

    public String getBestMode(){
        bestMode = "None";
        if(player.modeScores.size()>0){
            bestMode = Collections.max(player.modeScores.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        }

        return bestMode;
    }

    public String getNumberWins(){
        return String.valueOf(player.totalWins);
    }

    public String getNumberQuestionsCorrect(){
        return String.valueOf(player.totalQuestionsCorrect);
    }

    @Override
    public void onStats(){
        StatsFragment statsFragment = new StatsFragment(this);
        this.mainView.displayFragment(statsFragment,true,"stats-mode");
    }
    /**
     * Takes the user to the first question screen fragment
     */
    @Override
    public void onWWM(){
        ActiveQuestion questionFragment = new ActiveQuestion(this);
        curMode = "Who Wants To Be A Millionaire?";
        getQuestion();
        //this.setCurQuestion(questionBase);
        //questionFragment.setQuestionDisplay(activeQuestion);
        this.mainView.displayFragment(questionFragment, true, "first-question");
    }

    @Override
    public void onCategoriesMode(){
        curMode = "Categories";
        //getQuestion();
        CategoriesModeFragment categoriesModeFragment = new CategoriesModeFragment(this);
        this.mainView.displayFragment(categoriesModeFragment,true,"category-mode");
    }


    @Override
    public void onGeo(){
        curCategory = "geography";
        getQuestion();
        Log.d("curCategory", curCategory);
        ActiveQuestion questionFragment = new ActiveQuestion(this);
        this.mainView.displayFragment(questionFragment, true, "first-question");
    }

    @Override
    public void onTV(){
        curCategory = "television";
        getQuestion();
        Log.d("curCategory", curCategory);
        ActiveQuestion questionFragment = new ActiveQuestion(this);
        this.mainView.displayFragment(questionFragment, true, "first-question");
    }
    @Override
    public void onHobbies(){
        curCategory = "hobbies";
        getQuestion();
        Log.d("curCategory", curCategory);
        ActiveQuestion questionFragment = new ActiveQuestion(this);
        this.mainView.displayFragment(questionFragment, true, "first-question");
    }

    @Override
    public void onSports(){
        curCategory = "sports";
        getQuestion();
        Log.d("curCategory", curCategory);
        ActiveQuestion questionFragment = new ActiveQuestion(this);
        this.mainView.displayFragment(questionFragment, true, "first-question");
    }

    /**
     * Randomly selects one of the three game modes available for the user to play
     */
    @Override
    public void onRandom(){
        //getQuestion();
        Random r = new Random();
        int i = r.nextInt(3);
        switch(i){
            case 0:
                onCategoriesMode();
                break;
            case 1:
                onWWM();
                break;
            case 2:
                onTrivialPursuit();
                break;
        }
        /*ActiveQuestion questionFragment = new ActiveQuestion(this);
        this.mainView.displayFragment(questionFragment, true, "first-question");*/
    }

    /**
     * Selects a random category of question for the user
     */
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

    @Override
    public void onTrivialPursuit(){
        curMode = "Trivial Pursuit";
        CategoriesModeFragment categoriesModeFragment = new CategoriesModeFragment(this);
        this.mainView.displayFragment(categoriesModeFragment,true,"category-mode");

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
        Log.d("curMode", curMode);
        switch(curMode){
            case "Who Wants To Be A Millionaire?":
                onWWM();
                break;
            case "Trivial Pursuit":
                onTrivialPursuit();
                break;
            case "Categories":
                onCategoriesMode();
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

        if(curMode.equals("tp")){
            CategoriesModeFragment categoriesModeFragment = new CategoriesModeFragment(this);
            this.mainView.displayFragment(categoriesModeFragment,true,"category-mode");
        }else{
            getQuestion();
            ActiveQuestion questionFragment = new ActiveQuestion(this);
            this.mainView.displayFragment(questionFragment, true, "not-fin-next");
        }

    }

    /**
     * Used in Game Info screen, allows user to get back to GameConfig Screen
     */
    @Override
    public void onGoBack(){
        resetGame();
        GameConfigFragment gameConfigFragment = new GameConfigFragment(this);
        this.mainView.displayFragment(gameConfigFragment, true, "back-to-menu");
        //resetGame();
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
            if(player.categoryScores.containsKey(curCategory)){
                player.addCategoryWin(curCategory);
            }else{
                player.categoryScores.put(curCategory, 1);
            }
            Log.d("Category and score", curCategory+ " :" + player.categoryScores.get(curCategory));
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