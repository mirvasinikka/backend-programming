package Bookstore.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import Bookstore.Bookstore.domain.Book;
import Bookstore.Bookstore.domain.BookRepository;
import Bookstore.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {

	@GetMapping("/index")
	@ResponseBody
	public String showMainPage() {
		return "jee";
	}

	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
	

	@GetMapping("/booklist")
	public String studentList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}

	@GetMapping("/addBook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categorys", crepository.findAll());
		return "addbook";
	}

	@PostMapping("/saveBook")
	public String save(Book book) {
		repository.save(book);
		return "redirect:/booklist";
	}

	@GetMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		repository.deleteById(id);
		return "redirect:/booklist";
	}
	
	 @GetMapping("/editBook/{id}")
	    public String editStudent(@PathVariable("id") Long id, Model model) {
	    	model.addAttribute("book", repository.findById(id));
	    	model.addAttribute("categorys", crepository.findAll());
	    	return "editBook";
	    }  

}
