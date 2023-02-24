package src.src;

public class Question {
    String prompt;
    Choice [] choices;

    public Question(String prompt, Choice c1, Choice c2, Choice c3, Choice c4){
        this.prompt = prompt;
        this.choices = new Choice[]{c1, c2, c3, c4};
    }

    public String toString(){
        String s = prompt +" \n";
        char choiceLetter = 'A';
        for(Choice c: choices){
            s += choiceLetter + ") " + c.toString() + "\n";
            choiceLetter++;
        }
        return s;
    }

}
