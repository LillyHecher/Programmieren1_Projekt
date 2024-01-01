import java.io.Serializable;

public class Flashcard implements Serializable {
    private String question;
    private String answer;
    private FlashcardCategory category;

    public Flashcard(String question, String answer, FlashcardCategory category) {
        this.question = question;
        this.answer = answer;
        this.category = category;
    }

    public Flashcard(String part, String part1) {
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public FlashcardCategory getCategory() {
        return category;
    }

    public void setCategory(FlashcardCategory category) {
        this.category = category;
    }
}
