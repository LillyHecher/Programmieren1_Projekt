
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class LearningSessionImpl implements LearningSession{

    private Iterator<Flashcard> cardIterator;
    private Flashcard currentCard;
    private Scanner scanner;
    private int questionConter;
    private FlashcardStatistics statistics;

    public LearningSessionImpl(List<Flashcard> cards) {
        this.cardIterator = cards.iterator();
        this.scanner = new Scanner(System.in);
        this.questionConter = 0;
        this.statistics = new FlashcardStatistics();
    }

    @Override
    public void startLearning(FlashcardDeck deck) {
        System.out.println("Willkommen, lass uns lernen!");

        // Starte mit der ersten Karte
        if (cardIterator.hasNext() && questionConter < 30) {
            currentCard = cardIterator.next();
            askQuestion();
        } else {
            System.out.println("Die Runde ist beendet.");
        }
    }

    private void askQuestion() {
        System.out.println("Frage: " + currentCard.getQuestion());
        System.out.print("Ihre Antwort: ");
        String userAnswer = scanner.nextLine();

        if (checkAnswer(userAnswer)) {
            System.out.println("Richtig!\n");
        } else {
            System.out.println("Falsch. Die richtige Antwort ist: " + currentCard.getAnswer() + "\n");
        }

        questionConter ++;

        // Nächste Karte anzeigen
        if (cardIterator.hasNext() && questionConter < 30) {
            currentCard = cardIterator.next();
            askQuestion();
        } else {
            System.out.println("Das Lernen ist abgeschlossen. Gute Arbeit!");
        }
    }
    protected abstract void askQuestion();

    private void displayStatistics() {
        System.out.println("Lernstatistiken:");
        System.out.println("Gesamtanzahl Fragen: " + statistics.getTotalQuestions());
        System.out.println("Korrekte Antworten: " + statistics.getCorrectAnswers());
        System.out.println("Inkorrekte Antworten: " + statistics.getIncorrectAnswers());
    }

    @Override
    public String getQuestion() {
        return currentCard.getQuestion();
    }

    @Override
    public boolean checkAnswer(String userAnswer) {
        return userAnswer.equalsIgnoreCase(currentCard.getAnswer());
    }
}
