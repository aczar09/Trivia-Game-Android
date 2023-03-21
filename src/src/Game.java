package src.src;

public class Game {
    int numGames;
    boolean correct = true;
    int correctRecord = 0;
    public Game(int numGames ){
        this.numGames = numGames;
    }

    public void resetGame(){
        correct = true;
        correctRecord = 0;
    }


    public String checkAnswer(Question q, int index){
        Choice c = q.choices.get(index);
        String s = "";
        if (c.correct){
            this.correctRecord++;
            s = "That's Right!!!";
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
            s = "Sorry wrong answer. The correct response was " + rindx + ". " + realAns.toString();
        }
        return s;
    }

}
