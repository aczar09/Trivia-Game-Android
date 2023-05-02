package edu.vassar.cmpu203.triviagame.model;

import android.os.Bundle;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.*;

public class Question {
    private static final String PROMPT = "prompt";

    private static final String DIFFICULTY = "difficulty";

    private static final String CATEGORY = "category";

    private static final String QUESTIONTYPE = "questiontype";
    private static final String CHOICES = "choices";


    String prompt;
    String difficulty;

    String category;
    String questionType;
    List<Choice> choices = new ArrayList<>();
    public Question(){}

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
        for(Choice c: choices){
            s += choiceLetter + ") " + c.toString() + "\n";
            choiceLetter++;
        }
        return s;
    }
    public String getPrompt(){
        return prompt;
    }

    /**
     * Returns the choice at a given index
     * @param i
     * @return Choice
     */
     public Choice getChoice(int i){
        if(i >= 0 && i < 4){
            return choices.get(i);
        }
        return null;
    }

    public String getCategory(){
         return category;
    }
    /**
     * Returns the correct Choice
     * @return Choice
     */

    public Choice getCorrectChoice(){
        for (int i = 0; i < 4; i++){
            Choice c = getChoice(i);
            if (c.getCorrect()){
                return c;
            }
        }
        return null;
    }

    /**
     * Returns index of correct Choice in a Question
     * @return int
     */

    public int getCorrectChoiceInd(){
        for (int i = 0; i < 4; i++){
            Choice c = getChoice(i);
            if (c.getCorrect()){
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns if the Choice at the given index is correct or not
     * @param selection
     * @return boolean
     */
    public boolean isCorrect(int selection){
        return choices.get(selection).getCorrect();
    }

    public Bundle toBundle(){
        final Bundle b = new Bundle();
        b.putString(PROMPT, this.prompt);
        b.putString(DIFFICULTY, this.difficulty);
        b.putString(CATEGORY, this.category);
        b.putString(QUESTIONTYPE, this.questionType);
        Bundle[] choiceBundle = new Bundle[this.choices.size()];
        int i = 0;
        for (Choice c: this.choices) choiceBundle[i++] = c.toBundle();
        b.putParcelableArray(CHOICES, choiceBundle);
        return b;
    }

    public static Question fromBundle(@NonNull Bundle b){
        final Question question = new Question();
        for(Parcelable choiceParcelable : b.getParcelableArray(CHOICES)){
            Choice c = Choice.fromBundle((Bundle) choiceParcelable);
            question.choices.add(c);
        }
        question.prompt = b.getString(PROMPT);
        question.difficulty = b.getString(DIFFICULTY);
        question.category = b.getString(CATEGORY);
        question.questionType = b.getString(QUESTIONTYPE);
        return question;
    }


}
