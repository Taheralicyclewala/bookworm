package com.bookworm.bookinfo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookworm.bookinfo.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
 
	@Query(value = "Select * from book where book.author_id =:authorId",nativeQuery = true)
	public Optional<List<Book>> findBookByAuthor(@Param("authorId") int authorId);

	@Query(value = "Select * from book where book.language_id =:languageId",nativeQuery = true)
	public Optional<List<Book>> findBookByLanguage(@Param("languageId") int languageId);
	
	@Query(value = "Select * from book where book.country_id =:countryId",nativeQuery = true)
	public Optional<List<Book>> findBookByCountry(@Param("countryId") int countryId);
	
	@Query(value = "select * from book b where b.title =:title",nativeQuery = true)
	public Optional<Book> findBookByTitle(String title);
}