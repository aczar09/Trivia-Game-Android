package edu.vassar.cmpu203.triviagame.model;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.*;

public class Question {
    String prompt;
    String difficulty;

    String category;
    String questionType;
    List<Choice> choices = new ArrayList<>();

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

}
