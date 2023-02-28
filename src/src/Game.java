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

    public static void main(String[] args) {
        Game g = new Game(1);
        int gcount = 0;
        while(gcount < g.numGames){
            g.playSingleGame();
            gcount++;
        }
        //
        // Player p1 = new Player();
        // RandMultiChoice gameshow = new RandMultiChoice();
        // g.correctRecord = 0;
        // while (g.numGames != g.correctRecord || g.correct) {

        // }
        // if (g.correct) {
        // System.out.println("Congratulations");
        // } else {
        // System.out.println("Failure");
        // }
    }

    public void checkAnswer(Question q, int index){
        Choice c = q.choices.get(index);
        if (c.correct){
            this.correctRecord++;
            System.out.println("That's Right!!!");
        }
        else{
            this.correct = false;
            Choice realAns = null;
            char rindx = 65;
            for (int i = 0; i < q.choices.size(); i++){
                Choice search = q.choices.get(i);
                if (search.correct){
                    realAns = search;
                    rindx += i;
                    break;
                }
            }
            System.out.println("Sorry wrong answer. The correct response was " + rindx + ". " + realAns.toString());
        }
    }

    public void playSingleGame(){
        Player p1 = new Player();
        //QuestionPool qp = new QuestionPool();
        QuestionPool qp = new QuestionPool();
        while((this.correct) && (this.correctRecord < 5)){
            Question qt = qp.getQuestion();
            System.out.println(qt.toString());
            int ans = p1.getAnswer();
            this.checkAnswer(qt, ans);
        }
        if (!this.correct){
            System.out.print("GAME OVER" + "\nYou got " + correctRecord+ " question(s) right! Better luck next time!");
        }
        else{
            System.out.print("Congratulations!! You successfully answered all " + correctRecord + " questions! You're a trivia master!");
        }
    }
