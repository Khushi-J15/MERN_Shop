package com.ecom.first.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.first.entity.User;

public interface UserRepo extends JpaRepository<User, Long>{
	
	Optional<User> findByEmail(String email);
}
