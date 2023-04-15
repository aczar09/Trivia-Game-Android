package edu.vassar.cmpu203.triviagame;

public interface IActiveQuestionView {
    interface Listener{
        void onSubmit(boolean rightAns);

        int questionNumber();
    }
}
