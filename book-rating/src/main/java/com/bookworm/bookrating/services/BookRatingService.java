package com.bookworm.bookrating.services;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.bookrating.exception.EntityNotFoundException;
import com.bookworm.bookrating.exception.InvalidIdException;
import com.bookworm.bookrating.model.BookRating;
import com.bookworm.bookrating.repository.BookRatingRepository;

@Service
public class BookRatingService {
	
	@Autowired
	private BookRatingRepository bookRatingRepository;
	
	
	public BookRating getBookRating(String bookId) throws EntityNotFoundException, InvalidIdException
	{
		if(bookId == null || bookId.trim().equals("")) 
			throw new InvalidIdException("Book Id",bookId);
		Optional<BookRating> bookRating =  bookRatingRepository.findById(bookId.trim());
		if(bookRating.isPresent())
		{
			return bookRating.get();
		}
		else
		{
			throw new EntityNotFoundException(BookRating.class,"Book Id", bookId);
		}
	}
	
	public BookRating addBookRating(@Valid BookRating bookRating)
	{
		return bookRatingRepository.save(bookRating);
	}

}
