package sk.stuba.fei.uim.oop.assignment3.book;

import lombok.Data;
import sk.stuba.fei.uim.oop.assignment3.author.Author;

import javax.persistence.*;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name, description;

    @ManyToOne
    private Author author;

    private int pages, amount, lendCount;
}
