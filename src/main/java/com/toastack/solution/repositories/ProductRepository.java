package com.toastack.solution.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toastack.solution.model.Product;
import com.toastack.solution.model.User;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	List<Product> findByUser(User user);
}
