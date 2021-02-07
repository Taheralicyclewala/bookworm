package com.bookworm.bookreview.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.bookreview.dto.UserReview;
import com.bookworm.bookreview.dto.UserReviews;
import com.bookworm.bookreview.repository.UserReviewRepository;


@Service
public class UserReviewService {
	
	@Autowired
	private UserReviewRepository userReviewRepository;
	
	public UserReviews getBookReviews(String bookId)
	{
		return getUserReviewsList(userReviewRepository.getUserReviewByBookId(bookId));
	}
	
	private UserReviews getUserReviewsList(Optional<List<com.bookworm.bookreview.model.UserReview>> userReviews)
	{
		if(userReviews.isPresent())
			return new UserReviews(userReviews.get().stream().map(userReview -> new UserReview(userReview)).collect(Collectors.toList()));
		else
			return new UserReviews();
	}
	
	public UserReviews getUserReviews(String userId)
	{
		return getUserReviewsList(userReviewRepository.getUserReviewByUserId(userId));
	}
	
	public UserReview addUserReview(@Valid UserReview userReview)
	{
		userReviewRepository.save(new com.bookworm.bookreview.model.UserReview(userReview));
		return userReview;
	}

}
