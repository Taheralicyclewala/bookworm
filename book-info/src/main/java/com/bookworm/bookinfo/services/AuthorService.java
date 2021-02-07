package com.bookworm.bookinfo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.bookinfo.exception.EntityNotFoundException;
import com.bookworm.bookinfo.model.Author;
import com.bookworm.bookinfo.repository.AuthorRepository;

@Service
public class AuthorService {
	
	
	@Autowired
	AuthorRepository authorRepository;
	
	public List<Author> getAuthors()
	{
		return authorRepository.findAll();
	}
	public void addAuthor(Author author)
	{
		authorRepository.save(author);
	}
	
	public Author getAuthor(String authorName) throws EntityNotFoundException
	{
		Optional<Author> author = authorRepository.findAuthorByName(authorName);
		if(author.isPresent())
			return  author.get();
		else
			throw new EntityNotFoundException(Author.class,"Name",authorName);
	}
	

}
