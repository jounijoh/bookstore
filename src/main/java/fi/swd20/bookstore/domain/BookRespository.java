package fi.swd20.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRespository extends CrudRepository<Book, Long> {
	List<Book> findByTitle(String title);
	
	
	
	
}
