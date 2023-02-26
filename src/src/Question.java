package src.src;

import java.util.ArrayList;
import java.util.*;

public class Question {
    String prompt;
    String difficulty;

    String category;
    String questionType;
    ArrayList<Choice> choices = new ArrayList<>();

    public Question(String prompt, String difficulty, String category, String questionType, Choice c1, Choice c2, Choice c3, Choice c4){
        this.prompt = prompt;

        this.choices.add(c1);
        this.choices.add(c2);
        this.choices.add(c3);
        this.choices.add(c4);
        Collections.shuffle(choices);
    }

    public String toString(){
        String s = prompt +" \n";
        char choiceLetter = 'A';
        for(Choice c: choices){
            s += choiceLetter + ") " + c.toString() + "\n";
            choiceLetter++;
        }
        return s;
    }

}
