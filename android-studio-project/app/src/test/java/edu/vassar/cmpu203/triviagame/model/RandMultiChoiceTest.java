package edu.vassar.cmpu203.triviagame.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RandMultiChoiceTest {

    /**
     * Tests that getQuestion removes an element from RandMultiChoice's list by comparing the size,
     * and that it will return null if the list is empty
     */
    @Test
    void getQuestion() {
        RandMultiChoice r = new RandMultiChoice();
        int startLength = r.qp.size();
        Question q = r.getQuestion();
        assertEquals(startLength-1, r.qp.size());
        do{
            q = r.getQuestion();
        }while(q != null);

        assertEquals(null, q);
        assertEquals(0, r.qp.size());

    }
}