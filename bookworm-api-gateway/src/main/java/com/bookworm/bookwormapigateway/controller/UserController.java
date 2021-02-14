package com.bookworm.bookwormapigateway.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.bookworm.bookwormapigateway.dto.Books;
import com.bookworm.bookwormapigateway.dto.ServiceResponse;
import com.bookworm.bookwormapigateway.dto.UserRating;
import com.bookworm.bookwormapigateway.dto.UserReview;
import com.bookworm.bookwormapigateway.services.GatewayService;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;


@RestController
@RequestMapping("/api/users")
@PreAuthorize("hasRole('USER')")
public class UserController {


//	private final static Logger log = LoggerFactory.getLogger(UserController.class);
	
    @Autowired
    private GatewayService gatewayService;
        
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
	
	@GetMapping("/my-reads/{userId}")
	public ResponseEntity<ServiceResponse> getUserBookReads(@PathVariable("userId") String userId)
	{
		Books books = gatewayService.getBookReads(userId);
		return responseWrapper(books);
	}
 
	private ResponseEntity<ServiceResponse> responseWrapper(Object object)
	{
		return new ResponseEntity<ServiceResponse>(new ServiceResponse(object),HttpStatus.ACCEPTED);
	}
}