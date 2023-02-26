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

        Question q5 = new Question("By definition, where does an abyssopelagic animal live?", "easy","Animals","mcq",
        new Choice("On top of a mountain",false),new Choice("Inside a tree",false),
                new Choice("In the desert",false),new Choice("At the bottom of the ocean",true));
        qp.add(q5);

        Collections.shuffle(qp);
    }

    public Question getQuestion(){
        int randInd = (int)(Math.random() * qp.size())
        return qp.get(randInd);
    }

    public void removeQuestion(int index){
        qp.remove(index);
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
