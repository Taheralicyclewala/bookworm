package com.bookworm.bookwormapigateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookworm.bookwormapigateway.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
