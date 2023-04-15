package edu.vassar.cmpu203.triviagame.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuestionTest {

    @Test
    void testToString() {
        Question q1 = new Question("When was the first Call of Duty title released?", "hard","Entertainment","mcq",
                new Choice("December 1, 2003",false),new Choice("November 14, 2002",false),
                new Choice("July 18, 2004",false),new Choice("October 29, 2003",true));
        String s = q1.category + ": \n";
        s += q1.prompt +" \n";
        char choiceLetter = 'A';
        for(Choice c: q1.choices){
            s += choiceLetter + ") " + c.toString() + "\n";
            choiceLetter++;
        }
        assertEquals(s,q1.toString());

    }

    @Test
    void getPrompt() {
        Question q1 = new Question("When was the first Call of Duty title released?", "hard","Entertainment","mcq",
                new Choice("December 1, 2003",false),new Choice("November 14, 2002",false),
                new Choice("July 18, 2004",false),new Choice("October 29, 2003",true));
    }

    @Test
    void getChoice() {
        Question q1 = new Question("When was the first Call of Duty title released?", "hard","Entertainment","mcq",
                new Choice("December 1, 2003",false),new Choice("November 14, 2002",false),
                new Choice("July 18, 2004",false),new Choice("October 29, 2003",true));
    }

    @Test
    void getCorrectChoice() {
        Question q1 = new Question("When was the first Call of Duty title released?", "hard","Entertainment","mcq",
                new Choice("December 1, 2003",false),new Choice("November 14, 2002",false),
                new Choice("July 18, 2004",false),new Choice("October 29, 2003",true));
    }

    @Test
    void isCorrect() {
        Question q1 = new Question("When was the first Call of Duty title released?", "hard","Entertainment","mcq",
                new Choice("December 1, 2003",false),new Choice("November 14, 2002",false),
                new Choice("July 18, 2004",false),new Choice("October 29, 2003",true));

        assertTrue(q1.isCorrect(0));
    }
}