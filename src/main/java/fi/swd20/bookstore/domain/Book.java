package fi.swd20.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String author;
	private int yearPublished;
	private String isbn;
	private String price;
	
	//konstruktorit
	public Book() {
	}
	
	public Book(Long id, String title, String author, int year, String isbn, String price) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.yearPublished = year;
		this.isbn = isbn;
		this.price = price;
	}

	public Book(String title, String author, int year, String isbn, String price) {
		super();
		this.title = title;
		this.author = author;
		this.yearPublished = year;
		this.isbn = isbn;
		this.price = price;
	}
	//setterit
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setYear(int year) {
		this.yearPublished = year;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	//getterit
	
	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public int getYear() {
		return yearPublished;
	}
	public String getIsbn() {
		return isbn;
	}
	public String getPrice() {
		return price;
	}
	//tostring
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", year=" + yearPublished + ", isbn=" + isbn + ", price=" + price
				+ "]";
	}


	
	
	
	

}
