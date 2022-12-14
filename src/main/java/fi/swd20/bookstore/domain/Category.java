package fi.swd20.bookstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
public class Category {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long categoryId;
		private String name;
		
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
		@JsonIgnoreProperties("category")
		private List<Book> books;
		
		// Konstruktorit
		
		public Category() {
		}
		
		public Category(String name) {
			this.name = name;
		}

		// Setterit 
		
		public void setCategoryId(Long categoryId) {
			this.categoryId = categoryId;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setBooks(List<Book> books) {
			this.books = books;
		}
		
		// Getterit
		
		public Long getCategoryId() {
			return categoryId;
		}

		public String getName() {
			return name;
		}
		
		
		public List<Book> getBooks() {
			return books;
		}


		// ToString
		
		@Override
		public String toString() {
			return "Category [categoryId=" + categoryId + ", name=" + name + "]";
		}
		
		
		
		
		
		
		
		
		
		
		
		
}
