package fi.swd20.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.swd20.bookstore.domain.Book;
import fi.swd20.bookstore.domain.BookRespository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRespository repository) {
		return (args) -> {
			log.info("Tallennetaan pari kirjaa");
			repository.save(new Book("Testikirja", "Testi Kirjoittaja", 2222, "24-24-24", 35.5));
			repository.save(new Book("Demo-Opus", "Mikko Maharadja", 1654, "ad-32-ad", 9.99));
			
			log.info("Haetaan kirjat");
			for (Book book : repository.findAll()) {
				log.info(book.toString());	
			}
		};
	}
}
