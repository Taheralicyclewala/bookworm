package com.bookworm.bookinfo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="book")
@EntityListeners(AuditingEntityListener.class)
public class Book {
		
	@Id
	@Column(name = "isbn10",length = 15)
	private String isbn;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "author_id",nullable = false)
	private Author author;
	
	@Column(name = "title", nullable = false, unique = true)
	private String title;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "language_id", nullable = false)
	private Language language; 
	
	@Column(name = "synopsis")
	private String synopsis;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "country_id", nullable = false)
	private Country countryOfOrigin;
	
	@Column(name = "publisher")
	private String publisher;
	
	@Column(name = "print_length")
	private int printLength;
	
	@Column(name = "publication_date")
	@Temporal(TemporalType.DATE)
	private Date publicationDate;

	public Book() {
	}

	
	public Book(String isbn, Author author, String title, Language language, String synopsis, Country countryOfOrigin,
			String publisher, int printLength, Date publicationDate) {
		super();
		this.isbn = isbn;
		this.author = author;
		this.title = title;
		this.language = language;
		this.synopsis = synopsis;
		this.countryOfOrigin = countryOfOrigin;
		this.publisher = publisher;
		this.printLength = printLength;
		this.publicationDate = publicationDate;
	}


	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public Country getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(Country countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrintLength() {
		return printLength;
	}

	public void setPrintLength(int printLength) {
		this.printLength = printLength;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
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
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}

}
