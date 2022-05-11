package sk.stuba.fei.uim.oop.assignment3.author;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.book.Book;
import sk.stuba.fei.uim.oop.assignment3.book.BookService;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService implements IAuthorService {
    @Getter
    private IAuthorRepository repository;
    @Autowired
    private BookService bookService;

    @Autowired
    public AuthorService(IAuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Author> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Author create(AuthorRequest request) {
        Author a = new Author();

        a.setName(request.getName());
        a.setSurname(request.getSurname());

        return this.repository.save(a);
    }

    @Override
    public Author getById(Long id) {
        return this.repository.findById(id).get();
    }

    @Override
    public Author update(Author a, String name, String surname) {
        if (name != null) a.setName(name);
        if (surname != null) a.setSurname(surname);
        this.repository.save(a);

        return a;
    }

    @Override
    public void removeById(Long id) {
        List<Book> books = this.repository.findById(id).get().getBooks();
        List<Book> tempList = new ArrayList<>(books);
        for (Book book: tempList) {
            Book temp = new Book(book);
            books.remove(temp);
            this.bookService.getRepository().delete(temp);
        }
        this.repository.deleteById(id);
    }
}
