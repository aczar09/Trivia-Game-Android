package edu.vassar.cmpu203.triviagame.model;

import android.content.res.AssetManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandMultiChoice implements IGameShow {
    Map<String,List<Question>> qp = new HashMap<>();
    boolean testMode = false;
    public RandMultiChoice(AssetManager assets) /*throws Exception*/ {

        if(!testMode){
            QuestionDatabase qd = new QuestionDatabase(assets);
            qp = qd.database;
        }


        /*Question q1 = new Question("When was the first Call of Duty title released?", "hard","Entertainment","mcq",
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
*/

        //Collections.shuffle(database);
    }

    public RandMultiChoice()
    {
        List<Question> geoQs = new ArrayList<>();
        Question q1 = new Question("What is the capital of Afghanistan?", "Geography",
                new Choice("Tirana", false),
                new Choice("Kabul", true),
                new Choice("Dushanbe", false),
                new Choice("Tashkent", false));
        geoQs.add(q1);

        Question q2 = new Question("What is the capital of Australia?", "Geography",
                new Choice("Canberra", true),
                new Choice("Sydney", false),
                new Choice("Melbourne", false),
                new Choice("Ottawa", false));
        geoQs.add(q2);

        Question q3 = new Question("What is the capital of Belgium?", "Geography",
                new Choice("Amsterdam", false),
                new Choice("Luxemburg", false),
                new Choice("Brussels", true),
                new Choice("Stockholm", false));
        geoQs.add(q3);

        Question q4 = new Question("What is the capital of Greece?", "Geography",
                new Choice("Ankara", false),
                new Choice("Athens", true),
                new Choice("Sofia", false),
                new Choice("Thessaloniki", false));
        geoQs.add(q4);

        Question q5 = new Question("What is the capital of Italy?", "Geography",
                new Choice("Venice", false),
                new Choice("Rome", true),
                new Choice("Naples", false),
                new Choice("Milan", false));
        geoQs.add(q5);
        qp.put("geography",geoQs);

        List<Question> hobbiesQs = new ArrayList<>();
        Question q6 = new Question("Its your first day on the job at your favorite diner! The waitress next to you yells out to the short order cook that she needs two cows, make them cry, and paint em red. What has she requested the short order cook to prepare?", "Hobbies",
                new Choice("Two hamburgers with onions, cover in ketchup", true),
                new Choice("Two orders of beef liver and onions with ketchup", false),
                new Choice("Salisbury steak with American sauce", false),
                new Choice("Double cheeseburger, no onions, special sauce", false));
        hobbiesQs.add(q6);

        Question q7 = new Question("Your friend's favorite breakfast is a shingle with shimmy and shake, squeeze one. What does he like to eat for breakfast?", "Hobbies",
                new Choice("French toast and apple juice", false),
                new Choice("Link sausage, toast and juice", false),
                new Choice("Buttered toast with jam and orange juice", true),
                new Choice("Short stack of pancakes and instant coffee", false));
        hobbiesQs.add(q7);

        Question q8 = new Question("A guy orders a drag it through Georgia for his son. What has he ordered?", "Hobbies",
                new Choice("Fried chicken basket", false),
                new Choice("Chili dog, all the way", false),
                new Choice("A slice of key lime pie", false),
                new Choice("Cola with chocolate syrup", true));
        hobbiesQs.add(q8);

        Question q9 = new Question("What is diner-speak for an order of hash?", "Hobbies",
                new Choice("Burn the British", false),
                new Choice("Gravel train", false),
                new Choice("Customer will take a chance", true),
                new Choice("Pittsburgh", false));
        hobbiesQs.add(q9);

        Question q10 = new Question("Mom always told you to get plenty of iron in your diet, so you order a put out the lights and cry. What item have you ordered?", "Hobbies",
                new Choice("Patty melt, no onions", false),
                new Choice("Ham on rye with soup", false),
                new Choice("T-Bone steak with onions", false),
                new Choice("Liver and onions", true));
        hobbiesQs.add(q10);
        qp.put("hobbies",hobbiesQs);

        List<Question> tvQs = new ArrayList<>();

        Question q11 = new Question("What was the name of Darrin Stephens's boss on Bewitched?", "Television",
                new Choice("Larry Strait", false),
                new Choice("Larry Tate", true),
                new Choice("Larry Anderson", false),
                new Choice("Larry Mac Quade", false));
        tvQs.add(q11);

        Question q12 = new Question("Who was the second actor to portray Darrin Stephens on the hit sitcom Bewitched?", "Television",
                new Choice("Dick York", false),
                new Choice("Dick Sargent", true),
                new Choice("Dick Colonel", false),
                new Choice("Dick Goodman", false));
        tvQs.add(q12);

        Question q13 = new Question("What year did the long-running sitcom Bewitched leave the airwaves?", "Television",
                new Choice("1975", false),
                new Choice("1977", false),
                new Choice("1973", false),
                new Choice("1972", true));
        tvQs.add(q13);

        Question q14 = new Question("This 1999 movie, starring Adam Sandler, is about a single guy who adopts the child of his friend in order to impress his ex-girlfriend.", "Television",
                new Choice("Big Daddy", true),
                new Choice("Whos Your Daddy", false),
                new Choice("Daddy Day Care", false),
                new Choice("Fathers Day", false));
        tvQs.add(q14);

        Question q15 = new Question("This 1981 movie depicts the life of of a famous actress as seen through the eyes of her adopted daughter.", "Television",
                new Choice("Mommy Dearest", true),
                new Choice("Father of the Bride", false),
                new Choice("Serial Mom", false),
                new Choice("Daddy Day Care", false));
        tvQs.add(q15);
        qp.put("television",tvQs);

        List<Question> sportsQs = new ArrayList<>();
        Question q16 = new Question("On June 28, 1907, this Yankees catcher was unable to throw out any of the 13 Washington Senators who stole second base.", "Sports",
                new Choice("Branch Rickey", true),
                new Choice("Branch Rickey", false),
                new Choice("John McGraw", false),
                new Choice("Casey Stengel", false));
        sportsQs.add(q16);

        Question q17 = new Question("In 1960, the New York Yankees set a record for having three catchers each of whom hit at least twenty home runs. Who were they?", "Sports",
                new Choice("Yogi Berra, Elston Howard, Johnny Blanchard", true),
                new Choice("Yogi Berra, Elston Howard, Thurmon Munson", false),
                new Choice("Yogi Berra, Sammy White, Elston Howard", false),
                new Choice("Yogi Berra, Elston Howard, Hank Bauer", false));
        sportsQs.add(q17);

        Question q18 = new Question("In what year did baseball catchers first started using chest protectors?", "Sports",
                new Choice("1885", true),
                new Choice("1895", false),
                new Choice("1915", false),
                new Choice("1905", false));
        sportsQs.add(q18);

        Question q19 = new Question("Which company was the first to start producing catchers mitts?", "Sports",
                new Choice("Draper and Maynard", true),
                new Choice("Bresnahan", false),
                new Choice("Wilson", false),
                new Choice("Rawlings", false));
        sportsQs.add(q19);

        Question q20 = new Question("In 1914, this catcher broke the record for throwing out base runners in an inning.", "Sports",
                new Choice("Les Nunamaker", true),
                new Choice("Steve ONeil", false),
                new Choice("Muddy Reul", false),
                new Choice("Bill Dickey", false));
        sportsQs.add(q20);
        qp.put("sports",sportsQs);


    }

    /**
     * Returns a random Question from the list of Questions and removes from the list
     * @return Question
     */
    public Question getQuestion(){
        if(qp.size() == 0){
            return null;
        }
        List<String> keysAsArray = new ArrayList<>(qp.keySet());
        Random r = new Random();
        List<Question> categoryQ = qp.get(keysAsArray.get(r.nextInt(keysAsArray.size())));
        Collections.shuffle(categoryQ);
        return categoryQ.get(0);
    }

    public Question getQuestion(String category){
        /*if(qp.size() == 0){
            return null;
        }
        while(true){
            int randInd = (int)(Math.random() * qp.size());
            if(qp.get(randInd).getCategory().equals(category)){
                Question q = qp.get(randInd);
                qp.remove(randInd);
                return q;
            }


        }*/

        try{
            List<Question> categoryQ = qp.get(category.toUpperCase());
            Collections.shuffle(categoryQ);
            Question q = categoryQ.get(0);
            categoryQ.remove(0);
            return q;
        }catch (Exception e){
            Log.d("invalid category", "Invalid/Empty category");
        }


        return null;
    }
    /**
     * Searches for a Question based on String search, and returns Question if found in list
     * @param search
     * @return Question
     */
    public Question searchQuestion(String search, String category){

        try{
            List<Question> categoryQ = qp.get(category.toUpperCase());
            for(Question q: categoryQ){
                if(q.getPrompt().equals(search)){
                    return q;
                }
            }
        }catch (Exception e){
            Log.d("invalid category", "Invalid/Empty category");
        }


        return null;
    }
/*
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
