package edu.vassar.cmpu203.triviagame.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.vassar.cmpu203.triviagame.R;
import edu.vassar.cmpu203.triviagame.view.GameConfigFragment;
import edu.vassar.cmpu203.triviagame.view.IGameConfigView;
import edu.vassar.cmpu203.triviagame.view.IGameLostView;
import edu.vassar.cmpu203.triviagame.view.MainView;

public class MainActivity extends AppCompatActivity implements IGameConfigView.Listener, IGameLostView.Listener {

    private MainView mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mainView = new MainView(this);
        setContentView(R.layout.activity_main);
        this.mainView.displayFragment(new GameConfigFragment(this),true, "gameconfig");
    }
}