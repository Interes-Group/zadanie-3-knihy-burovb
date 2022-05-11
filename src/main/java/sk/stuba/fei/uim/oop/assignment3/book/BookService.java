package sk.stuba.fei.uim.oop.assignment3.book;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.author.Author;
import sk.stuba.fei.uim.oop.assignment3.author.AuthorService;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Getter
    private IBookRepository repository;
    @Autowired
    private AuthorService authorService;

    @Autowired
    public BookService(IBookRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Book> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Book create(BookRequest request) {
        Book b = new Book();

        b.setName(request.getName());
        b.setDescription(request.getDescription());
        b.setPages(request.getPages());
        b.setAmount(request.getAmount());
        b.setLendCount(request.getLendCount());

        Author author = this.authorService.getRepository().findById(request.getAuthor()).get();
        author.getBooks().add(b);
        b.setAuthor(author);

        return this.repository.save(b);
    }

}
