package eu.davidknotek.demo.services;

import eu.davidknotek.demo.entities.Book;
import eu.davidknotek.demo.repositories.BookRepository;
import eu.davidknotek.demo.services.api.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(Long id) {
        return bookRepository.getBook(id);
    }

    @Override
    public List<Book> getBooks(Long idAthor) {
        return bookRepository.getBooks(idAthor);
    }
}
