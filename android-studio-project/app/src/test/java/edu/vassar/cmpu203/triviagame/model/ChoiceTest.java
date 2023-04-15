package edu.vassar.cmpu203.triviagame.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ChoiceTest {

    @Test
    void testToString() {
        Choice c1 = new Choice("GLaDOS",true);
    }

    @Test
    void getCorrect() {
        new Choice("GLaDOS",true);
    }
}