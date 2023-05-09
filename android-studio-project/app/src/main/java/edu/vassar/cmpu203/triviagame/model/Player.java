package edu.vassar.cmpu203.triviagame.model;

import android.os.Bundle;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.HashMap;

public class Player implements Serializable {
    private static final String NAME = "name";
    private static final String WINS = "wins";
    private static final String ANSTREAK = "anstreak";
    String name;
    int wins = 0;
    public int answerStreak = 0;
    public int questionNumber = 1;

    public int totalQuestionsCorrect = 0;
    public int totalWins = 0;
    public HashMap<String, Integer> categoryScores = new HashMap<>();

    public HashMap<String, Integer> modeScores = new HashMap<>();
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
        totalQuestionsCorrect++;
        questionNumber++;
    }

    public void addWin(){
        totalWins++;
    }
    /**
     * Sets the answerStreak to 0 and questionNumber to 1, their original values
     */
    public void resetStreak(){
        answerStreak = 0;
        questionNumber = 1;
    }

    public void addCategoryWin(String category){
        Integer score = categoryScores.get(category);
        categoryScores.put(category,score + 1);
    }

    public void addModeWin(String mode){
        Integer score = categoryScores.get(mode);
        categoryScores.put(mode,score + 1);
    }
    public String getName(){
        return this.name;
    }

    public int getWins(){return this.wins;}

    public int getAnswerStreak(){return this.answerStreak;}

    public Bundle toBundle(){
        final Bundle b = new Bundle();
        b.putString(NAME ,this.name);
        b.putInt(WINS, this.wins);
        b.putInt(ANSTREAK, this.answerStreak);
        return b;
    }

    public static Player fromBundle(@NonNull Bundle b){
        final Player player= new Player();
        String nameBundle = b.getString(NAME);
        int winBundle = b.getInt(WINS);
        int streakBundle = b.getInt(ANSTREAK);
        player.name = nameBundle;
        player.wins = winBundle;
        player.answerStreak = streakBundle;
        player.questionNumber = streakBundle + 1;
        return player;
    }

}