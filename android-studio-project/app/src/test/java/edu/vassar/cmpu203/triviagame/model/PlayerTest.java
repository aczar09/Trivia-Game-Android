package edu.vassar.cmpu203.triviagame.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerTest {

    /**
     * Tests that Player's answerStreak and questionNumber get updated by one everytime rightAns() is called
     */
    @Test
    void rightAns() {
        Player p = new Player();
        int aStart = p.answerStreak;
        int qStart = p.questionNumber;
        p.rightAns();
        assertEquals(aStart + 1, p.answerStreak);
        assertEquals(qStart + 1, p.questionNumber);

    }

    /**
     * Tests that Player's answerStreak and questionNumber is reset whenever resetStreak() is called
     */
    @Test
    void resetStreak() {
        Player p = new Player();
        int aStart = p.answerStreak;
        int qStart = p.questionNumber;
        p.rightAns();
        p.rightAns();
        p.rightAns();
        p.rightAns();
        p.rightAns();
        assertEquals(aStart + 5, p.answerStreak);
        assertEquals(qStart + 5, p.questionNumber);
        p.resetStreak();
        assertEquals(aStart, p.answerStreak);
        assertEquals(qStart, p.questionNumber);
    }
}