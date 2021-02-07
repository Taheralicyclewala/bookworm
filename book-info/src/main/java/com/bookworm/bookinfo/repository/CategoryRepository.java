package com.bookworm.bookinfo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookworm.bookinfo.model.Category;

@Repository 
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	Optional<Category> findCategoryByType(String type);

}
