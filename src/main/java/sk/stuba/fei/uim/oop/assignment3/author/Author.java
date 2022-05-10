package sk.stuba.fei.uim.oop.assignment3.author;

import lombok.Data;
import sk.stuba.fei.uim.oop.assignment3.book.Book;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Book> books;

    public Author() {
        this.books = new ArrayList<>();
    }
}
