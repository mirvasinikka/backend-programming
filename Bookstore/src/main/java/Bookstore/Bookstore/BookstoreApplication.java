package Bookstore.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import Bookstore.Bookstore.domain.Book;
import Bookstore.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			log.info("couple of books");
			repository.save(new Book("testi", "hello", 2020, 2345, 23));
			repository.save(new Book("Moon", "Smith", 1996, 1234567890, 57));

			log.info("get all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};

	}
}
