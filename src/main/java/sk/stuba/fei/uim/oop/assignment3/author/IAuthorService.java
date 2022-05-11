package sk.stuba.fei.uim.oop.assignment3.author;

import java.util.List;

public interface IAuthorService {
    List<Author> getAll();

    Author create(AuthorRequest request);

    Author getById(Long id);

    Author update(Author a, String name, String surname);

    void removeById(Long id);
}
