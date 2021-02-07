package com.bookworm.bookwormapigateway.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookworm.bookwormapigateway.dto.Books;
import com.bookworm.bookwormapigateway.dto.ServiceResponse;
import com.bookworm.bookwormapigateway.dto.UserRating;
import com.bookworm.bookwormapigateway.dto.UserReview;
import com.bookworm.bookwormapigateway.services.GatewayService;

@RestController
@RequestMapping("/api")
public class GatewayController {
	
	@Autowired	
	private GatewayService gatewayService;
	
	@GetMapping("/books")
	public ResponseEntity<ServiceResponse> getBooks()
	{
		Books books = gatewayService.getAllBooks();
		return responseWrapper(books);	
	}
	
	@GetMapping("/book/{bookId}")
	public ResponseEntity<ServiceResponse> getBookAssessments(@PathVariable("bookId") String bookId)
	{
		return responseWrapper(gatewayService.getBookAssessments(bookId));
	}
	
	@PostMapping("/review/add")
	public ResponseEntity<ServiceResponse> addReview(@Valid @RequestBody UserReview userReview)
	{
		UserReview userReviewResponse = gatewayService.addUserReview(userReview);
		return responseWrapper(userReviewResponse);
	}
	
	@PostMapping("/rating/add")
	public ResponseEntity<ServiceResponse> addRating(@Valid @RequestBody UserRating userRating)
	{
		UserRating userRatingResponse = gatewayService.addUserRating(userRating);
		return responseWrapper(userRatingResponse);
	}
	
	
	@GetMapping("/myReads/{userId}")
	private ResponseEntity<ServiceResponse> getUserBookReads(@PathVariable("userId") String userId)
	{
		ServiceResponse serviceResponse = new ServiceResponse();
		Books books = gatewayService.getBookReads(userId);
		if(books == null) serviceResponse.setError("Some unexpected error occured");
		return responseWrapper(serviceResponse);
	}

	
	private ResponseEntity<ServiceResponse> responseWrapper(Object object)
	{
		return new ResponseEntity<ServiceResponse>(new ServiceResponse(object),HttpStatus.ACCEPTED);
	}
	

}
