package com.bookworm.bookwormapigateway.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class UserRating {
	
	@NotBlank(message = "Book Id cannot be null or blank")
	private String bookId;
	
	@NotBlank(message = "User Id cannot be null or blank")
	private String userId;
	
	@Min(value = 1,message = "Rating scale is from 1 to 5")
	@Max(value = 5, message = "Rating scale is from 1 to 5")
	private byte rating;
	
	
	public UserRating() {
	}	
	
	public UserRating(String bookId, String userId, byte rating) {
		this.bookId = bookId;
		this.userId = userId;
		this.rating = rating;
	}

	public UserRating(String bookId, String userId) {
		this.bookId = bookId;
		this.userId = userId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public byte getRating() {
		return rating;
	}

	public void setRating(byte rating) {
		this.rating = rating;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
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
		UserRating other = (UserRating) obj;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
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
		return "UserRating [bookId=" + bookId + ", userId=" + userId + ", rating=" + rating + "]";
	}
}

	