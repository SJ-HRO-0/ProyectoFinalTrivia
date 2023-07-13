import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TriviaGameGUI {
    private final TriviaGame game;
    private JButton[] answerButtons;
    private JLabel questionLabel;

    public TriviaGameGUI(TriviaGame game) {
        this.game = game;
        initializeComponents();
    }

    private void initializeComponents() {
        JFrame frame = new JFrame("Trivia Game");
        questionLabel = new JLabel();
        answerButtons = new JButton[4];

        JPanel panel = new JPanel(new GridLayout(5, 1));
        panel.add(questionLabel);

        for (int i = 0; i < 4; i++) {
            answerButtons[i] = new JButton();
            answerButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleAnswerClick(e);
                }
            });
            panel.add(answerButtons[i]);
        }

        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void handleAnswerClick(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        // Guardar la respuesta correcta antes de cambiar de pregunta
        String correctAnswer = game.getCurrentQuestion().getCorrectAnswer();
        boolean correct = game.answerQuestion(clickedButton.getText());
        if (correct) {
            JOptionPane.showMessageDialog(null, "¡Correcto!");
        } else {
            JOptionPane.showMessageDialog(null, "Incorrecto, la respuesta correcta era " + correctAnswer);
        }
        if (game.isGameOver()) {
            JOptionPane.showMessageDialog(null, "Juego terminado, has obtenido " + game.getScore() + " puntos.");
        } else {
            loadQuestion();
        }
    }

    public void loadQuestion() {
        TriviaQuestion question = game.getCurrentQuestion();
        questionLabel.setText(question.getQuestionText());
        List<String> options = question.getOptions();
        for (int i = 0; i < options.size(); i++) {
            answerButtons[i].setText(options.get(i));
        }
    }

    public void startGame() {
        loadQuestion();
    }
}
