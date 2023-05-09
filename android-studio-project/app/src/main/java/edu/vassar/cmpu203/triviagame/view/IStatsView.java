package edu.vassar.cmpu203.triviagame.view;

public interface IStatsView {

    interface Listener{


        void onGoBack();

        String getBestCategory();

        String getBestMode();

        String getNumberWins();

        String getNumberQuestionsCorrect();
    }

}
