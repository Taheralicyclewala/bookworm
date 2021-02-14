package com.bookworm.bookwormapigateway.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookworm.bookwormapigateway.dto.Book;
import com.bookworm.bookwormapigateway.dto.Books;
import com.bookworm.bookwormapigateway.dto.ServiceResponse;
import com.bookworm.bookwormapigateway.services.GatewayService;

@RestController
@RequestMapping("/api/books")
public class GatewayController {
	
	@Autowired	
	private GatewayService gatewayService;
	
	@GetMapping("/all")
	public ResponseEntity<ServiceResponse> getBooks()
	{
		Books books = gatewayService.getAllBooks();
		return responseWrapper(books);	
	}
	
	@GetMapping("/category/{categoryName}")
	public ResponseEntity<ServiceResponse> getBooksByCategory(@PathVariable("categoryName") String categoryName)
	{
		Books books = gatewayService.getAllBooksByCategory(categoryName);
		return responseWrapper(books);
	}
		
	@GetMapping("/author/{authorName}")
	public ResponseEntity<ServiceResponse> getBooksByAuthor(@PathVariable("authorName") String authorName)
	{
		Books books = gatewayService.getAllBooksByAuthor(authorName);
		return responseWrapper(books);
	}
	
	@GetMapping("/book/{bookId}")
	public ResponseEntity<ServiceResponse> getBookAssessments(@PathVariable("bookId") String bookId)
	{
		return responseWrapper(gatewayService.getBookAssessments(bookId));
	}
	
	@GetMapping("/title/{title}")
	public ResponseEntity<ServiceResponse> getBookByTitle(@PathVariable("title")String title)
	{
		Book book = gatewayService.getBookByTitle(title);
		return responseWrapper(book);
	}

	private ResponseEntity<ServiceResponse> responseWrapper(Object object)
	{
		return new ResponseEntity<ServiceResponse>(new ServiceResponse(object),HttpStatus.ACCEPTED);
	}
}
