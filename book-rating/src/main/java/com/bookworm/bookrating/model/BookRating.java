package com.bookworm.bookrating.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "book_rating")
@EntityListeners(AuditingEntityListener.class)
public class BookRating implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "book_id", nullable = false)
	@NotBlank(message = "Book Id cannot be null or blank.")
	private String bookId;
	
	@Column(name = "ratings",nullable = false)	
	@Positive(message = "Ratings cannot be negative.")
	private long ratings;
	
	@Column(name = "avg_rating",nullable = false)
	@DecimalMin(value = "0.0", inclusive = false, message = "Average Rating cannot be negative or Zero")
	@DecimalMax(value = "5.0", inclusive = true, message = "Avergace Rating cannot be greater than 5" )
	private float averageRating;

	public BookRating(String bookId, long ratings, float averageRating) {
		super();
		this.bookId = bookId;
		this.ratings = ratings;
		this.averageRating = averageRating;
	}

	public BookRating() {
		super();		
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public long getRatings() {
		return ratings;
	}

	public void setRatings(long ratings) {
		this.ratings = ratings;
	}

	public float getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(float averageRating) {
		this.averageRating = averageRating;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
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
		BookRating other = (BookRating) obj;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BookRating [bookId=" + bookId + ", ratings=" + ratings + ", averageRating=" + averageRating + "]";
	}	
	
}
