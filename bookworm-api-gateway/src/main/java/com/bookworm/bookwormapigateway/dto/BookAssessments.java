package com.bookworm.bookwormapigateway.dto;

import java.util.ArrayList;
import java.util.List;

public class BookAssessments {
	
	private String bookId;
	
	private List<BookAssessment> assessments;

	
	public BookAssessments() {
		this.assessments = new ArrayList<BookAssessment>();
	}

	public BookAssessments(String bookId, List<BookAssessment> assessments) {
		this.bookId = bookId;
		this.assessments = assessments;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public List<BookAssessment> getAssessments() {
		return assessments;
	}

	public void setAssessments(List<BookAssessment> assessments) {
		this.assessments = assessments;
	}
	
	public void addAssessment(BookAssessment bookAssessment)
	{
		this.assessments.add(bookAssessment);
	}
	
	@Override
	public String toString() {
		return "BookAssessments [bookId=" + bookId + ", assessments=" + assessments + "]";
	}
	
}
