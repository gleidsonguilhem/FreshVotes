package com.toastack.solution.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toastack.solution.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
	
}
