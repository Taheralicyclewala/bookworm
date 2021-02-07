package com.bookworm.bookreview.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name ="user_review")
@EntityListeners(AuditingEntityListener.class)
public class UserReview implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@EmbeddedId
	private UserBookIdentity userBookIdentity;
	
	@Column(name = "review", nullable = false)
	private String review;

	public UserReview(com.bookworm.bookreview.dto.UserReview userReviewDto)
	{
		this(new UserBookIdentity(userReviewDto.getUserId(),userReviewDto.getBookId()),userReviewDto.getReview());
	}
	
	public UserReview() {				
	}

	public UserReview(UserBookIdentity userBookIdentity, String review) {
		this.userBookIdentity = userBookIdentity;
		this.review = review;
	}

	public UserBookIdentity getUserBookIdentity() {
		return userBookIdentity;
	}

	public void setUserBookIdentity(UserBookIdentity userBookIdentity) {
		this.userBookIdentity = userBookIdentity;
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
		result = prime * result + ((userBookIdentity == null) ? 0 : userBookIdentity.hashCode());
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
		if (userBookIdentity == null) {
			if (other.userBookIdentity != null)
				return false;
		} else if (!userBookIdentity.equals(other.userBookIdentity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserReview [userBookIdentity=" + userBookIdentity + ", review=" + review + "]";
	}
	
	
	
	
	
	

}
