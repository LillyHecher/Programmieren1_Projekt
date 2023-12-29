import java.util.Scanner;

public class FlashcardUI {


    private static void startUI(LearningSessionImpl flashcardLearning) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Willkommen zur Karteikarten-Anwendung!");

        while (true) {
            System.out.println("1. Karteikarten lernen");
            System.out.println("2. Beenden");
            System.out.print("Wählen Sie eine Option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    flashcardLearning.startLearning(new FlashcardDeck());
                    break;
                case 2:
                    System.out.println("Auf Wiedersehen!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Ungültige Option. Bitte wählen Sie erneut.");
            }
        }
    }
}

