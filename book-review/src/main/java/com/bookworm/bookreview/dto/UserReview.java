package com.bookworm.bookreview.dto;

import javax.validation.constraints.NotBlank;

public class UserReview {
	
	@NotBlank
	private String bookId;
	
	@NotBlank
	private String userId;
	
	@NotBlank
	private String review;

	public UserReview() {
	}
	
	public UserReview(com.bookworm.bookreview.model.UserReview userReviewModel)
	{
		this(userReviewModel.getUserBookIdentity().getBookId(),userReviewModel.getUserBookIdentity().getUserId(),userReviewModel.getReview());
	}

	
	public UserReview(String bookId, String userId, String review) {
		super();
		this.bookId = bookId;
		this.userId = userId;
		this.review = review;
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

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
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
		UserReview other = (UserReview) obj;
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
		return "UserReview [bookId=" + bookId + ", userId=" + userId + ", review=" + review + "]";
	}

}
