package edu.vassar.cmpu203.triviagame.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.vassar.cmpu203.triviagame.R;
import edu.vassar.cmpu203.triviagame.view.MainView;

public class MainActivity extends AppCompatActivity {

    private MainView mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mainView = new MainView(this);
        setContentView(R.layout.activity_main);
    }
}