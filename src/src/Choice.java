package src.src;

public class Choice {
    String name;
    boolean correct;

    public Choice(String name, boolean correct){
        this.name = name;
        this.correct = correct;
    }

    public String toString(){
        return this.name;
    }

    public boolean getCorrect(){
        return correct;
    }
}
