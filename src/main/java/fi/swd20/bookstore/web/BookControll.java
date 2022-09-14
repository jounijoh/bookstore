package fi.swd20.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.swd20.bookstore.domain.BookRespository;

@Controller
public class BookControll {
	
	@Autowired
	private BookRespository bookrespository;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getIndex() {
		return "index";
	}
	
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String getBookList(Model model) {
		model.addAttribute("books", bookrespository.findAll());
		return "booklist"; //booklist.html
	}
}
