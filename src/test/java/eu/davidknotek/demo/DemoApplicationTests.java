package eu.davidknotek.demo;

import eu.davidknotek.demo.entities.Author;
import eu.davidknotek.demo.entities.Book;
import eu.davidknotek.demo.services.api.AuthorService;
import eu.davidknotek.demo.services.api.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private AuthorService authorService;

	@Autowired
	private BookService bookService;

	@Test
	void addAuthor() {
		authorService.addAuthor(new Author("Milan", "Černý"));
	}

	@Test
	void getAuthor() {
		Author author = authorService.getAuthor(1L);
		System.out.println(author);
	}

	@Test
	void findAuthorsByStr() {
		List<Author> authors = authorService.findAuthorsByString("la");
		authors.forEach(System.out::println);
	}

	@Test
	void deleteAuthor() {
		authorService.deleteAuthor(1L);
	}

	@Test
	void addBook() {
		Author author = authorService.getAuthor(2L);
		bookService.addBook(new Book("Sedm samurajů", author, "Description of book"));
	}

	@Test
	void getBook() {
		Book book = bookService.getBook(1L);
		System.out.println(book.getName() + " Author: " + book.getAuthor().getName() + " " + book.getAuthor().getSurname());
	}

	@Test
	void getBooksByAuthor() {
		Author author = authorService.getAuthor(2L);
		List<Book> books = bookService.getBooks(author.getId());
		books.forEach(book -> System.out.println(book.getName() + " * " + book.getAuthor().getName() + " " + book.getAuthor().getSurname()));
	}

	@Test
	void getBooks() {
		List<Book> books = bookService.getBooks();
		books.forEach(book -> System.out.println(book.getName() + " * " + book.getAuthor().getName() + " " + book.getAuthor().getSurname()));
	}

}
