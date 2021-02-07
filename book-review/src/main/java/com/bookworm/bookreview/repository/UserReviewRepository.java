package com.bookworm.bookreview.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookworm.bookreview.model.UserBookIdentity;
import com.bookworm.bookreview.model.UserReview;

@Repository
public interface UserReviewRepository extends JpaRepository<UserReview,UserBookIdentity>{
	
	@Query(value = "select * from user_review ur where ur.book_id =:bookId",nativeQuery = true)
	Optional<List<UserReview>> getUserReviewByBookId(@Param("bookId") String bookId);
	
	
	@Query(value = "select * from user_review ur where ur.user_id =:userId",nativeQuery = true)
	Optional<List<UserReview>> getUserReviewByUserId(@Param("userId") String userId);

}
