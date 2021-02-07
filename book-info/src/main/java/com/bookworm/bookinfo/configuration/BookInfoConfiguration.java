package com.bookworm.bookinfo.configuration;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bookworm.bookinfo.model.Author;
import com.bookworm.bookinfo.model.Category;
import com.bookworm.bookinfo.repository.AuthorRepository;
import com.bookworm.bookinfo.repository.CategoryRepository;

@Configuration
public class BookInfoConfiguration {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Bean(value = "categories")
	public HashMap<String,Category> getCategories()
	{
		HashMap<String,Category> categories = new HashMap<>();
		categoryRepository.findAll().stream().forEach(category -> categories.put(category.getType().toLowerCase(), category));
		return categories;		
	}
	
	@Bean(value = "authors")
	public HashMap<String,Author> getAuthors()
	{
		HashMap<String,Author> authors = new HashMap<>();
		authorRepository.findAll().stream().forEach(author -> authors.put(author.getName().toLowerCase(),author));
		return authors;
	}

}
