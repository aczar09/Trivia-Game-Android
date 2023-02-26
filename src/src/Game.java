package src.src;

public class Game {
    int numGames;
    boolean correct = true;
    public Game(int numGames ){
        this.numGames = numGames;
    }
    public static void main(String[] args) {
        Game g = new Game(5);
        Player p1 = new Player();
        RandMultiChoice gameshow = new RandMultiChoice();
        int correctRecord = 0;
        while(g.numGames != correctRecord || g.correct){

        }
        if(g.correct){
            System.out.println("Congratulations");
        }else{
            System.out.println("Failure");
        }


    }
}