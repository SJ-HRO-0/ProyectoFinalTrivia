import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
public class TriviaGame {
    private final List<TriviaQuestion> questions;
    private int currentQuestionIndex;
    private int score;
    private int questionsAsked;
    private String lastCorrectAnswer;

    public TriviaGame(List<TriviaQuestion> questions) {
        this.questions = new ArrayList<>(questions);
        Collections.shuffle(this.questions); // Mezcla las preguntas
        this.currentQuestionIndex = 0; // Comienza desde la primera pregunta
        this.score = 0;
        this.questionsAsked = 0;
        this.lastCorrectAnswer = getCurrentQuestion().getCorrectAnswer();
    }

    public TriviaQuestion getCurrentQuestion() {
        return questions.get(currentQuestionIndex);
    }

    public String getLastCorrectAnswer() {
        return lastCorrectAnswer;
    }

    public void nextQuestion() {
        currentQuestionIndex++;
        questionsAsked++;
        if (currentQuestionIndex < questions.size()) {
            lastCorrectAnswer = getCurrentQuestion().getCorrectAnswer();
        }
    }

    public boolean checkAnswer(String answer) {
        return getCurrentQuestion().getCorrectAnswer().equals(answer);
    }

    public boolean answerQuestion(String answer) {
        boolean correct = checkAnswer(answer);
        if (correct) {
            score++;
        }
        if (!isGameOver()) {
            nextQuestion();
        }
        return correct;
    }

    public boolean isGameOver() {
        return questionsAsked >= questions.size();
    }

    public int getScore() {
        return score;
    }
}
