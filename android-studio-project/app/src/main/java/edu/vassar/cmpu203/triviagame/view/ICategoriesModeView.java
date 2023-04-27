package edu.vassar.cmpu203.triviagame.view;

public interface ICategoriesModeView {

    interface Listener{
        void onGeo();

        void onTV();

        void onHobbies();

        void onSports();
        void onGoBack();
    }
}
