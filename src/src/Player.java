package src.src;

import java.util.Scanner;

public class Player {
    String name;
    int wins = 0;

    public Player(String name) {
        this.name = name;
    }

    public Player() {
        this.name = "Player 1";
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