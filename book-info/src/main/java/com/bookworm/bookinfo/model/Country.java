package com.bookworm.bookinfo.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Table(name = "country")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name", nullable = false, unique = true)
	private String name;
	
	public Country() {
	}

	public Country(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Country other = (Country) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
