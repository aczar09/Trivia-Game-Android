package src.src;
public class RandMultiChoice implements IGameShow {
    public Question pullQuestion(QuestionPool qp){
        Question q = qp.getQuestion();
        qp.removeQuestion(q);
        return q;
    }
}
