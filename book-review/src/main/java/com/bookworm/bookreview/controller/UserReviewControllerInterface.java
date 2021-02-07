package com.bookworm.bookreview.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bookworm.bookreview.dto.UserReview;
import com.bookworm.bookreview.dto.UserReviews;

public interface UserReviewControllerInterface {
	
	@GetMapping("/user/{userId}")
	public UserReviews getUserReviewdBooks(@PathVariable("userId") String userId);
	
	@GetMapping("/book/{bookId}")
	public UserReviews getBookReviews(@PathVariable("bookId")String bookId);
	
	@PostMapping("/add")
	public void addReviews(@RequestBody UserReview userReview);

}
