package edu.vassar.cmpu203.triviagame.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RandMultiChoiceTest {

    @Test
    void getQuestion() {
        RandMultiChoice r = new RandMultiChoice();
        int startLength = r.qp.size();
        Question q = r.getQuestion();
        assertEquals(startLength-1, r.qp.size());
    }
}