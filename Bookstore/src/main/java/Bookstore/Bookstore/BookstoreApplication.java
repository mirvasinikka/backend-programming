package Bookstore.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import Bookstore.Bookstore.domain.AppUser;
import Bookstore.Bookstore.domain.AppUserRepository;
import Bookstore.Bookstore.domain.Book;
import Bookstore.Bookstore.domain.BookRepository;
import Bookstore.Bookstore.domain.Category;
import Bookstore.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository, AppUserRepository urepository) {
		return (args) -> {
			log.info("couple of books");
			crepository.save(new Category("Horror"));
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Scifi"));
			
			brepository.save(new Book("testi", "hello", 2020, 2345, 23, crepository.findByName("Horror").get(0)));
			brepository.save(new Book("Moon", "Smith", 1996, 1234567890, 57, crepository.findByName("Scifi").get(0)));

			AppUser user1 = new AppUser("user", "$2a$10$XPMxMF40UOfpo1jxytJ8g.B3uEA9VfqvqHa/WBqTI.HpUew3uzlEa", "moi.moi@moi.fi", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$M8I15ZmXIBC2tFTBP/cdR.//tCZ51EXm34tA2/Q/xqyGL2HYyYY9i", "hei.hei@hei.fi", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("get all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

		};

	}
}
