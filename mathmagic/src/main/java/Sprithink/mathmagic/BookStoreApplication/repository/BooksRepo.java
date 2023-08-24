package Sprithink.mathmagic.BookStoreApplication.repository;

import Sprithink.mathmagic.BookStoreApplication.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepo extends JpaRepository<Book,Integer> {
}
