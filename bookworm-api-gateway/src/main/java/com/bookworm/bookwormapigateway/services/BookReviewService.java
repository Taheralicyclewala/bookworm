package com.bookworm.bookwormapigateway.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.bookwormapigateway.clients.BookReviewClient;
import com.bookworm.bookwormapigateway.dto.UserReview;
import com.bookworm.bookwormapigateway.dto.UserReviews;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class BookReviewService {
	
	@Autowired
	private BookReviewClient bookReviewClient;
	
	@HystrixCommand(fallbackMethod = "addReviewFallback",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000"), // sets the timeout
					@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), // set the minimum number of threads in rolling window to be tracked
					@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "5"), // Set the error percentage at or above which the circuit trips 
					@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "3000")	// set the amount of time after circuit trip, the circuit will un-trip.									
			})
	public UserReview addReview(UserReview userReview)
	{
		return bookReviewClient.addReviews(userReview);
	}
	
	public UserReview addReviewFallback(UserReview userReview)
	{
		return new UserReview(userReview.getBookId(),userReview.getUserId());
	}
	@HystrixCommand(fallbackMethod = "getBookReviewsFallback",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000"), // sets the timeout
					@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), // set the minimum number of threads in rolling window to be tracked
					@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "5"), // Set the error percentage at or above which the circuit trips 
					@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "3000")	// set the amount of time after circuit trip, the circuit will un-trip.									
			})
	public UserReviews getBookReviews(String bookId)
	{
		return bookReviewClient.getBookReviews(bookId);
	}
	
	public UserReviews getBookReviewsFallback(String bookId)
	{
		return new UserReviews();
	}
	
	@HystrixCommand(fallbackMethod = "getUserReviewsFallback",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000"), // sets the timeout
					@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), // set the minimum number of threads in rolling window to be tracked
					@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "5"), // Set the error percentage at or above which the circuit trips 
					@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "3000")	// set the amount of time after circuit trip, the circuit will un-trip.									
			})
	public UserReviews getUserReviews(String userId) {
		return bookReviewClient.getUserReviewdBooks(userId);
	}
	
	public UserReviews getUserReviewsFallback(String userId)
	{
		return new UserReviews();
	}
	
}
