package com.example.team_2c_android;

import java.util.ArrayList;
import java.util.Collections;

public class RandMultiChoice implements IGameShow {
    ArrayList<Question> qp = new ArrayList<>();
    public RandMultiChoice(){

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

        Question q5 = new Question("By definition, where does an abyssopelagic animal live?", "easy","Animals","mcq",
                new Choice("On top of a mountain",false),new Choice("Inside a tree",false),
                new Choice("In the desert",false),new Choice("At the bottom of the ocean",true));
        qp.add(q5);

        Question q6 = new Question("Which of these countries borders People's Republic of China?", "hard", "Geography", "mcq",
                new Choice("Bangladesh",false),new Choice("Thailand",false),
                new Choice("Cambodia",false),new Choice("Tajikistan",true));
        qp.add(q6);

        Question q7 = new Question("Where in the world are bell peppers originally from?", "hard", "Food & Drink", "mcq",
                new Choice("Europe",false),new Choice("Central Asia",false),
                new Choice("China",false),new Choice("Central America",true));
        qp.add(q7);

        Question q8 = new Question("What did Wilhelm Roentgen discover in 1895?", "hard", "General Knowledge", "mcq",
                new Choice("Nuclear radiation",false),new Choice("The jet engine" ,false),
                new Choice("The Galapagos Islands",false),new Choice("X-rays",true));
        qp.add(q8);

        Question q9 = new Question("Which of these people was an Italian explorer who landed in America?", "easy", "Society & Culture", "mcq",
                new Choice("Marco Polo",false),new Choice("Martin Luther",false),
                new Choice("Napoleon Bonaparte",false),new Choice("Christopher Columbus",true));
        qp.add(q9);

        Question q10 = new Question("Which author wrote 'The Communist Manifesto'?", "medium", "Arts & Literature", "mcq",
                new Choice("Karl May",false),new Choice("Erich Maria Remarque",false),
                new Choice("Michael Ende",false),new Choice("Friedrich Engels",true));
        qp.add(q10);


        Question q11 = new Question("Which sport is played at The Billie Jean King Cup?", "medium", "Sports & Leisure", "mcq",
                new Choice("Athletics",false),new Choice("Motorsports",false),
                new Choice("Baseball",false),new Choice("Tennis",true));
        qp.add(q11);


        Question q12 = new Question("Conakry is the capital city of which country?", "hard", "Geography", "mcq",
                new Choice("Barbados",false),new Choice("Lebanon",false),
                new Choice("Romania",false),new Choice("Guinea",true));
        qp.add(q12);


        Question q13 = new Question("Which actor has starred in films including Gladiator and Her?", "medium", "Film & TV", "mcq",
                new Choice("Alan Cumming",false),new Choice("Roger Moore",false),
                new Choice("Peter O'Toole",false),new Choice("Joaquin Phoenix",true));
        qp.add(q13);

        Question q14 = new Question("Which horizon in a soil profile consists of bedrock?", "hard","Science & Nature","mcq",
                new Choice("O",false),new Choice("D",false),
                new Choice("B",false),new Choice("R",true));
        qp.add(q14);

        Question q15 = new Question("How many sovereign states are members of the United Nations?", "medium","Geography","mcq",
                new Choice("201",false),new Choice("178",false),
                new Choice("153",false),new Choice("195",true));
        qp.add(q15);

        Question q16 = new Question("How many federal states does Germany have?", "easy","Geography","mcq",
                new Choice("13",false),new Choice("25",false),
                new Choice("32",false),new Choice("16",true));
        qp.add(q16);

        Question q17 = new Question("The Pyrenees mountains are located on the border of which two countries?", "medium","Geography","mcq",
                new Choice("Italy and Switzerland",false),new Choice("Norway and Sweden",false),
                new Choice("Russia and Ukraine",false),new Choice("France and Spain",true));
        qp.add(q17);

        Question q18 = new Question("In the Morse code, which letter is indicated by 3 dots?", "medium","General Knowledge","mcq",
                new Choice("O",false),new Choice("A",false),
                new Choice("C",false),new Choice("S",true));
        qp.add(q18);

        Question q19 = new Question("Which one of the following rhythm games was made by Harmonix?", "easy","General Knowledge","mcq",
                new Choice("Meat Beat Mania",false),new Choice("Guitar Hero Live",false),
                new Choice("Dance Dance Revolution",false),new Choice("Rock Band",true));
        qp.add(q19);

        Question q20 = new Question("The website ”Shut Up & Sit Down” reviews which form of media?", "medium","General Knowledge","mcq",
                new Choice("Television Shows",false),new Choice("Video Games",false),
                new Choice("Films",false),new Choice("Board Games",true));
        qp.add(q20);

        Question q21 = new Question("What does film maker Dan Bell typically focus his films on?", "easy","Celebrities","mcq",
                new Choice("Historic Landmarks",false),new Choice("Action Films",false),
                new Choice("Documentaries",false),new Choice("Abandoned Buildings and Dead Malls",true));
        qp.add(q21);

        Question q22 = new Question("How tall is Tom Cruise?", "hard","Celebrities","mcq",
                new Choice("5’ 9",false),new Choice("5’ 4",false),
                new Choice("5’ 5",false),new Choice("5’ 7",true));
        qp.add(q22);

        Question q23 = new Question("How old was Muhammad Ali when he died?", "medium","Celebrities","mcq",
                new Choice("N/A (Still alive)",false),new Choice("61",false),
                new Choice("56",false),new Choice("74",true));
        qp.add(q23);

        Collections.shuffle(qp);
    }

    /*public Question getQuestion(){
        int randInd = (int)(Math.random() * qp.size());
        Question q = qp.get(randInd);
        qp.remove(randInd);
        return q;
    }

    public Question getQuestion(String category, String difficulty, String questionType){
        Collections.shuffle(qp);
        for(Question q: qp){
            if(q.category.equals(category) && q.difficulty.equals(difficulty) && q.questionType.equals(questionType)){
                return q;
            }
        }
        return null;
    }*/
}
