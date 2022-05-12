package sk.stuba.fei.uim.oop.assignment3.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.book.logic.BookService;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.Amount;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookResponse;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping
    public List<BookResponse> getAllBooks() {
        return this.service.getAll().stream().map(BookResponse::new).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<BookResponse> addBook(@RequestBody BookRequest request) {
        return new ResponseEntity<>(new BookResponse(this.service.create(request)), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public BookResponse getBookById(@PathVariable("id") Long id) {
        return new BookResponse(this.service.getById(id));
    }

    @PutMapping("/{id}")
    public BookResponse updateBookById(@PathVariable("id") Long id,
                                       @RequestParam(name = "name", required = false) String name,
                                       @RequestParam(name = "description", required = false) String description,
                                       @RequestParam(name = "author", required = false) Long author,
                                       @RequestParam(name = "pages", required = false) Integer pages) {

        return new BookResponse(this.service.update(id, name, description, author, pages));
    }

    @DeleteMapping("/{id}")
    public void removeBookById(@PathVariable("id") Long id) {
        this.service.removeById(id);
    }

    @GetMapping("/{id}/amount")
    public Amount getAmountById(@PathVariable("id") Long id) {
        return new Amount(this.getBookById(id).getAmount());
    }

    @PostMapping("/{id}/amount")
    public Amount addAmountById(@PathVariable("id") Long id, @RequestBody Amount request) {
        return new Amount(this.service.addAmount(id, request).getAmount());
    }

    @GetMapping("/{id}/lendCount")
    public Amount getLendCountById(@PathVariable("id") Long id) {
        return new Amount(this.service.getById(id).getLendCount());
    }
}
