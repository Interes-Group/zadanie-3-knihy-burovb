package sk.stuba.fei.uim.oop.assignment3.book;

import lombok.Getter;

@Getter
public class BookRequest {
    private String name, description;

    private Long author;

    private int pages, amount, lendCount;
}
