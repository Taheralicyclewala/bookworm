package com.bookworm.bookinfo.util;

import java.util.List;
import java.util.stream.Collectors;
import com.bookworm.bookinfo.dto.Book;
public class BooksUtility {
	
	
	public static List<Book> convertToDto(List<com.bookworm.bookinfo.model.Book> bookList)
	{
		return bookList.stream().map(book-> {
			return new  Book(book.getIsbn(),book.getAuthor().getName(),book.getTitle(),book.getLanguage().getName(),book.getSynopsis(),book.getPublisher(),book.getPublicationDate(),book.getPrintLength(),book.getCountryOfOrigin().getName());
		}).collect(Collectors.toList());
		
	}
}
