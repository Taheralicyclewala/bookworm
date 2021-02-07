package com.bookworm.bookrating.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookworm.bookrating.model.BookRating;
import com.bookworm.bookrating.services.BookRatingService;

@RestController
@RequestMapping("/book-rating")
public class BookRatingController implements BookRatingControllerInterface{
	
	@Autowired
	private BookRatingService bookRatingService;
	
	// checked working
	@GetMapping("/{bookId}")
	public BookRating getBookRating(@PathVariable("bookId") String bookId)
	{
		return bookRatingService.getBookRating(bookId);
	}
	
	@PostMapping("/add")
	public void addBookRating(@RequestBody BookRating bookRating)
	{
		bookRatingService.addBookRating(bookRating);
	}
	
}
