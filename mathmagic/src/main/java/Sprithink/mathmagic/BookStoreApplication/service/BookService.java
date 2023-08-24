package Sprithink.mathmagic.BookStoreApplication.service;

import Sprithink.mathmagic.BookStoreApplication.entities.Book;

import java.util.List;

public interface BookService {

    Book create(Book book);
    List<Book> getAllBooks();
    Book getSingleBook(Integer id);
}
