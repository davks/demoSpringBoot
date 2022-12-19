package eu.davidknotek.demo.repositories;

import eu.davidknotek.demo.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("select a from Author a")
    List<Author> getAuthors();


    @Query("select a from Author a where a.id = ?1")
    Author getAuthor(Long id);

    @Query("select a from Author a where a.name like %?1% or a.surname like %?1%")
    List<Author> findAuthorsByNameAndSurname(String ret);
}
