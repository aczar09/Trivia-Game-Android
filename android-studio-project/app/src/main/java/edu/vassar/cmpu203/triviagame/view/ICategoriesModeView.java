package edu.vassar.cmpu203.triviagame.view;

public interface ICategoriesModeView {

    interface Listener{
        void onGeo(); // for Geo mode

        void onTV(); // for TV mode

        void onHobbies(); // for Hobby mode

        void onSports(); // for Sport mode
        void onRandomCat(); // for Rand mode
        void onGoBack(); // for returning to GameConfig
    }
}
