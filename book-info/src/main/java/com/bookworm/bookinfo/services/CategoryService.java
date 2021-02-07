package com.bookworm.bookinfo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.bookinfo.exception.EntityNotFoundException;
import com.bookworm.bookinfo.model.Category;
import com.bookworm.bookinfo.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	public List<Category> getCategories()
	{
		return categoryRepository.findAll();
	}
	public void addCategory(Category category)
	{
		categoryRepository.save(category);
	}
	
	public Category getCategory(String categoryName) throws EntityNotFoundException
	{
		Optional<Category> category = categoryRepository.findCategoryByType(categoryName);
		if(category.isPresent())
			return category.get();
		else
			throw new EntityNotFoundException(Category.class,"Type",categoryName);
			
	}
}
