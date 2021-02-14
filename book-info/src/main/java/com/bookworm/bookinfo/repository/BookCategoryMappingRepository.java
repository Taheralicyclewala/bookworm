package com.bookworm.bookinfo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookworm.bookinfo.model.BookCategoryIdentity;
import com.bookworm.bookinfo.model.BookCategoryMapping;

@Repository
public interface BookCategoryMappingRepository extends JpaRepository<BookCategoryMapping, BookCategoryIdentity>{
	
	@Query(value ="select * from book_category_mapping bcm where bcm.category_id =:categoryId",nativeQuery = true)
	public Optional<List<BookCategoryMapping>> findBooksByCategory(@Param("categoryId") int categoryId);
	
	@Query(value ="select * from book_category_mapping bcm where bcm.book_id =:bookId",nativeQuery = true)
	public Optional<List<BookCategoryMapping>> findCategoriesByBook(@Param("bookId") int bookId);
}
