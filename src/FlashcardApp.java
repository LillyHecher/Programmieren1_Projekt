import java.util.List;
import java.util.Scanner;

public class FlashcardApp {
    private static Scanner scanner = new Scanner(System.in);
    private static FlashcardDeck deck = new FlashcardDeck();
    private static LearningSessionImpl flashcardLearning;

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Karteikarten anzeigen");
            System.out.println("2. Karteikarte hinzufügen");
            System.out.println("3. Karten lernen");
            System.out.println("4. Beenden");
            System.out.print("Wählen Sie eine Option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayFlashcards();
                    break;
                case 2:
                    addFlashcard();
                    break;
                case 3:
                    startLearning();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Ungültige Option. Bitte versuchen Sie es erneut.");
                    break;
            }
        }

        System.out.println("Vielen Dank für die Nutzung der Karteikarten-App!");
    }

    private static void displayFlashcards() {
        List<Flashcard> allCards = deck.getCards();
        System.out.println("Alle Karteikarten im Deck:");
        for (Flashcard flashcard : allCards) {
            System.out.println("Frage: " + flashcard.getQuestion());
            System.out.println("Antwort: " + flashcard.getAnswer());
            System.out.println("Kategorie: " + flashcard.getCategory());
            System.out.println("-----");
        }
    }

    private static void addFlashcard() {
        FlashcardCreator flashcardCreator = new FlashcardCreator();
        Flashcard newCard = flashcardCreator.createFlashcard();
        deck.addCard(newCard);
        System.out.println("Karteikarte erfolgreich hinzugefügt!");
    }

    private static void startLearning() {
        List<Flashcard> allCards = deck.getCards();
        if (allCards.isEmpty()) {
            System.out.println("Es sind keine Karteikarten im Deck vorhanden. Fügen Sie Karteikarten hinzu, um zu lernen.");
            return;
        }

        System.out.println("Willkommen zum Karteikarten-Lernen!");

        LearningSession learningInstance;
        if (containsMultipleChoiceFlashcards(allCards)) {
            learningInstance = new MultipleChoiceFlashcardLearning(allCards);
        } else {
            learningInstance = new LearningSessionImpl(allCards);
        }

        // Mischen der Karteikarten im Deck
        deck.shuffleCards();

        // Erstellen der FlashcardLearningImpl-Instanz und Starten des Lernens
        flashcardLearning = new LearningSessionImpl(allCards);
        flashcardLearning.startLearning(deck);
    }

    private static boolean containsMultipleChoiceFlashcards(List<Flashcard> cards) {
        for (Flashcard card : cards) {
            if (card instanceof MultipleChoiceFlashcard) {
                return true;
            }
        }
        return false;
    }
}
