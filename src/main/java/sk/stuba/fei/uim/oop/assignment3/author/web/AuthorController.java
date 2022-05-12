package sk.stuba.fei.uim.oop.assignment3.author.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.author.logic.AuthorService;
import sk.stuba.fei.uim.oop.assignment3.author.web.bodies.AuthorRequest;
import sk.stuba.fei.uim.oop.assignment3.author.web.bodies.AuthorResponse;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService service;

    @GetMapping
    public List<AuthorResponse> getAllAuthors() {
        return this.service.getAll().stream().map(AuthorResponse::new).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<AuthorResponse> addAuthor(@RequestBody AuthorRequest request) {
        return new ResponseEntity<>(new AuthorResponse(this.service.create(request)), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public AuthorResponse getAuthorById(@PathVariable("id") Long id) {
        return new AuthorResponse(this.service.getById(id));
    }

    @PutMapping("/{id}")
    public AuthorResponse updateAuthorById(@PathVariable("id") Long id,
                                           @RequestParam(name = "name", required = false) String name,
                                           @RequestParam(name = "surname", required = false) String surname) {

        return new AuthorResponse(this.service.update(id, name, surname));
    }

    @DeleteMapping("/{id}")
    public void removeAuthorById(@PathVariable("id") Long id) {
        this.service.removeById(id);
    }
}
