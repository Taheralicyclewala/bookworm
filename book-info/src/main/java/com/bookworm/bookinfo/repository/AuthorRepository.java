package com.bookworm.bookinfo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookworm.bookinfo.model.Author;

@Repository 
public interface AuthorRepository extends JpaRepository<Author,Integer>{
	
	public Optional<Author> findAuthorByName(String name);
}
