package com.bookworm.bookinfo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
