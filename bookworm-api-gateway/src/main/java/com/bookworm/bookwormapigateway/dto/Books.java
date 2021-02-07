package com.bookworm.bookwormapigateway.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.bookworm.bookwormapigateway.dto.Book;

public class Books implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Books(List<Book> booksList) {
		this.booksList = booksList;
	}
	
	public Books() {
		this.booksList = new ArrayList<Book>();
	}

	private List<Book> booksList;

	public List<Book> getBooksList() {
		return booksList;
	}

	public void setBooksList(List<Book> booksList) {
		this.booksList = booksList;
	}
}