import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LearningSessionImpl {
    protected List<Flashcard> cards;
    protected Iterator<Flashcard> iterator;
    protected Flashcard currentCard;
    protected Scanner scanner = new Scanner(System.in);
    protected FlashcardStatistics statistics;

    public LearningSessionImpl(List<Flashcard> cards) {
        this.cards = cards;
        this.iterator = cards.iterator();
        this.statistics = new FlashcardStatistics();
    }

    public void startLearning(FlashcardDeck deck) {
        System.out.println("Willkommen zum Karteikarten-Lernen!");

        while (iterator.hasNext()) {
            currentCard = iterator.next();

            askQuestion();
        }

        displayStatistics();
    }

    protected void askQuestion() {

    }

    public void displayStatistics() {
        System.out.println("Lernstatistiken:");
        System.out.println("Gesamtanzahl Fragen: " + statistics.getTotalQuestions());
        System.out.println("Korrekte Antworten: " + statistics.getCorrectAnswers());
        System.out.println("Inkorrekte Antworten: " + statistics.getIncorrectAnswers());
    }
}
