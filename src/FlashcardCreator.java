import java.util.Scanner;

public class FlashcardCreator {
    private Scanner scanner;

    public FlashcardCreator() {
        this.scanner = new Scanner(System.in);
    }

    public Flashcard createFlashcard() {
        System.out.print("Geben Sie die Frage ein: ");
        String question = scanner.nextLine();

        System.out.print("Geben Sie die Antwort ein: ");
        String answer = scanner.nextLine();

        System.out.print("Geben Sie die Kategorie ein: ");
        String category = scanner.nextLine();
        FlashcardCategory flashcardCategory = new FlashcardCategory(category);

        return new Flashcard(question, answer, flashcardCategory);
    }
}
