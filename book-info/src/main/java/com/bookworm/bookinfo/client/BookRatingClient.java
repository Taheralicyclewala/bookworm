package com.bookworm.bookinfo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bookworm.bookinfo.dto.BookRating;


@FeignClient(url = "${book-rating-url}",name = "book-rating-service")
public interface BookRatingClient{
	
	@GetMapping("/{bookId}")
	public BookRating getBookRating(@PathVariable("bookId") String bookId);
	
	@PostMapping("/add")
	public void addBookRating(@RequestBody BookRating bookRating);

}
