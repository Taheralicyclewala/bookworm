package com.bookworm.bookwormapigateway.dto;

import java.util.ArrayList;
import java.util.List;


public class UserReviews {
	
	private List<UserReview> userReviews;

	public UserReviews() {
		this.userReviews = new ArrayList<UserReview>();
	}

	public UserReviews(List<UserReview> userReviews) {
		this.userReviews = userReviews;
	}

	public List<UserReview> getUserReviews() {
		return userReviews;
	}

	public void setUserReviews(List<UserReview> userReviews) {
		this.userReviews = userReviews;
	}

	@Override
	public String toString() {
		return "UserReviews [userReviews=" + userReviews + "]";
	}
}