public class main {
    public static void main(String[] args) {
        TriviaQuestionBuilder builder = new TriviaQuestionBuilder();
        TriviaGame game = new TriviaGame(builder.getQuestions());
        TriviaGameGUI gui = new TriviaGameGUI(game);
        gui.startGame();
    }
}