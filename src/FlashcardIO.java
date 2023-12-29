import java.io.*;
import java.util.List;

public class FlashcardIO {
    public static void saveFlashcards(List<Flashcard> flashcards, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(flashcards);
            System.out.println("Karteikarten erfolgreich gespeichert.");
        } catch (IOException e) {
            System.err.println("Fehler beim Speichern der Karteikarten: " + e.getMessage());
        }
    }

    public static List<Flashcard> loadFlashcards(String fileName) {
        List<Flashcard> flashcards = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            flashcards = (List<Flashcard>) ois.readObject();
            System.out.println("Karteikarten erfolgreich geladen.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Fehler beim Laden der Karteikarten: " + e.getMessage());
        }
        return flashcards;
    }
}
