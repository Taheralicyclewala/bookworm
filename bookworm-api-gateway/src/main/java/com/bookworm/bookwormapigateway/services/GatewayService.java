package com.bookworm.bookwormapigateway.services;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.bookwormapigateway.dto.Book;
import com.bookworm.bookwormapigateway.dto.BookAssessment;
import com.bookworm.bookwormapigateway.dto.BookAssessments;
import com.bookworm.bookwormapigateway.dto.Books;
import com.bookworm.bookwormapigateway.dto.UserRating;
import com.bookworm.bookwormapigateway.dto.UserRatings;
import com.bookworm.bookwormapigateway.dto.UserReview;
import com.bookworm.bookwormapigateway.dto.UserReviews;
import com.bookworm.bookwormapigateway.exception.InvalidIdException;
import com.bookworm.bookwormapigateway.model.User;
import com.bookworm.bookwormapigateway.repository.UserRepository;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

@Service
public class GatewayService {
	
	@Autowired private BookInfoService bookInfoService;
	
	@Autowired private BookReviewService bookReviewService;
	
	@Autowired private BookRatingService bookRatingService;
	
	@Autowired private UserRepository userRepository;
	
	private final static Logger logger = LoggerFactory.getLogger(GatewayService.class);

	public Books getAllBooks()
	{
		return bookInfoService.getBooks();
	}
	
	public UserRating addUserRating(@Valid UserRating userRating)
	{
		// Authentication steps will be performed here to validate the user.
		return bookRatingService.addRating(userRating);
	}
	
	public Books getBookReads(String userId) {
		if(userId == null || userId.trim().equals("")) throw new InvalidIdException("User Id",userId);
		userId = userId.trim();
		UserRatings userRatings = bookRatingService.getUserRatings(userId);
		UserReviews userReviews = bookReviewService.getUserReviews(userId);
		return new Books(buildBookAssessments(userRatings,userReviews,true).entrySet().stream().map(mapper -> {
			Book book = bookInfoService.getBook(mapper.getKey());
			BookAssessments bookAssessements = new BookAssessments();
			bookAssessements.setBookId(book.getId());
			bookAssessements.addAssessment(mapper.getValue());
			book.setBookAssessments(bookAssessements);
			return book;
		}).collect(Collectors.toList()));
	}
	
	public BookAssessments getBookAssessments(String bookId)
	{
		if(bookId == null || bookId.trim().equals("")) throw new InvalidIdException("Book Id",bookId);
		//Both these call can be implemented in asynchronous way
		bookId = bookId.trim();
		UserRatings userRatings = bookRatingService.getBookRatings(bookId);
		UserReviews userReviews = bookReviewService.getBookReviews(bookId);	
		List<BookAssessment> bookAssessments = buildBookAssessments(userRatings,userReviews,false).entrySet().stream().map(mapper -> mapper.getValue()).collect(Collectors.toList()); 
		return new BookAssessments(bookId,bookAssessments);
	}
	
	
	private ConcurrentHashMap<String, BookAssessment> buildBookAssessments(UserRatings userRatings, UserReviews userReviews, boolean byBook) {
		ConcurrentHashMap<String,BookAssessment> assessmentMap = new ConcurrentHashMap<>();
		userRatings.getUserRatings().parallelStream().forEach(userRating -> {
			BookAssessment assessment = new BookAssessment();
			assessment.setRating(userRating.getRating());
			if(!byBook)
			{
				String userId = userRating.getUserId();
				User user = userRepository.findById(Long.parseLong(userId)).get();
				assessment.setUser(user);				
				assessmentMap.put(userId, assessment);
			}
			else
			{
				assessmentMap.put(userRating.getBookId(),assessment);
			}
		});
		userReviews.getUserReviews().parallelStream().forEach(userReview -> {			
			if(!byBook)
			{
				String userId = userReview.getUserId();
				User user = userRepository.findById(Long.parseLong(userId)).get();
				BookAssessment assessment = (assessmentMap.containsKey(userId))?assessmentMap.get(userId):new BookAssessment(user);
				assessment.setReview(userReview.getReview());
				assessmentMap.put(userReview.getUserId(),assessment);
			}
			else
			{
				String bookId = userReview.getBookId();
				BookAssessment assessment = (assessmentMap.containsKey(bookId))?assessmentMap.get(bookId):new BookAssessment();
				assessment.setReview(userReview.getReview());
				assessmentMap.put(userReview.getBookId(),assessment);
			}			
		});
		return 	assessmentMap;	
	}

	public UserReview addUserReview(@Valid UserReview userReview)
	{
		// Authentication steps will be peformed here to validate the user.
		return bookReviewService.addReview(userReview);
	}

	public Books getAllBooksByCategory(String categoryName) {
		if(categoryName == null || categoryName.trim().equals(""))
			throw new InvalidIdException("Category Type",categoryName);
		return bookInfoService.getBooksByCategory(categoryName);
	}

	public Books getAllBooksByAuthor(String authorName) {		
		if(authorName == null || authorName.trim().equals(""))
			throw new InvalidIdException("Author Name",authorName);
		return bookInfoService.getBooksByAuthor(authorName);

	}

	public Book getBookByTitle(String title) {
		if(title == null || title.trim().equals(""))
			throw new InvalidIdException(" Book title", title);
		return bookInfoService.getBookByTitle(title);	
	}
}