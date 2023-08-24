package Sprithink.mathmagic.BookStoreApplication.service.impl;

import Sprithink.mathmagic.BookStoreApplication.entities.Book;
import Sprithink.mathmagic.BookStoreApplication.repository.BooksRepo;
import Sprithink.mathmagic.BookStoreApplication.service.BookService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@GraphQLApi
public class BookServiceImpl implements BookService {

    private BooksRepo booksRepo;
    @Autowired
    public BookServiceImpl(BooksRepo booksRepo){
        this.booksRepo = booksRepo;
    }

    @GraphQLMutation(name = "createBook")
    @Override
    public Book create(@GraphQLArgument(name = "book") Book book) {
        return this.booksRepo.save(book);
    }

    @GraphQLQuery(name="allBooks")
    @Override
    public List<Book> getAllBooks() {
        return this.booksRepo.findAll();
    }

    @GraphQLQuery(name = "getBook")
    @Override
    public Book getSingleBook(@GraphQLArgument( name= "id") Integer id) {
        return this.booksRepo.findById(id).orElseThrow(()->  new RuntimeException("no books found"));
    }
}
