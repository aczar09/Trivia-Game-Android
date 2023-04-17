package edu.vassar.cmpu203.triviagame.model;

public class Player {
    String name;
    int wins = 0;
    public int answerStreak = 0;
    public int questionNumber = 1;

    public Player(String name) {
        this.name = name;
    }

    public Player() {
        this.name = "Player 1";
    }

    /**
     * Increments the answerStreak and questionNumber by 1
     */
    public void rightAns(){
        answerStreak++;
        questionNumber++;
    }

    /**
     * Sets the answerStreak to 0 and questionNumber to 1, their original values
     */
    public void resetStreak(){
        answerStreak = 0;
        questionNumber = 1;
    }

}