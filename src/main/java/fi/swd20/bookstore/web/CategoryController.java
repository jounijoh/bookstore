package fi.swd20.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import fi.swd20.bookstore.domain.Category;
import fi.swd20.bookstore.domain.CategoryRespository;

@Controller
public class CategoryController {

	@Autowired
	private CategoryRespository categoryrepository;
	
	//listaa kategoriat
	@GetMapping("/categorylist")
	public String getCategoryList(Model model) {
		
		model.addAttribute("categories", categoryrepository.findAll());
		return "categorylist";
	}
	
	// lisää kategoria
	@GetMapping("/addcategory")
	public String addCategory(Model model) {
		
		model.addAttribute("category", new Category());
		return "addcategory"; // ohjaus templatelle
	}
	
	// Tallennetaan lisätty categoria
	@PostMapping("/savecategory")
	public String saveCategory(Category category) {
		
		categoryrepository.save(category);
		return "redirect:/categorylist";
	}

	
}
