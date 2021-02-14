package com.bookworm.bookinfo.services;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.bookinfo.model.Author;
import com.bookworm.bookinfo.model.BookCategoryMapping;
import com.bookworm.bookinfo.model.Category;
import com.bookworm.bookinfo.dto.Book;
import com.bookworm.bookinfo.dto.Books;
import com.bookworm.bookinfo.exception.EntityNotFoundException;
import com.bookworm.bookinfo.exception.InvalidIdException;
import com.bookworm.bookinfo.repository.BookCategoryMappingRepository;
import com.bookworm.bookinfo.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookCategoryMappingRepository bookCategoryMappingRepository;
				
	@Autowired
	private BookRatingService bookRatingService;
	
	@Autowired
	private HashMap<String,Category> categories;
	
	@Autowired
	private HashMap<String,Author> authors;
	
	
	public Book addBook(@Valid Book book)
	{
		return book;
	}

	public Books getBooks()
	{
		return new Books(getBooksDto(bookRepository.findAll()));
	}
	
	public Book getBookById(String bookId) throws InvalidIdException, EntityNotFoundException
	{
		if(bookId == null | bookId.trim().equals("")) throw new InvalidIdException("Book Id", bookId);		
		Optional<com.bookworm.bookinfo.model.Book> modelBook = bookRepository.findById(Integer.parseInt(bookId));		
		if(modelBook.isPresent())
		{
			return getBookDetails(new Book(modelBook.get()));
		}
		else
		{
			throw new EntityNotFoundException(com.bookworm.bookinfo.model.Book.class, "book Id ", bookId);
		}
	}
	
	
	public Book getBookDetails(Book book)
	{		
		Optional<List<BookCategoryMapping>> categories = bookCategoryMappingRepository.findCategoriesByBook(Integer.parseInt(book.getId()));

		if(categories.isPresent()) book.setCategories(categories.get().stream().map(mapping -> mapping.getBookCategoryIdentity().getCategory().getType()).collect(Collectors.toList()));
		
		book.setBookRating(bookRatingService.getBookRating(book.getId()));
		
		return book;
	}
	
	public List<Book> getBooksDto(List<com.bookworm.bookinfo.model.Book> bookList)
	{
		return bookList.stream().map(book-> getBookDetails(new Book(book))).collect(Collectors.toList());
	}
	
	
	
	public Books getBooksByAuthor(String authorName) throws EntityNotFoundException
	{
		
//		Author author = authorSerivce.getAuthor(authorName);
		
		Author author = authors.get(authorName.trim().toLowerCase());

		Optional<List<com.bookworm.bookinfo.model.Book>> optionalList = bookRepository.findBookByAuthor(author.getId());

		if(optionalList.isPresent())
			return new Books(getBooksDto(optionalList.get()));				
		else 
			return new Books();		// Refactor this line of Code also
	}
	
	public Books getBooksByCategory(String categoryName) throws EntityNotFoundException , RuntimeException
	{
		//Category category = categorySerivce.getCategory(categoryName);
		
		Category category = categories.get(categoryName.trim().toLowerCase());
		
		if(category == null) throw new EntityNotFoundException(Category.class,"Type",categoryName);
		
		Optional<List<BookCategoryMapping>> mappingList = bookCategoryMappingRepository.findBooksByCategory(category.getId());
		
		if(mappingList.isPresent())			
		{	
			return new Books(mappingList.get().stream().map(mapping -> {
				return getBookDetails(new Book(mapping.getBookCategoryIdentity().getBook()));
			}).collect(Collectors.toList()));
		}
		else
		{
			// Refactor this line of code.
			throw new RuntimeException("Unable to fetch the Books under category type : "+categoryName);
		}
	}
	
	public Book getBooksByTitle(String title)
	{
		if(title == null || title.trim().equals("")) throw new RuntimeException("Invalid book title passed for searching books.");		
		
		Optional<com.bookworm.bookinfo.model.Book> modelBook = bookRepository.findBookByTitle(title.trim());

		if(modelBook.isPresent())
			return getBookDetails(new Book(modelBook.get()));
		return new Book();  // Refactor this line of code.
	}
	

//	public Book addBook(Book book) throws Exception{
//		throw new Exception("Checking No Handler Exception");
//	}
	
	
	
	

	
	
}
