package src.src;

public interface IGameShow {
     Question getQuestion();
     Question getQuestion(String category, String difficulty, String questionType);
}
