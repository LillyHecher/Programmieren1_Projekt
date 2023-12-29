import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FlashcardTextFileIO {
    public static void exportToTextFile(List<Flashcard> flashcards, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Flashcard flashcard : flashcards) {
                writer.println(flashcard.getQuestion() + "|" + flashcard.getAnswer());
            }
            System.out.println("Karteikarten erfolgreich in die Datei exportiert.");
        } catch (IOException e) {
            System.err.println("Fehler beim Exportieren der Karteikarten: " + e.getMessage());
        }
    }

    public static List<Flashcard> importFromTextFile(String fileName) {
        List<Flashcard> flashcards = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    Flashcard flashcard = new Flashcard(parts[0], parts[1]);
                    flashcards.add(flashcard);
                }
            }
            System.out.println("Karteikarten erfolgreich aus der Datei importiert.");
        } catch (IOException e) {
            System.err.println("Fehler beim Importieren der Karteikarten: " + e.getMessage());
        }
        return flashcards;
    }
}
