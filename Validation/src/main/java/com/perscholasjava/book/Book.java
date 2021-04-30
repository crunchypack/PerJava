package com.perscholasjava.book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.Size;

@Entity
public class Book {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@org.hibernate.validator.constraints.NotEmpty(message="Title is required")
	@Size(min = 2, max= 50, message = "Title must be between {2} and {1} characters")
	private String title;
	
	@org.hibernate.validator.constraints.NotEmpty(message="Author is required")
	@Size(min = 2, max= 50, message = "Author name must be between {2} and {1} characters")
	private String author;
	
	protected Book() {
		
	}

	public Book(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
