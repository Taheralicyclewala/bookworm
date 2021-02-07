package com.bookworm.bookinfo.model;


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "book_category_mapping")
@EntityListeners(AuditingEntityListener.class)
public class BookCategoryMapping{
	
	@Id
    @Embedded
    BookCategoryIdentity bookCategoryIdentity;

	public BookCategoryMapping() {
	}

	public BookCategoryMapping(BookCategoryIdentity bookCategoryIdentity) {
		this.bookCategoryIdentity = bookCategoryIdentity;
	}

	public BookCategoryIdentity getBookCategoryIdentity() {
		return bookCategoryIdentity;
	}

	public void setBookCategoryIdentity(BookCategoryIdentity bookCategoryIdentity) {
		this.bookCategoryIdentity = bookCategoryIdentity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookCategoryIdentity == null) ? 0 : bookCategoryIdentity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookCategoryMapping other = (BookCategoryMapping) obj;
		if (bookCategoryIdentity == null) {
			if (other.bookCategoryIdentity != null)
				return false;
		} else if (!bookCategoryIdentity.equals(other.bookCategoryIdentity))
			return false;
		return true;
	}
}
