package sk.stuba.fei.uim.oop.assignment3.author.logic;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.author.data.Author;
import sk.stuba.fei.uim.oop.assignment3.author.data.IAuthorRepository;
import sk.stuba.fei.uim.oop.assignment3.author.web.bodies.AuthorRequest;

import java.util.List;

@Service
public class AuthorService implements IAuthorService {
    @Getter
    private IAuthorRepository repository;

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
    public Author update(Long id, String name, String surname) {
        Author a = getById(id);

        if (name != null) a.setName(name);
        if (surname != null) a.setSurname(surname);

        this.repository.save(a);
        return a;
    }

    @Override
    public void removeById(Long id) {
        this.repository.deleteById(id);
    }
}
