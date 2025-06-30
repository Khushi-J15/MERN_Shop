package com.ecom.first.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.first.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Long>{
	
	
}
