package fi.swd20.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.swd20.bookstore.domain.Book;
import fi.swd20.bookstore.domain.BookRespository;
import fi.swd20.bookstore.domain.CategoryRespository;

@Controller
public class BookController {

	@Autowired
	private BookRespository bookrespository;
	
	@Autowired
	private CategoryRespository categoryrepository;

	// aloitussivu
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getIndex() {

		return "index";
	}

	// listaa kirjat
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String getBookList(Model model) {

		model.addAttribute("books", bookrespository.findAll());
		return "booklist"; // booklist.html
	}

	// lisää kirja
	@RequestMapping(value = "/add")
	public String addBook(Model model) {
		
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryrepository.findAll());
		return "addbook";
	}

	// tallenna kirja
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book) {

		bookrespository.save(book);
		return "redirect:/booklist"; // uudelleenohjaus listaussivulle
	}

	// kirjan poisto tietokannasta
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable(name = "id") Long id) {

		bookrespository.deleteById(id); // SQL DELETE
		return "redirect:/booklist"; // uudelleenohjaus listaussivulle
	}

	// kirjan tietojen editointi
	@GetMapping("edit/{id}")
	public String editBookForm(@PathVariable(name = "id") Long id, Model model) {

		Book book = bookrespository.findById(id) // Haetaan kirja tietokannasta id:n perusteella
				.orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
		model.addAttribute("book", book); // kirjan tiedot -> templatelle
		return "editbook"; // editbook.html
	}
	
	// tallennetaan templatella editoitu kirja
	@PostMapping("/update/{id}")
	public String updateBook(@PathVariable("id") Long id, Model model, Book book) {

		bookrespository.save(book); // tallennetaan muutokset
		return "redirect:/booklist"; // palataan kirjalistasivulle
	}

}
