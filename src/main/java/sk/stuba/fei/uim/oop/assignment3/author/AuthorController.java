package sk.stuba.fei.uim.oop.assignment3.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService service;

    @GetMapping()
    public List<AuthorResponse> getAllAuthors() {
        return this.service.getAll().stream().map(AuthorResponse::new).collect(Collectors.toList());
    }

    @PostMapping()
    public ResponseEntity<AuthorResponse> addAuthor(@RequestBody AuthorRequest request) {
        return new ResponseEntity<>(new AuthorResponse(this.service.create(request)), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public AuthorResponse getAuthorById(@PathVariable("id") String id) {
        return new AuthorResponse(this.service.getById(Long.parseLong(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponse> updateAuthorById(
            @PathVariable("id") String id,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "surname", required = false) String surname) {
        Author a = this.service.update(this.service.getById(Long.parseLong(id)), name, surname);

        return new ResponseEntity<>(new AuthorResponse(a), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void removeAuthorById(@PathVariable("id") String id) {
        this.service.removeById(Long.parseLong(id));
    }
}
