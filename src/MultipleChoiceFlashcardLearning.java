import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MultipleChoiceFlashcardLearning extends LearningSessionImpl {
    public MultipleChoiceFlashcardLearning(List<Flashcard> cards) {
        super(cards);
    }

    @Override
    protected void askQuestion() {
        System.out.println("Frage: " + currentCard.getQuestion());

        if (currentCard instanceof MultipleChoiceFlashcard) {
            MultipleChoiceFlashcard mcCard = (MultipleChoiceFlashcard) currentCard;
            List<String> choices = mcCard.getChoices();

            // Anzeigen der Antwortmöglichkeiten
            for (int i = 0; i < choices.size(); i++) {
                System.out.println((i + 1) + ". " + choices.get(i));
            }

            System.out.print("Wählen Sie die richtige Antwort (1-" + choices.size() + "): ");
            int userChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Überprüfen der Benutzerantwort
            if (userChoice == mcCard.getCorrectChoiceIndex() + 1) {
                System.out.println("Richtig!\n");
                statistics.incrementCorrectAnswers();
            } else {
                System.out.println("Falsch. Die richtige Antwort ist: " + mcCard.getChoices().get(mcCard.getCorrectChoiceIndex()) + "\n");
                statistics.incrementIncorrectAnswers();
            }

        } if (currentCard instanceof MultipleChoiceFlashcard) {
            // ... bestehender Code

            // Überprüfen der Benutzerantwort
            if (userChoice == mcCard.getCorrectChoiceIndex() + 1) {
                System.out.println("Richtig!\n");
                statistics.incrementCorrectAnswers();
                statistics.incrementMCCorrectAnswers(); // Neue Statistik für Multiple-Choice
            } else {
                System.out.println("Falsch. Die richtige Antwort ist: " + mcCard.getChoices().get(mcCard.getCorrectChoiceIndex()) + "\n");
                statistics.incrementIncorrectAnswers();
                statistics.incrementMCIncorrectAnswers(); // Neue Statistik für Multiple-Choice
            }
            // Überprüfen der Benutzerantwort
            if (userChoice == mcCard.getCorrectChoiceIndex() + 1) {
                System.out.println("Richtig!\n");
                statistics.incrementCorrectAnswers();
                statistics.incrementMCCorrectAnswers(); // Neue Statistik für Multiple-Choice
            } else {
                System.out.println("Falsch. Die richtige Antwort ist: " + mcCard.getChoices().get(mcCard.getCorrectChoiceIndex()) + "\n");
                statistics.incrementIncorrectAnswers();
                statistics.incrementMCIncorrectAnswers(); // Neue Statistik für Multiple-Choice
            }
        }
        else {
            // Behandlung regulärer Fragen
            super.askQuestion();
        }
    }
    @Override
    protected void displayStatistics() {
        super.displayStatistics(); // Zeige allgemeine Statistiken

        // Zeige spezifische Statistiken für Multiple-Choice-Fragen
        System.out.println("Korrekte Antworten (Multiple-Choice): " + statistics.getMCCorrectAnswers());
        System.out.println("Inkorrekte Antworten (Multiple-Choice): " + statistics.getMCIncorrectAnswers());
    }
}
