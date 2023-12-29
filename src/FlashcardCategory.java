import java.io.Serializable;

public class FlashcardCategory implements Serializable {
    private String categoryName;

    public FlashcardCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public String toString() {
        return categoryName;
    }
}
