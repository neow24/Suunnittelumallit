package prototype;

public class Book implements Cloneable {
    private String author;
    private String title;

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public Book clone() {
        return new Book(this.author, this.title);
    }

    @Override
    public String toString() {
        return "Author: " + author + ", Title: " + title;
    }
}
