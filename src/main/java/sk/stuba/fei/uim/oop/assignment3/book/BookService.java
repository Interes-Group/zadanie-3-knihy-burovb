package sk.stuba.fei.uim.oop.assignment3.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {
    private IBookRepository repository;

    @Autowired
    public BookService(IBookRepository repository) {
        this.repository = repository;
        Book b1 = new Book();
        this.repository.save(b1);
    }
}
