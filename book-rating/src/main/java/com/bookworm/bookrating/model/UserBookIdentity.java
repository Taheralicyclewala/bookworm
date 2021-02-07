package com.bookworm.bookrating.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class UserBookIdentity implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "book_id", nullable = false)
	private BookRating bookRating;

	
	@Column(name = "user_id",nullable = false)
	private String userId;
	
	public UserBookIdentity(BookRating bookRating, String userId) {
		super();
		this.bookRating = bookRating;
		this.userId = userId;
	}


	public UserBookIdentity() {
		super();
		// TODO Auto-generated constructor stub
	}



	public BookRating getBookRating() {
		return bookRating;
	}


	public void setBookRating(BookRating bookRating) {
		this.bookRating = bookRating;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookRating == null) ? 0 : bookRating.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		UserBookIdentity other = (UserBookIdentity) obj;
		if (bookRating == null) {
			if (other.bookRating != null)
				return false;
		} else if (!bookRating.equals(other.bookRating))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "UserBookIdentity [bookRating=" + bookRating + ", userId=" + userId + "]";
	}

	
	
}

