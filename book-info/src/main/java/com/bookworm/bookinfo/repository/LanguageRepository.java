package com.bookworm.bookinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bookworm.bookinfo.model.Language;


@Repository
public interface LanguageRepository extends JpaRepository<Language,Integer>{
	
}