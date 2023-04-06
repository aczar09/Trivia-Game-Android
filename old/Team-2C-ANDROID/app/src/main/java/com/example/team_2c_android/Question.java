package com.example.team_2c_android;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;

public class Question {
    String prompt;
    String difficulty;

    String category;
    String questionType;
    ArrayList<Choice> choices = new ArrayList<>();

    public Question(String prompt, String difficulty, String category, String questionType, Choice c1, Choice c2, Choice c3, Choice c4){
        this.prompt = prompt;

        this.difficulty = difficulty;
        this.category = category;
        this.questionType = questionType;
        this.choices.add(c1);
        this.choices.add(c2);
        this.choices.add(c3);
        this.choices.add(c4);
        Collections.shuffle(choices);
    }

    @NonNull
    public String toString(){
        String s = this.category + ": \n";
        s += prompt +" \n";
        char choiceLetter = 'A';
        StringBuilder sBuilder = new StringBuilder(s);
        for(Choice c: choices){
            sBuilder.append(choiceLetter).append(") ").append(c.toString()).append("\n");
            choiceLetter++;
        }
        s = sBuilder.toString();
        return s;
    }

    public boolean isCorrect(int selection){
        return choices.get(selection).getCorrect();
    }

}
