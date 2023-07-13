import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TriviaQuestionBuilder {
    private final List<TriviaQuestion> questions;

    public TriviaQuestionBuilder() {
        this.questions = new ArrayList<>();
        // Adding questions directly in the constructor
        addQuestion("¿Cuándo acabó la II Guerra Mundial?", "1945", "1944", "1946", "1950");
        addQuestion("¿Cuál era el apellido de la reina Isabel II de Inglaterra?", "Windsor", "White", "Wyndham", "Amery");
        addQuestion("¿En qué año se aprobó la actual Constitución española?", "1978", "1981", "1974", "1976");
        addQuestion("¿En qué año murió Freddie Mercury?", "1991", "1990", "1989", "1987");
        addQuestion("¿Qué día es la fiesta nacional de Estados Unidos?", "4 de julio", "31 de mayo", "6 de diciembre", "9 de febrero");
        addQuestion("¿Quién inventó la bombilla?", "Thomas Edison", "Nikola Tesla", "Luigi Galvani", "Alessandro Volta");
        addQuestion("¿En qué país se usó la primera bomba atómica?", "Japón", "EEUU", "Rusia", "China");
        addQuestion("¿Cuándo empezó la Primera Guerra Mundial?", "1914", "1912", "1915", "1920");
        addQuestion("¿En qué año se produjo la Revolución Francesa?", "1789", "1780", "1788", "1791");
        addQuestion("¿En qué año viajó al espacio el primer ser humano?", "1961", "1975", "1969", "1973");
        addQuestion("¿En qué año llegó Cristóbal Colón a América?", "1492", "1495", "1493", "1490");
        addQuestion("¿En qué año cayó el muro de Berlín?", "1989", "1990", "1985", "1992");
        addQuestion("¿En qué año fue asesinado Abraham Lincoln?", "1865", "1862", "1866", "1861");
        addQuestion("¿En qué año se hundió el Titanic?", "1912", "1910", "1913", "1915");
        addQuestion("¿Con cuántos años murió la Reina Isabel II?", "96 años", "101 años", "106 años", "99 años");
        addQuestion("¿Cuál fue el primer metal que el hombre empleó?", "El cobre", "El hierro", "El bronce", "El oro");
        addQuestion("¿En qué año abdicó el rey Juan Carlos I?", "2014", "2017", "2018", "2015");
        addQuestion("¿En qué continente surgió la Humanidad?", "África", "Europa", "Asia", "Norte América");
        addQuestion("¿En qué año cayó el Imperio Romano?", "476", "479", "472", "470");
        addQuestion("¿En qué año murió Napoleón?", "1821", "1819", "1816", "1824");
    }

    public void addQuestion(String questionText, String correctAnswer, String... wrongAnswers) {
        List<String> options = new ArrayList<>();
        options.add(correctAnswer);
        options.addAll(Arrays.asList(wrongAnswers));
        Collections.shuffle(options);
        TriviaQuestion question = new TriviaQuestion(questionText, options, correctAnswer);
        questions.add(question);
    }

    public List<TriviaQuestion> getQuestions() {
        return questions;
    }
}
