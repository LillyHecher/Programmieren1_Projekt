
import java.util.List;
public class Main {

        public static void main(String[] args) {
                // Erstellen eines Karteikarten-Decks
                FlashcardDeck deck = new FlashcardDeck();

                // Erstellen einiger Karteikarten mit Kategorien
                FlashcardCategory mathCategory = new FlashcardCategory("Mathematik");
                FlashcardCategory geographyCategory = new FlashcardCategory("Geografie");

                Flashcard card1 = new Flashcard("Was ist 2 + 2?", "4", mathCategory);
                Flashcard card2 = new Flashcard("Was ist die Hauptstadt von Deutschland?", "Berlin", geographyCategory);
                Flashcard card3 = new Flashcard("Was ist die Hauptstadt von Spanien?", "Madrid", geographyCategory);

                // Hinzufügen der Karteikarten zum Deck
                deck.addCard(card1);
                deck.addCard(card2);
                deck.addCard(card3);

                // Anzeigen aller Kategorien im Deck
                List<FlashcardCategory> allCategories = deck.getAllCategories();
                System.out.println("Alle Kategorien im Deck: " + allCategories);

                // Anzeigen von Karteikarten in einer bestimmten Kategorie
                List<Flashcard> geographyCards = deck.getCardsInCategory(geographyCategory);
                System.out.println("Karteikarten in der Kategorie 'Geografie': " + geographyCards);
        }
}
