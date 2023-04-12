package edu.vassar.cmpu203.triviagame.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.vassar.cmpu203.triviagame.R;
import edu.vassar.cmpu203.triviagame.view.GameConfigFragment;
import edu.vassar.cmpu203.triviagame.view.Game_Mode_Fragment;
import edu.vassar.cmpu203.triviagame.view.IGameConfigView;
import edu.vassar.cmpu203.triviagame.view.IGameLostView;
import edu.vassar.cmpu203.triviagame.view.IMainView;
import edu.vassar.cmpu203.triviagame.view.IQuestionView;
import edu.vassar.cmpu203.triviagame.view.MainView;
import edu.vassar.cmpu203.triviagame.view.QuestionFragment;

public class MainActivity extends AppCompatActivity implements IGameConfigView.Listener, IGameLostView.Listener {

    private IMainView mainView; // a reference to the main screen template

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mainView = new MainView(this);
        this.setContentView(mainView.getRootView());
        this.mainView.displayFragment(new GameConfigFragment(this),true, "game-config");
    }

    /**
     * Takes the user to the first question screen fragment
     */
    @Override
    public void onWWM(){
        QuestionFragment questionFragment = new QuestionFragment();
        this.mainView.displayFragment(questionFragment, false, "first-question");
    }

    /**
     * This currently will only do the same as onWMM, but next iteration, when we add an additional
     * game mode it should be implemented
     */
    @Override
    public void onRandom(){
        QuestionFragment questionFragment = new QuestionFragment();
        this.mainView.displayFragment(questionFragment, false, "first-question");
    }

    /**
     * Takes user to the more_info slide
     */
    @Override
    public void onMoreInfo(){
        Game_Mode_Fragment game_mode_fragment = new Game_Mode_Fragment();
        this.mainView.displayFragment(game_mode_fragment, false, "info-slide");
    }
}