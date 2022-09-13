package fi.swd20.bookstore.domain;

public class Book {
	
	private String title;
	private String author;
	private int year;
	private String isbn;
	private String price;
	
	//konstruktorit
	public Book() {
		super();
	}
	public Book(String title, String author, int year, String isbn, String price) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
	}
	//setterit
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	//getterit
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public int getYear() {
		return year;
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
		return "Book [title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn + ", price=" + price
				+ "]";
	}
	
	
	
	

}
