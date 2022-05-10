package sk.stuba.fei.uim.oop.assignment3.book;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.author.Author;

@Getter
public class BookResponse {
    private Long id;

    private String name, description;

    private Author author;

    private int pages, amount, lendCount;

    public BookResponse(Book book) {
        this.id = book.getId();
        this.name = book.getName();
        this.description = book.getDescription();
        this.author = book.getAuthor();
        this.pages = book.getPages();
        this.amount = book.getAmount();
        this.lendCount = book.getLendCount();
    }
}
