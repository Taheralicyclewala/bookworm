package com.bookworm.bookrating.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookworm.bookrating.model.UserBookIdentity;
import com.bookworm.bookrating.model.UserRating;

@Repository
public interface UserRatingRepository extends JpaRepository<UserRating,UserBookIdentity>{
	
	@Query(value = "Select * from user_rating ur where ur.user_id =:userId",nativeQuery = true)
	Optional<List<UserRating>> findUserRatingByUserId(@Param("userId")String userId);

	@Query(value = "Select * from user_rating ur where ur.book_id =:bookId",nativeQuery = true)
	Optional<List<UserRating>> findUserRatingByBookId(@Param("bookId")String bookId);
	
}
