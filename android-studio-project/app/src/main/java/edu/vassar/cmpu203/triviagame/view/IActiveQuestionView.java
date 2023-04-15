package edu.vassar.cmpu203.triviagame.view;

import edu.vassar.cmpu203.triviagame.model.Question;

public interface IActiveQuestionView {


    interface Listener{
        void onSubmit(int index);

        int questionNumber();

        Question getQuestion();

        //void checkAnswer(int i);
        //void setCurQuestion();
    }
}
