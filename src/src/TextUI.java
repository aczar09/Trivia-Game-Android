package src.src;

import java.util.Scanner;

public class TextUI {
    public static void main(String[] args) {
        TextUI ui = new TextUI();
        Game g = new Game(5);
        int gcount = 0;
        while(gcount < Game.numGames){
            ui.playSingleGame(g);
            g.resetGame();
            gcount++;
        }
    }

    public void playSingleGame(Game g){

        Player p1 = new  Player();
        //QuestionPool qp = new QuestionPool();
        RandMultiChoice rmc = new RandMultiChoice();
        while((g.correct) && (g.correctRecord < 5)){
            Question qt = rmc.getQuestion();
            System.out.println(qt.toString());
            int ans = this.getAnswer();
            System.out.println(g.checkAnswer(qt, ans));
        }
        if (!g.correct){
            System.out.println("GAME OVER" + "\nYou got " + g.correctRecord+ " question(s) right! Better luck next time!");
        }
        else{
            System.out.println("Congratulations!! You succesfully answered all " + g.correctRecord + " questions! You're a trivia master!");
        }


    }

    public int getAnswer() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            String ans = scan.nextLine();
            ans = ans.toUpperCase();
            switch (ans) {
                case "A":
                    return 0;
                case "B":
                    return 1;
                case "C":
                    return 2;
                case "D":
                    return 3;
                default:
                    System.out.println("Invalid Answer, Please try again.");
            }
        }
    }
}
