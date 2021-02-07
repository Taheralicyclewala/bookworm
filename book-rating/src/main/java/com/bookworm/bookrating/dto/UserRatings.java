package com.bookworm.bookrating.dto;

import java.util.ArrayList;
import java.util.List;

public class UserRatings {
	
	List<UserRating> userRatings;

	
	public UserRatings() {
		this.userRatings = new ArrayList<>();
	}

	
	public UserRatings(List<UserRating> userRatings) {
		super();
		this.userRatings = userRatings;
	}

	public List<UserRating> getUserRatings() {
		return userRatings;
	}

	public void setUserRatings(List<UserRating> userRatings) {
		this.userRatings = userRatings;
	}

}
