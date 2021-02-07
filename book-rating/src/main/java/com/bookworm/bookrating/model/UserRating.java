package com.bookworm.bookrating.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Table(name = "user_rating")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class UserRating implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
    @Embedded
    private UserBookIdentity userBookIdentity;
	
	
	@Column(name = "rating",nullable = false)
	private byte rating;


	public UserRating() {
		super();
	}

	public UserRating(com.bookworm.bookrating.dto.UserRating userRating,BookRating bookRating)
	{
		this(new UserBookIdentity(bookRating,userRating.getUserId()),userRating.getRating());
	}
	
	public UserRating(UserBookIdentity userBookIdentity, byte rating) {
		super();
		this.userBookIdentity = userBookIdentity;
		this.rating = rating;
	}


	public UserBookIdentity getUserBookIdentity() {
		return userBookIdentity;
	}


	public void setUserBookIdentity(UserBookIdentity userBookIdentity) {
		this.userBookIdentity = userBookIdentity;
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
		UserRating other = (UserRating) obj;
		if (userBookIdentity == null) {
			if (other.userBookIdentity != null)
				return false;
		} else if (!userBookIdentity.equals(other.userBookIdentity))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "UserRating [userBookIdentity=" + userBookIdentity + ", rating=" + rating + "]";
	}

}
