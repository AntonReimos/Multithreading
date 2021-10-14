package ru.skillbox;

public class Book {
    private final String bookName;
    private final String authorName;
    private final int numberOfPages;
    private final int numberOfIsbn;

    public Book(String bookName, String authorName, int numberOfPages, int numberOfIsbn) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.numberOfPages = numberOfPages;
        this.numberOfIsbn = numberOfIsbn;
    }


    public String getBookName() {
        return bookName;
    }


    public String getAuthorName() {
        return authorName;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public int getNumberOfIsbn() {
        return numberOfIsbn;
    }
}
