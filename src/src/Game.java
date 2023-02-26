package src.src;

import java.util.Scanner;

public class Game {
    int numGames;
    boolean correct = true;
    int correctRecord;
    public Game(int numGames ){
        this.numGames = numGames;
    }
    public static void main(String[] args) {
        Game g = new Game(5);
        Player p1 = new Player();
        RandMultiChoice gameshow = new RandMultiChoice();
        g.correctRecord = 0;
        while (g.numGames != correctRecord || g.correct) {

        }
        if (g.correct) {
            System.out.println("Congratulations");
        } else {
            System.out.println("Failure");
        }
    }
    public void checkAnswer(Question q, int index){
        Choice c = q.choices[index];
        if (c.correct){
            correctRecord++;
        }
        else{
            correct = false;
        }

    }


}
