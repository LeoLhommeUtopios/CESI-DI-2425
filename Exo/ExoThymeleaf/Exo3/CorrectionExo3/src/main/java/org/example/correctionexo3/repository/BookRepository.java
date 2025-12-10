package org.example.correctionexo3.repository;

import org.example.correctionexo3.entity.Books;
import org.example.correctionexo3.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Books,UUID> {
    List<Books> getBooksByAutor(String autor);

    List<Books> getBooksByTitle(String title);

    List<Books> getBooksByGenre(Genre genre);

    List<Books> getBooksByAvailable(boolean available);

    List<Books> getBooksByGenreAndAvailable(Genre genre, boolean available);

}
