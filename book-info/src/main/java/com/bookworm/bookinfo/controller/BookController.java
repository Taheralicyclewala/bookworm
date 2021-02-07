package com.bookworm.bookinfo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookworm.bookinfo.dto.Book;
import com.bookworm.bookinfo.dto.Books;
import com.bookworm.bookinfo.repository.BookRepository;
import com.bookworm.bookinfo.services.BookService;

@RestController
@RequestMapping("/books")
public class BookController implements BookControllerInterface{
	
	
	@Autowired
	BookService bookService;
	
	@Autowired
	BookRepository bookRepository;
	
	@GetMapping("/all")
	@ResponseBody
	public Books getBooks()
	{
		return bookService.getBooks();
	}
	
	@GetMapping("/all-by-author/{author}")
	public Books getBooksByAuthor(@PathVariable("author") String author)
	{
		return bookService.getBooksByAuthor(author);
	}
	
	@GetMapping("/all-by-category/{category}")
	public Books getBooksByCategory(@PathVariable("category") String category)
	{
		return bookService.getBooksByCategory(category);
	}
	
	@GetMapping("/book/{bookId}")
	public Book getBook(@PathVariable("bookId") String bookId)
	{
		return bookService.getBookById(bookId);
	}
	@GetMapping("/title/{title}")
	public Book getBookByTitle(@PathVariable("title") String title)
	{
		return bookService.getBooksByTitle(title);
	}	
		
	@PostMapping("/add")
	public Book addBook(@Valid @RequestBody Book book)
	{
		return null;
	}
}
