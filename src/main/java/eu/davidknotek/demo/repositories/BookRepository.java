package eu.davidknotek.demo.repositories;

import eu.davidknotek.demo.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select b from Book b where b.id = ?1")
    Book getBook(Long id);

    @Query("select b from Book b where b.author.id = ?1")
    List<Book> getBooks(Long id);
}
