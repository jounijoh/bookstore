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
import fi.swd20.bookstore.domain.User;
import fi.swd20.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookCategoryDemo(BookRepository repository,
			CategoryRepository categoryRepo, UserRepository userrepository) {
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
			
			log.info("Luodaan käyttäjät");
			User user1= new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@hh.fi", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "admin@hh.fi", "ADMIN");
			userrepository.save(user1);
			userrepository.save(user2);

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
