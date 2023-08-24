package Sprithink.mathmagic.BookStoreApplication.controller;

import Sprithink.mathmagic.BookStoreApplication.entities.Book;
import Sprithink.mathmagic.BookStoreApplication.service.BookService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class BookController {
    @Autowired
    private BookService bookService;


    @MutationMapping("createBook")
    public Book create(@Argument BookInput book){
        Book b = new Book();
        b.setTitle(book.getTitle());
        b.setDesc(book.getDesc());
        b.setAuthor(book.getAuthor());
      return bookService.create(b);
    }



    @QueryMapping("allBooks")
    public List<Book> getAll(){
        return bookService.getAllBooks();
    }


    @QueryMapping("getBook")
    public  Book getBookById(@Argument Integer id){
        return bookService.getSingleBook(id);
    }
}

@Getter
@Setter
class BookInput {

    String title;
    String desc;
    String author;
}