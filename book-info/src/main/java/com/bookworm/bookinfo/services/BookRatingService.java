package com.bookworm.bookinfo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.bookinfo.client.BookRatingClient;
import com.bookworm.bookinfo.dto.BookRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class BookRatingService {
	
	@Autowired
	private BookRatingClient bookRatingClient;
	
	@HystrixCommand(fallbackMethod = "getBookRatingFallback",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000"), // sets the timeout
					@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), // set the minimum number of threads in rolling window to be tracked
					@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "5"), // Set the error percentage at or above which the circuit trips 
					@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "3000")	// set the amount of time after circuit trip, the circuit will un-trip.				
			})
	public BookRating getBookRating(String bookId)
	{
		return bookRatingClient.getBookRating(bookId);
	}
	
	public BookRating getBookRatingFallback(String bookId)
	{
		System.out.println("*********************Running [getBookRatingFallback()] method**************************");
		return new BookRating(bookId);
	}


}
