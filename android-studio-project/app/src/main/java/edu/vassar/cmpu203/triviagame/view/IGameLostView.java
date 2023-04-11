package edu.vassar.cmpu203.triviagame.view;

public interface IGameLostView {
    interface Listener {

        void onYes(); // called when user wants to go to next question

        void onMenu(); //called when user wants to go back to Menu

    }
}
