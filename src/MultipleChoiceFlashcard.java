import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MultipleChoiceFlashcard extends Flashcard implements Serializable {
    private List<String> choices;
    private int correctChoiceIndex;

    public MultipleChoiceFlashcard(String question, List<String> choices, int correctChoiceIndex, FlashcardCategory category) {
        super(question, null, category); // Antwort wird vorerst auf null gesetzt
        this.choices = new ArrayList<>(choices);
        this.correctChoiceIndex = correctChoiceIndex;

        // Setze die Antwort auf die korrekte Wahl
        setAnswer(choices.get(correctChoiceIndex));
    }

    public List<String> getChoices() {
        return choices;
    }

    public int getCorrectChoiceIndex() {
        return correctChoiceIndex;
    }
}
