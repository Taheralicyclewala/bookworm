package com.bookworm.bookrating.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookworm.bookrating.dto.UserRating;
import com.bookworm.bookrating.dto.UserRatings;
import com.bookworm.bookrating.services.UserRatingService;

@RestController
@RequestMapping("/rating")
public class UserRatingController {
	
	
	@Autowired
	private UserRatingService userRatingService;
	
	@PostMapping("/add")
	public UserRating addUserRating(@RequestBody UserRating userRating)
	{
		return userRatingService.addUserRating(userRating);		
	}
	
	@GetMapping("/user/{userId}")
	public UserRatings getUserRatings(@PathVariable("userId") String userId)
	{
		return userRatingService.getUserRatings(userId);
	}
	
	@GetMapping("/book/{bookId}")
	public UserRatings getBookRatings(@PathVariable("bookId") String bookId)
	{
		return userRatingService.getBookRatings(bookId);
	}
}
