import jdk.jfr.Category;

import java.util.Scanner;
import java.util.List;

public class FlashcardApp {
    private static Scanner scanner = new Scanner(System.in);
    private static FlashcardDeck deck = new FlashcardDeck();
    private static LearningSessionImpl flashcardLearning;

    public static void main(String[] args) {
        System.out.println("Willkommen zur Karteikarten-App!");

        boolean exit = false;

        while (!exit) {
            printMainMenu();
            int choice = getUserChoice();

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
                    displayStatistics();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Ungültige Option. Bitte versuchen Sie es erneut.");
                    break;
            }
        }

        System.out.println("Vielen Dank für die Nutzung der Karteikarten-App!");
    }

    private static void printMainMenu() {
        System.out.println("\nHauptmenü:");
        System.out.println("1. Karteikarten anzeigen");
        System.out.println("2. Karteikarte hinzufügen");
        System.out.println("3. Karten lernen");
        System.out.println("4. Lernstatistiken anzeigen");
        System.out.println("5. Beenden");
        System.out.print("Wählen Sie eine Option: ");
    }

    private static int getUserChoice() {
        try {
            return scanner.nextInt();
        } catch (java.util.InputMismatchException e) {
            // Nutzereingabe ist keine Zahl
            scanner.nextLine(); // Leert den Scanner-Puffer
            return 0;
        }
    }

    private static void displayFlashcards() {
        System.out.println("\nAlle Karteikarten im Deck:");
        for (Flashcard card : deck.getCards()) {
            System.out.println(card);
        }
    }

    private static void addFlashcard() {
        scanner.nextLine(); // Verbraucht das newline-Zeichen nach der vorherigen Zahleneingabe

        System.out.print("Geben Sie die Frage ein: ");
        String question = scanner.nextLine();

        System.out.print("Geben Sie die Antwort ein: ");
        String answer = scanner.nextLine();
        System.out.println("Geben Sie eine Kategorie ein");
        String category1 = scanner.nextLine();

        // Beispiel: Hier erstellen oder initialisieren Sie Ihre FlashcardCategory-Instanz
        FlashcardCategory category = new FlashcardCategory(category1);

        deck.addCard(new Flashcard(question, answer, category));
        System.out.println("Die Karteikarte wurde hinzugefügt.");
    }




    private static void startLearning() {
        List<Flashcard> allCards = deck.getCards();
        if (allCards.isEmpty()) {
            System.out.println("Es sind keine Karteikarten im Deck vorhanden. Fügen Sie Karteikarten hinzu, um zu lernen.");
            return;
        }

        System.out.println("Willkommen zum Karteikarten-Lernen!");

        // Mischen der Karteikarten im Deck
        deck.shuffleCards();

        // Erstellen der passenden Lerninstanz (Multiple Choice oder normale Fragen)
        LearningSessionImpl learningInstance = new LearningSessionImpl(allCards);

        /*if (containsMultipleChoiceFlashcards(allCards)) {
            learningInstance = new MultipleChoiceFlashcardLearning(allCards);
        } else {
            learningInstance = new LearningSessionImpl(allCards);
        }
        */


        // Starten des Lernens
        learningInstance.startLearning(deck);
    }



    private static boolean containsMultipleChoiceFlashcards(List<Flashcard> cards) {
        for (Flashcard card : cards) {
            if (card instanceof MultipleChoiceFlashcard) {
                return true;
            }
        }
        return false;
    }

    private static void displayStatistics() {
        if (flashcardLearning != null) {
            flashcardLearning.displayStatistics();
        } else {
            System.out.println("Sie müssen zuerst mit dem Lernen beginnen, um Statistiken anzuzeigen.");
        }
    }
}