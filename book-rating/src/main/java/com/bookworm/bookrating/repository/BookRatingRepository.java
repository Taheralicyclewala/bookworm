package com.bookworm.bookrating.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookworm.bookrating.model.BookRating;

@Repository
public interface BookRatingRepository extends JpaRepository<BookRating,String>{
	
	

}
