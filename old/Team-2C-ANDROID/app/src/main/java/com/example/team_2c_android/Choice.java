package com.example.team_2c_android;

import androidx.annotation.NonNull;

public class Choice {
    String name;
    boolean correct;

    public Choice(String name, boolean correct){
        this.name = name;
        this.correct = correct;
    }

    @NonNull
    public String toString(){
        return this.name;
    }

    public boolean getCorrect(){
        return correct;
    }
}