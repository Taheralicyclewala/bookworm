package com.bookworm.bookwormapigateway.clients;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookworm.bookwormapigateway.dto.Book;
import com.bookworm.bookwormapigateway.dto.Books;


@FeignClient(url = "${book-info-url}", name = "book-info-service")
public interface BookInfoClient {
	
	@GetMapping("/all")
	@ResponseBody
	public Books getBooks();
	
	@GetMapping("/all-by-category/{category}")
	public Books getBooksByCategory(@PathVariable("category") String category);
	
	@GetMapping("/all-by-author/{author}")
	public Books getBooksByAuthor(@PathVariable("author") String author);
	
	@GetMapping("/book/{bookId}")
	public Book getBook(@PathVariable("bookId") String bookId);
	
	@GetMapping("/title/{title}")
	public Book getBookByTitle(@PathVariable("title") String title);
	
	@PostMapping("/add")
	public Book addBook(@Valid @RequestBody Book book);
}
