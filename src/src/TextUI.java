package src.src;

import java.util.Scanner;

public class TextUI {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Pablo and Alex's CMPU 203 Trivia Game!\n Try answering 5 questions correctly in a row");
        Game g = new Game(1);
        int gcount = 0;
        while(gcount < g.numGames){
            boolean hasPlayerWon = g.playSingleGame();
            boolean isCorrectAnswer = g.checkAnswer();
            if (isCorrectAnswer){
                g.correctRecord++;
                System.out.println("That's Right!!!");
            }
            else{
                g.correct = false;
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
                System.out.println("Sorry wrong answer. The correct response was " + rindx + ") " + realAns.toString());
            }

            if(hasPlayerWon){
                System.out.println("Congratulations!! You successfully answered all " + g.correctRecord + " questions! You're a trivia master!");
            }else{
                System.out.println("GAME OVER" + "\nYou got " + g.correctRecord + " question(s) right! Better luck next time!");
            }
            g.resetGame();
            gcount++;
        }


    }
}
