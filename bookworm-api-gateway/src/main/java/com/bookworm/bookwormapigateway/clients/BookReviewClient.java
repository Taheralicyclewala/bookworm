package com.bookworm.bookwormapigateway.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bookworm.bookwormapigateway.dto.UserReview;
import com.bookworm.bookwormapigateway.dto.UserReviews;


@FeignClient(url = "${book-review-url}", name = "book-review-service")
public interface BookReviewClient {
	
	@GetMapping("/user/{userId}")
	public UserReviews getUserReviewdBooks(@PathVariable("userId") String userId);
	
	@GetMapping("/book/{bookId}")
	public UserReviews getBookReviews(@PathVariable("bookId")String bookId);
	
	@PostMapping("/add")
	public UserReview addReviews(@RequestBody UserReview userReview);


}
