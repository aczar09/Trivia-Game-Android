package edu.vassar.cmpu203.triviagame.view;

import edu.vassar.cmpu203.triviagame.model.Choice;

public interface IGameLostView {
    interface Listener {

        void onPlayAgain(); // called when user wants to go to next question

        void onMenu(); //called when user wants to go back to Menu

        Choice rightAnswer();
    }
}
