package edu.vassar.cmpu203.triviagame.model;

import android.os.Bundle;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Choice implements Serializable {
    private static final String NAME = "name";
    private static final String CORRECT = "correct";
    String name;
    boolean correct;

    public Choice(){}

    public Choice(String name, boolean correct){
        this.name = name;
        this.correct = correct;
    }

    public String toString(){
        return this.name;
    }

    public boolean getCorrect(){
        return correct;
    }

    public Bundle toBundle(){
        final Bundle b = new Bundle();
        b.putString(NAME, this.name);
        b.putBoolean(CORRECT, this.correct);
        return b;
    }

    public static Choice fromBundle(@NonNull Bundle b){
        final Choice c = new Choice();
        c.name = b.getString(NAME);
        c.correct = b.getBoolean(CORRECT);
        return c;
    }
}
