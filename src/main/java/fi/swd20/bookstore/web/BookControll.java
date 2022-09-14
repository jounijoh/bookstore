package fi.swd20.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.swd20.bookstore.domain.Book;
import fi.swd20.bookstore.domain.BookRespository;

@Controller
public class BookControll {
	
	@Autowired
	private BookRespository bookrespository;
	//aloitussivu
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getIndex() {
		return "index";
	}
	// listaa kirjat
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String getBookList(Model model) {
		model.addAttribute("books", bookrespository.findAll());
		return "booklist"; //booklist.html
	}
	// lisää kirja
	@RequestMapping(value = "/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}
	// tallenna lisätty kirja
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book) {
		bookrespository.save(book);
		return "redirect:/booklist"; // uudelleenohjaus listaussivulle
	}
	// kirjan poisto tietokannasta
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable(name = "id") Long id) {
		bookrespository.deleteById(id); // SQL DELETE
		return "redirect:/booktlist"; // uudelleenohjaus listaussivulle
	}
}
