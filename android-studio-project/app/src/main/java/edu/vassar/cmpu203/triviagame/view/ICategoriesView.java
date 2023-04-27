package edu.vassar.cmpu203.triviagame.view;

public interface ICategoriesView {

    interface Listener{
        void onGeo(); // needs to be called when player chooses Geography mode

        void onTV(); // needs to be called when player chooses TV mode


        void onGoBack(); // needs to be called when player clicks go back button
    }
}
