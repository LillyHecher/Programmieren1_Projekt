import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FlashcardDeck {
    private List<Flashcard> cards;

    public FlashcardDeck() {
        this.cards = new ArrayList<>();
    }

    public void addCard(Flashcard card) {
        cards.add(card);
    }

    public List<Flashcard> getCards() {
        return cards;
    }

    public void shuffleCards() {
        Collections.shuffle(cards);
    }

    public List<Flashcard> getCardsInCategory(FlashcardCategory category) {
        return cards.stream()
                .filter(card -> card.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    public List<FlashcardCategory> getAllCategories() {
        return cards.stream()
                .map(Flashcard::getCategory)
                .distinct()
                .collect(Collectors.toList());
    }
}
