package Sprithink.mathmagic;

import Sprithink.mathmagic.BookStoreApplication.entities.Book;
import Sprithink.mathmagic.MultiplicationApplication.entities.Multiplication;
import Sprithink.mathmagic.BookStoreApplication.service.BookService;
import Sprithink.mathmagic.MultiplicationApplication.service.MultiplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MathmagicApplication extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	BookService bookService;

    @Autowired
	MultiplicationService multiplicationService;
	public static void main(String[] args) {
		SpringApplication.run(MathmagicApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Book book = new Book();
		book.setAuthor("Authur Cannon doyle");
		book.setDesc("Detective");
		book.setTitle("Sherlocked");

		bookService.create(book);

		Multiplication multiplication = new Multiplication();
		multiplication.setMult1(4);
		multiplication.setMult2(8);
		multiplication.setName("Magic");
		multiplicationService.generate(multiplication.getName());
	}
}
