import java.util.Scanner;

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
        // Implementierung wie zuvor
    }

    private static void addFlashcard() {
        // Implementierung wie zuvor
    }

    private static void startLearning() {
        // Implementierung wie zuvor
    }

    private static void displayStatistics() {
        // Implementierung wie zuvor
    }
}