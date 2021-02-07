package com.bookworm.bookrating.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bookworm.bookrating.model.BookRating;

public interface BookRatingControllerInterface {
	

	@GetMapping("/{bookId}")
	public BookRating getBookRating(@PathVariable("bookId") String bookId);
	
	@PostMapping("/add")
	public void addBookRating(@RequestBody BookRating bookRating);

}
