package fi.swd20.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.swd20.bookstore.domain.Book;
import fi.swd20.bookstore.domain.BookRepository;
import fi.swd20.bookstore.domain.Category;
import fi.swd20.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookCategoryDemo(BookRepository repository,
			CategoryRepository categoryRepo) {
		return (args) -> {
			log.info("Tallennetaan pari kategoriaa");
			Category category1 = new Category("Scifi");
			categoryRepo.save(category1);
			Category category2 = new Category("Fantasy");
			categoryRepo.save(category2);
			Category category3 = new Category("Action");
			categoryRepo.save(category3);
			
			log.info("Tallennetaan pari kirjaa");
			repository.save(new Book("Testikirja", "Testi Kirjoittaja", 2222, "24-24-24", 35.5, category1));
			repository.save(new Book("Demo-Opus", "Mikko Maharadja", 1654, "ad-32-ad", 9.99, category2));
			
			
			log.info("Haetaan kirjat");
			for (Book book : repository.findAll()) {
				log.info(book.toString());	
			
			log.info("Haetaan kategoriat");
			for (Category category : categoryRepo.findAll()) {
				log.info(category.toString());
			}
			}
		};
	}
}
