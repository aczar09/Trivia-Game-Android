package edu.vassar.cmpu203.triviagame.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuestionTest {

    @Test
    void getCorrectChoice() {
        Question q1 = new Question("When was the first Call of Duty title released?", "hard","Entertainment","mcq",
                new Choice("December 1, 2003",false),new Choice("November 14, 2002",false),
                new Choice("July 18, 2004",false),new Choice("October 29, 2003",true));
        Choice correctChoice = q1.getCorrectChoice();
        assertTrue(correctChoice.correct);
    }

    @Test
    void isCorrect() {
        Question q1 = new Question("When was the first Call of Duty title released?", "hard","Entertainment","mcq",
                new Choice("December 1, 2003",false),new Choice("November 14, 2002",false),
                new Choice("July 18, 2004",false),new Choice("October 29, 2003",true));
        int correctChoiceInd = q1.getCorrectChoiceInd();
        assertTrue(q1.isCorrect(correctChoiceInd));
        int incorrectChoiceInd = q1.getCorrectChoiceInd() - 1;
        if (incorrectChoiceInd < 0)
            incorrectChoiceInd += 2;
        assertFalse(q1.isCorrect(incorrectChoiceInd));

    }
}