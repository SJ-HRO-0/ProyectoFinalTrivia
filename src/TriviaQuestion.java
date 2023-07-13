import java.util.List;

public class TriviaQuestion {
    private String questionText;
    private List<String> options;
    private String correctAnswer;

    public TriviaQuestion(String questionText, List<String> options, String correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean checkAnswer(String answer) {
        return answer.equals(correctAnswer);
    }
}
