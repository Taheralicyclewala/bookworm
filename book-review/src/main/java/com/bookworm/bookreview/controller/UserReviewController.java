package com.bookworm.bookreview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookworm.bookreview.dto.UserReview;
import com.bookworm.bookreview.dto.UserReviews;
import com.bookworm.bookreview.services.UserReviewService;

@RestController
@RequestMapping("/review")
public class UserReviewController {
	
	@Autowired
	private UserReviewService userReviewService;
	
	
	@GetMapping("/user/{userId}")
	public UserReviews getUserReviews(@PathVariable("userId") String userId)
	{
		return userReviewService.getUserReviews(userId);
	}
	
	@GetMapping("/book/{bookId}")
	public UserReviews getBookReviews(@PathVariable("bookId")String bookId)
	{
		return userReviewService.getBookReviews(bookId);
	}
	
	@PostMapping("/add")
	public UserReview addReviews(@RequestBody UserReview userReview)
	{
		return userReviewService.addUserReview(userReview);
	}
	
}
