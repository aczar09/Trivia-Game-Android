package edu.vassar.cmpu203.triviagame.view;

import edu.vassar.cmpu203.triviagame.model.Question;

public interface IQuestionView {

    interface Listener {


        //void onAnswerChoice();

        void onSubmit(boolean rightAns);

        void checkAnswer(Question question, int i);

        //void setCurQuestion();

        //String getPrompt();

        //String getChoice(int i);
    }
}
