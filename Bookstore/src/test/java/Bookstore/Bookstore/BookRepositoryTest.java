package Bookstore.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import Bookstore.Bookstore.domain.Book;
import Bookstore.Bookstore.domain.BookRepository;
import Bookstore.Bookstore.domain.Category;

@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
	BookRepository bookRepository;
	
	@Test
	void findAllBooks() {
		Iterable<Book> books = bookRepository.findAll();
		assertThat(books).hasSize(2);
	}

	@Test
	void findByTitleBooks() {
		Iterable<Book> books = bookRepository.findByTitle("testi");
		assertThat(books).isNotNull();
	}
	
	@Test
	public void newBook() {
		Book book = new Book("testi", "testi", 2020, 2345, 23, new Category("TESTI"));
		bookRepository.save(book);
		assertThat(book.getId()).isNotNull();

	}
	
	@Test
	public void updateBook() {
		Optional<Book> book = bookRepository.findById((long) 1);
		assertNotEquals(book.get().getId(), null);
		book.get().setTitle("test");
		List<Book> books = bookRepository.findByTitle("test");
		assertThat(books).hasSize(1);
	}
	
	@Test
    public void deleteBook() {
		List<Book> books = bookRepository.findByTitle("testi");
		Book book = books.get(0);
		bookRepository.delete(book);
		List<Book> newbooks = bookRepository.findByTitle("testi");
		assertThat(newbooks).hasSize(0);
     }

}
