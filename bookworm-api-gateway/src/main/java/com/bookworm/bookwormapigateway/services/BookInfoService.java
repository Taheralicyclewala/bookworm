package com.bookworm.bookwormapigateway.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.bookwormapigateway.clients.BookInfoClient;
import com.bookworm.bookwormapigateway.dto.Book;
import com.bookworm.bookwormapigateway.dto.Books;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class BookInfoService {
	
	@Autowired
	private BookInfoClient bookInfoClient;
	
	@HystrixCommand(fallbackMethod = "getBooksFallback",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000"),
					@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
					@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "5"),
					@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "3000")
			})
	public Books getBooks()
	{
		return bookInfoClient.getBooks();
	}
	
	public Books getBooksFallback()
	{
		return new Books();
	}
	@HystrixCommand(fallbackMethod = "getBookFallback",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000"),
					@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
					@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "5"),
					@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "3000")
			})
	public Book getBook(String bookId)
	{
		return bookInfoClient.getBook(bookId);
	}
	
	public Book getBookFallback(String bookId)
	{
		return new Book();
	}

}
