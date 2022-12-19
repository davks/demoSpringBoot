package eu.davidknotek.demo.services.api;

import eu.davidknotek.demo.entities.Book;

import java.util.List;

public interface BookService {

    void addBook(Book book);

    List<Book> getBooks();

    Book getBook(Long id);

    List<Book> getBooks(Long idAthor);
}
