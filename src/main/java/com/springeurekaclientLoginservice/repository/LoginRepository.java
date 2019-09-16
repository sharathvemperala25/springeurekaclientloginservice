package com.springeurekaclientLoginservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springeurekaclientLoginservice.entity.LoginDetails;

@Repository
public interface LoginRepository extends JpaRepository<LoginDetails, Long> {
	
	Optional<LoginDetails> findByEmail(String userEmail);

}
