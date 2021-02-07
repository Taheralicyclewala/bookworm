package com.bookworm.bookrating.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bookworm.bookrating.dto.UserRating;
import com.bookworm.bookrating.dto.UserRatings;

public interface UserRatingControllerInterface {
	
	@PostMapping("/add")
	public void addUserRating(@RequestBody UserRating userRating);
	
	@GetMapping("/{userId}")
	public UserRatings getUserRatings(@PathVariable("userId") String userId);
	
	@GetMapping("/{bookId}")
	public UserRatings getBookRatings(@PathVariable("bookId") String bookId);

}
