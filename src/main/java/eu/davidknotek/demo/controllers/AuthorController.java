package eu.davidknotek.demo.controllers;

import eu.davidknotek.demo.entities.Author;
import eu.davidknotek.demo.services.api.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController 
@RequestMapping("authors")
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    /**
     * Get all authors
     * @return all authors
     */
    @GetMapping
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    /**
     * Add new author. Without id
     * @param author new author
     */
    @PostMapping("/add")
    public Author addAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }

    /**
     * Update existing author.
     * @param author eedited author
     */
    @PutMapping("/{authorId}")
    public Author updateAuthor(@RequestBody Author author, @PathVariable("authorId") Long id) {
        return authorService.updateAuthor(author, id);
    }

    @GetMapping("{authorId}")
    public Author getAuthor(@PathVariable("authorId") Long id) {
        return authorService.getAuthor(id);
    }

    @DeleteMapping(path = "/{authorId}")
    public void deleteAuthor(@PathVariable("authorId") Long id) {
        authorService.deleteAuthor(id);
    }
}
