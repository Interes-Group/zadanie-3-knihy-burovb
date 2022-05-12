package sk.stuba.fei.uim.oop.assignment3.author.logic;

import sk.stuba.fei.uim.oop.assignment3.author.data.Author;
import sk.stuba.fei.uim.oop.assignment3.author.web.bodies.AuthorRequest;

import java.util.List;

public interface IAuthorService {
    List<Author> getAll();

    Author create(AuthorRequest request);

    Author getById(Long id);

    Author update(Long id, String name, String surname);

    void removeById(Long id);
}
