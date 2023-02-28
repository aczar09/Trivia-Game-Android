package src.src;

import src.src.Player;
import src.src.Question;
import src.src.RandMultiChoice;

import java.awt.*;

public class Game {
    static int numGames = 1;
    boolean correct = true;
    int correctRecord = 0;
    public Game(int numGames ){
        this.numGames = numGames;
    }


    public boolean checkAnswer(Question q, int index){
        Choice c = q.choices.get(index);
        return c.correct;
//        if (c.correct){
//            this.correctRecord++;
//            System.out.println("That's Right!!!");
//        }
//        else{
//            this.correct = false;
//            Choice realAns = null;
//            char rindx = 65;
//            for (int i = 0; i < q.choices.size(); i++){
//                Choice search = q.choices.get(i);
//                if (search.correct){
//                    realAns = search;
//                    rindx += i;
//                    break;
//                }
//            }
//            System.out.println("Sorry wrong answer. The correct response was " + rindx + ") " + realAns.toString());
//        }
    }

    public boolean playSingleGame() {
        Player p1 = new Player();
        //QuestionPool qp = new QuestionPool();
        QuestionPool qp = new QuestionPool();
        while ((this.correct) && (this.correctRecord < 5)) {
            Question qt = qp.getQuestion();
            System.out.println(qt);
            int ans = p1.getAnswer();
            this.checkAnswer(qt, ans);
        }
        return this.correct;
        /*if (!this.correct) {
            S
        } else {

        }*/
    }

    public void resetGame(){
        correct = true;
        correctRecord = 0;
    }
}
