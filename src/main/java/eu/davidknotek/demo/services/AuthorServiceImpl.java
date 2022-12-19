package eu.davidknotek.demo.services;

import eu.davidknotek.demo.entities.Author;
import eu.davidknotek.demo.repositories.AuthorRepository;
import eu.davidknotek.demo.services.api.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthor(Long idAuthor) {
        return authorRepository.getAuthor(idAuthor);
    }

    @Override
    public void deleteAuthor(Long idAuthor) {
        boolean exists = authorRepository.existsById(idAuthor);
        if (!exists) {
            throw new IllegalStateException("User with ID" + idAuthor + " doesnť exists.");
        }
        authorRepository.deleteById(idAuthor);
    }

    @Override
    public List<Author> findAuthorsByString(String ret) {
        return authorRepository.findAuthorsByNameAndSurname(ret);
    }

    @Override
    public Author updateAuthor(Author author, Long id) {
        boolean exists = authorRepository.existsById(id);
        if (exists) {
            return authorRepository.save(author);
        } else {
            return author;
        }
    }
}
