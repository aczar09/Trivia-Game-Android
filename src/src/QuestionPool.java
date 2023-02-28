package src.src;

import java.util.ArrayList;
import java.util.Collections;

public class QuestionPool {
    ArrayList<Question> qp = new ArrayList<>();
    public QuestionPool(){

        Question q1 = new Question("When was the first Call of Duty title released?", "hard","Entertainment","mcq",
                new Choice("December 1, 2003",false),new Choice("November 14, 2002",false),
                new Choice("July 18, 2004",false),new Choice("October 29, 2003",true));
        qp.add(q1);

        Question q2 = new Question("Who is the main antagonist in the Portal franchise?", "easy","Entertainment","mcq",
                new Choice("Chell",false),new Choice("Wheatley",false),
                new Choice("Rick",false),new Choice("GLaDOS",true));
        qp.add(q2);

        Question q3 = new Question("The Internet Meme “All your base are belong to us” is based on the poorly translated English Version of which Video Game?", "hard","Entertainment","mcq",
                new Choice("Wing Commander",false),new Choice("Star Wars: X-Wing",false),
                new Choice("F-Zero",false),new Choice("Zero Wing",true));
        qp.add(q3);

        Question q4 = new Question("An organic compound is considered an alcohol if it has what functional group?", "hard","Science & Nature","mcq",
                new Choice("Carbonyl",false),new Choice("Aldehyde",false),
                new Choice("Alkyl",false),new Choice("Hydroxyl",true));
        qp.add(q4);

        Question q5 =  new Question("Who developed the first successful polio vaccine in the 1950s?", "medium","Science & Nature","mcq",
        new Choice("John F. Enders",false),new Choice("Thomas Weller",false),
                new Choice("Frederick Robbins",false),new Choice("Jonas Salk",true));
        qp.add(q5);

        Question q6 = new Question("Which horizon in a soil profile consists of bedrock?", "hard","Science & Nature","mcq",
                new Choice("O",false),new Choice("D",false),
                new Choice("B",false),new Choice("R",true));
        qp.add(q6);

        Question q7 = new Question("How many sovereign states are members of the United Nations?", "medium","Geography","mcq",
                new Choice("201",false),new Choice("178",false),
                new Choice("153",false),new Choice("195",true));
        qp.add(q7);
        Question q8 = new Question("How many federal states does Germany have?", "easy","Geography","mcq",
                new Choice("13",false),new Choice("25",false),
                new Choice("32",false),new Choice("16",true));
        qp.add(q8);

        Question q9 = new Question("The Pyrenees mountains are located on the border of which two countries?", "medium","Geography","mcq",
                new Choice("Italy and Switzerland",false),new Choice("Norway and Sweden",false),
                new Choice("Russia and Ukraine",false),new Choice("France and Spain",true));
        qp.add(q9);

        Question q10 = new Question("In the Morse code, which letter is indicated by 3 dots?", "medium","General Knowledge","mcq",
                new Choice("O",false),new Choice("A",false),
                new Choice("C",false),new Choice("S",true));
        qp.add(q10);

        Question q11 = new Question("Which one of the following rhythm games was made by Harmonix?", "easy","General Knowledge","mcq",
                new Choice("Meat Beat Mania",false),new Choice("Guitar Hero Live",false),
                new Choice("Dance Dance Revolution",false),new Choice("Rock Band",true));
        qp.add(q11);

        Question q12 = new Question("The website ”Shut Up & Sit Down” reviews which form of media?", "medium","General Knowledge","mcq",
                new Choice("Television Shows",false),new Choice("Video Games",false),
                new Choice("Films",false),new Choice("Board Games",true));
        qp.add(q12);

        Question q13 = new Question("What does film maker Dan Bell typically focus his films on?", "easy","Celebrities","mcq",
                new Choice("Historic Landmarks",false),new Choice("Action Films",false),
                new Choice("Documentaries",false),new Choice("Abandoned Buildings and Dead Malls",true));
        qp.add(q13);
        Question q14 = new Question("How tall is Tom Cruise?", "hard","Celebrities","mcq",
                new Choice("5’ 9",false),new Choice("5’ 4",false),
                new Choice("5’ 5",false),new Choice("5’ 7",true));
        qp.add(q14);
        Question q15 = new Question("How old was Muhammad Ali when he died?", "medium","Celebrities","mcq",
        new Choice("N/A (Still alive)",false),new Choice("61",false),
        new Choice("56",false),new Choice("74",true));
        qp.add(q15);


        Collections.shuffle(qp);
    }

    public Question getQuestion(){
        int randInd = (int)(Math.random() * qp.size());
        return qp.get(randInd);
    }

    public void removeQuestion(Question q){
        qp.remove(q);
    }

    public Question getQuestion(String category, String difficulty, String questionType){
        Collections.shuffle(qp);
        for(Question q: qp){
            if(q.category.equals(category) && q.difficulty.equals(difficulty) && q.questionType.equals(questionType)){
                return q;
            }
        }
        return null;
    }
}
