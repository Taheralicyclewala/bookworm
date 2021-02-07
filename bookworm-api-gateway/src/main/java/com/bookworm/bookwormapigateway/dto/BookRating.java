package com.bookworm.bookwormapigateway.dto;

import java.io.Serializable;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Positive;

public class BookRating implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookRating(String bookId, long ratings, float averageRating) {
		this.bookId = bookId;
		this.ratings = ratings;
		this.averageRating = averageRating;
	}
	
	public BookRating() {
	}

	public BookRating(String bookId) {
		this.bookId = bookId;
	}

	private String bookId;
	
	@DecimalMin(value = "0.0", inclusive = false)
	@DecimalMax(value = "5.0", inclusive = false)
	@Digits(fraction = 4, integer = 1)
	private float averageRating;
	
	@Positive
	private long ratings;

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
}
