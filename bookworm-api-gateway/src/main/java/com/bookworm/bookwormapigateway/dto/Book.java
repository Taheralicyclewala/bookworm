package com.bookworm.bookwormapigateway.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;


public class Book implements  Serializable
{
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	private String id;

	@NotBlank	
	private String author;
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String language;
	
	@NotBlank
	private String synopsis;
	
	@NotEmpty
	private List<@NotBlank String> categories;
	
	@NotBlank
	private String publisher;
	
	@PastOrPresent
	private Date publicationDate;
	
	@Positive
	private int printLength;
	
	@NotBlank
	private String countryOfOrigin;
	
	@NotNull
	private BookRating bookRating;
	
	private BookAssessment bookAssessment;
	
	public Book() {
	}
	
	public Book(String id, String author, String title, String language, String synopsis,
			String publisher, Date publicationDate, int printLength, String countryOfOrigin) {
		super();
		this.id = id;
		this.author = author;
		this.title = title;
		this.language = language;
		this.synopsis = synopsis;
		this.publisher = publisher;
		this.publicationDate = publicationDate;
		this.printLength = printLength;
		this.countryOfOrigin = countryOfOrigin;
		this.categories = new ArrayList<String>();
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public int getPrintLength() {
		return printLength;
	}

	public void setPrintLength(int printLength) {
		this.printLength = printLength;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public BookRating getBookRating() {
		return bookRating;
	}

	public void setBookRating(BookRating bookRating) {
		this.bookRating = bookRating;
	}

	
	public BookAssessment getBookAssessment() {
		return bookAssessment;
	}

	public void setBookAssessment(BookAssessment bookAssessment) {
		this.bookAssessment = bookAssessment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}