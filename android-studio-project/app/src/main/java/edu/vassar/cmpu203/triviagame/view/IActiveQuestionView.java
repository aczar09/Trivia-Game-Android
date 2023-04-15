package edu.vassar.cmpu203.triviagame.view;

import edu.vassar.cmpu203.triviagame.model.Question;

public interface IActiveQuestionView {


    interface Listener{
        void onSubmit(boolean rightAns);

        int questionNumber();

        Question getQuestion();
        //void setCurQuestion();
    }
}
