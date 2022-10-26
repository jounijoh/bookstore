package fi.swd20.bookstore;

import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;
import fi.swd20.bookstore.domain.Book;
import fi.swd20.bookstore.domain.BookRepository;
import fi.swd20.bookstore.domain.CategoryRepository;
import fi.swd20.bookstore.domain.User;
import fi.swd20.bookstore.domain.UserRepository;

//@RunWith(SpringRunner.class)  //JUnit4
@ExtendWith(SpringExtension.class) // JUnit5 eli Jupiter
@DataJpaTest
public class BookstoreRepositoryTest {

	@Autowired
	BookRepository bookrepo;
	@Autowired
	CategoryRepository categoryrepo;
	@Autowired
	UserRepository userrepo;
	
	@Test // testataan BookRepositoryn findByLastName()-metodin toimivuutta
	public void findByTitleShouldReturnBook() {

		List<Book> books = bookrepo.findByTitle("Testikirja");

		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Testi Kirjoittaja");

	}
	
	@Test // Testataan kirjan luominen ja kategorian haku nimellä
	public void createNewBook() {
		Book book = new Book("Uusikirja", "Kokeilu Kaveri", 2015, "ISBN434345621394", 16.30, categoryrepo.findByName("Scifi").get(0));
		bookrepo.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test // Testataan käyttäjän poistaminen
	public void testDeleteUser() {
		User user = new User("testuser", "testpassword", "test@mail.com", "justatest");
		userrepo.save(user);
		assertThat(userrepo.findByUsername("testuser")).isNotNull();
		userrepo.delete(user);
		assertThat(userrepo.findByUsername("testuser")).isNull();
	}
	

}
