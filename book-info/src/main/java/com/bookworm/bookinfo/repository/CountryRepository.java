package com.bookworm.bookinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookworm.bookinfo.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country,Integer>{

}
