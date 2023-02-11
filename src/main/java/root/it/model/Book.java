package root.it.model;

public class Book {
    private String title;
    private String author;
    private int ISBN;
    private int numberOfPieces;
    private Category category;

    public Book(String title, String author, int ISBN, int numberOfPieces, Category category) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.numberOfPieces = numberOfPieces;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getNumberOfPieces() {
        return numberOfPieces;
    }

    public void setNumberOfPieces(int numberOfPieces) {
        this.numberOfPieces = numberOfPieces;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public enum Category {
        CRIMENOVEL,
        NOVEL,
        REPORTAGE,
        CHILDREN
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN + ", Pieces: " + numberOfPieces +
                ", Category: " + category;
    }
}
