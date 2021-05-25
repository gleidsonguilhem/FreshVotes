package com.toastack.solution.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toastack.solution.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
