package sk.stuba.fei.uim.oop.assignment3.book;

import java.util.List;

public interface IBookService {
    List<Book> getAll();
    Book create(BookRequest request);
}
