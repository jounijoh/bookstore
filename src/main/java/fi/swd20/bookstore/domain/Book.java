package fi.swd20.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String author;
	private int yearPublished;
	private String isbn;
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "catergoryId")
	private Category category;
	
	
	//konstruktorit
	public Book() {
	}
	
	public Book(String title, String author, int year, String isbn, double price, Category category) {
		
		this.title = title;
		this.author = author;
		this.yearPublished = year;
		this.isbn = isbn;
		this.price = price;
		this.category = category;
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
	public void setYearPublished(int year) {
		this.yearPublished = year;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public void setCategory(Category category) {
		this.category = category;
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
	public int getYearPublished() {
		return yearPublished;
	}
	public String getIsbn() {
		return isbn;
	}
	public double getPrice() {
		return price;
	}
	public Category getCategory() {
		return category;
	}
	
	//tostring
	
	@Override
	public String toString() {
		 if (this.category != null)
				return "Book [title=" + title + ", author=" + author + ", year=" + yearPublished + ", isbn=" + isbn + ", price=" + price
				+ " category" + this.getCategory() + "]";
		 else
			 return "Book [title=" + title + ", author=" + author + ", year=" + yearPublished + ", isbn=" + isbn + ", price=" + price + "]";
		 
	}


	
	
	
	

}
