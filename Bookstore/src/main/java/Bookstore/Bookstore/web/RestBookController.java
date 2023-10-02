package Bookstore.Bookstore.web;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Bookstore.Bookstore.domain.Book;
import Bookstore.Bookstore.domain.BookRepository;

@RestController
public class RestBookController {
	
	@Autowired
	private BookRepository repository; 

	
	private final AtomicLong counter = new AtomicLong();
	
	
	@GetMapping("/books")
	public List<Book> bookListRest() {
		return (List<Book>) repository.findAll();
		
	}
	
	@GetMapping("/book/{id}")
	public Optional<Book> findBookRest(@PathVariable("id") Long id) {
	return repository.findById(id);
	}
	
	@PostMapping("/book")
	Book newBook(@RequestBody Book newBook) {
		return repository.save(newBook);
	}
	
	@PutMapping("/book/{id}")
	Book editBook(@RequestBody Book editedBook, @PathVariable Long id) {
		editedBook.setId(id);
		return repository.save(editedBook);
	}
	
	
}