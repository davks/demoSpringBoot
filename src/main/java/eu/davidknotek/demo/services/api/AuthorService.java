package eu.davidknotek.demo.services.api;

import eu.davidknotek.demo.entities.Author;

import java.util.List;

public interface AuthorService {

    Author addAuthor(Author author);

    List<Author> getAuthors();

    Author getAuthor(Long idAuthor);

    void deleteAuthor(Long idAuthor);

    List<Author> findAuthorsByString(String ret);

    Author updateAuthor(Author author, Long id);
}
