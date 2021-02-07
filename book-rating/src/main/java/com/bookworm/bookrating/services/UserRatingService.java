package com.bookworm.bookrating.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.bookrating.dto.UserRating;
import com.bookworm.bookrating.dto.UserRatings;
import com.bookworm.bookrating.exception.EntityNotFoundException;
import com.bookworm.bookrating.exception.InvalidIdException;
import com.bookworm.bookrating.model.BookRating;
import com.bookworm.bookrating.repository.UserRatingRepository;

@Service
public class UserRatingService {
	
	@Autowired
	UserRatingRepository userRatingRepository;
	
	@Autowired
	BookRatingService bookRatingService;
			
	public UserRating addUserRating(@Valid UserRating userRating) throws EntityNotFoundException, InvalidIdException
	{
		BookRating bookRating = updateRatingInfo(bookRatingService.getBookRating(userRating.getBookId()),userRating);
		userRatingRepository.save(new com.bookworm.bookrating.model.UserRating(userRating, bookRating));
		return userRating;
	}
	
	// Will be called when user wants to see his reads.This service will be Indirectly called by API - Gateway.
	public UserRatings getUserRatings(String userId)
	{
		return getUserRatingsList(userRatingRepository.findUserRatingByUserId(userId));
	}
	
	private UserRatings getUserRatingsList(Optional<List<com.bookworm.bookrating.model.UserRating>> userRatings)
	{
		if(userRatings.isPresent())
			return new UserRatings(userRatings.get().stream().map(userRating -> new UserRating(userRating)).collect(Collectors.toList()));
		else
			return new UserRatings();
	}
	
	
	// Will be called when someone wants to see a detail book view, it will be hit by book-api-gateway
	public UserRatings getBookRatings(String bookId) 
	{
		return getUserRatingsList(userRatingRepository.findUserRatingByBookId(bookId));
	}
	
	
	private BookRating updateRatingInfo(BookRating oldBookRating,UserRating userRating)
	{
		float oldAvg = oldBookRating.getAverageRating();
		long ratings = oldBookRating.getRatings();
		float newAvg = (oldAvg*ratings + userRating.getRating())/(ratings+1);
		return bookRatingService.addBookRating(new BookRating(oldBookRating.getBookId(),ratings+1,newAvg));
		
	}
}
