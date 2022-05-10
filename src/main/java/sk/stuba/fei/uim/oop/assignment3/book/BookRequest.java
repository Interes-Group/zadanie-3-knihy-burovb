package sk.stuba.fei.uim.oop.assignment3.book;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.author.Author;

@Getter
public class BookRequest {
    private String name, description;

    private Author author;

    private int pages;
}
