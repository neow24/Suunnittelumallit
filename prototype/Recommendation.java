package prototype;

import java.util.ArrayList;

public class Recommendation implements Cloneable {
    private String targetAudience;
    private java.util.List<Book> books;

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) { books.add(book); }

    public void removeBook(int index) {
        if (index >= 0 && index < books.size()) books.remove(index);
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String target) {
        this.targetAudience = target;
    }

    @Override
    public Recommendation clone() {
        try {
            Recommendation clonedRecommendation = (Recommendation) super.clone();
            clonedRecommendation.books = new ArrayList<>();
            for (Book book : this.books)
                clonedRecommendation.addBook(book.clone());
            return clonedRecommendation;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Target Audience: " + targetAudience + "\nBooks:\n");
        for (Book book : books) {
            sb.append("  [" + books.indexOf(book) + "]");
            sb.append(" - ").append(book).append("\n");
        }
        return sb.toString();
    }
}
