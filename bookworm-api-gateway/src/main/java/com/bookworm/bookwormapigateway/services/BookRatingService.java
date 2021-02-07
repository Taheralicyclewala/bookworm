package com.bookworm.bookwormapigateway.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.bookwormapigateway.clients.BookRatingClient;
import com.bookworm.bookwormapigateway.dto.UserRating;
import com.bookworm.bookwormapigateway.dto.UserRatings;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class BookRatingService {
	
	@Autowired
	private BookRatingClient bookRatingClient;

	@HystrixCommand(fallbackMethod = "addRatingFallback",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000"), // sets the timeout
					@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), // set the minimum number of threads in rolling window to be tracked
					@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "5"), // Set the error percentage at or above which the circuit trips 
					@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "3000")	// set the amount of time after circuit trip, the circuit will un-trip.									
			})
	public UserRating addRating(UserRating userRating) {
		return bookRatingClient.addUserRating(userRating);
	}
	
	
	public UserRating addRatingFallback(UserRating userRating) {
		return new UserRating(userRating.getBookId(),userRating.getUserId());
	}
	
	@HystrixCommand(fallbackMethod = "getBookRatingsFallback",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000"), // sets the timeout
					@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), // set the minimum number of threads in rolling window to be tracked
					@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "5"), // Set the error percentage at or above which the circuit trips 
					@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "3000")	// set the amount of time after circuit trip, the circuit will un-trip.									
			})
	public UserRatings getBookRatings(String bookId)
	{
		return bookRatingClient.getBookRatings(bookId);
	}
	
	public UserRatings getBookRatingsFallback(String bookId)
	{
		return new UserRatings();
	}

	@HystrixCommand(fallbackMethod = "getUserRatingsFallback",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000"), // sets the timeout
					@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), // set the minimum number of threads in rolling window to be tracked
					@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "5"), // Set the error percentage at or above which the circuit trips 
					@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "3000")	// set the amount of time after circuit trip, the circuit will un-trip.									
			})
	public UserRatings getUserRatings(String userId) {
		return bookRatingClient.getUserRatings(userId);
	}
	
	public UserRatings getUserRatingsFallback(String userId)
	{
		return new UserRatings();
	}

}
