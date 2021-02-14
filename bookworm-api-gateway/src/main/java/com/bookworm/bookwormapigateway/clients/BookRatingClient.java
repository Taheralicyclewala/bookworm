package com.bookworm.bookwormapigateway.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bookworm.bookwormapigateway.dto.UserRating;
import com.bookworm.bookwormapigateway.dto.UserRatings;


@FeignClient(url = "${book-rating-url}", name = "book-rating-service")
public interface BookRatingClient {
	
	@PostMapping("/add")
	public UserRating addUserRating(@RequestBody UserRating userRating);
	
	@GetMapping("/user/{userId}")
	public UserRatings getUserRatings(@PathVariable("userId") String userId);
	
	@GetMapping("/book/{bookId}")
	public UserRatings getBookRatings(@PathVariable("bookId") String bookId);
	

}
