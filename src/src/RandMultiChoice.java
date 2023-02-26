package src.src;
public class RandMultiChoice implements IGameShow {
    public Question pullQuestion(QuestionPool qp){
        return qp.getQuestion();
    }
}
