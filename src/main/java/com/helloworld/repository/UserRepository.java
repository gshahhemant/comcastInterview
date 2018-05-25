package com.helloworld.repository;

import org.springframework.data.repository.CrudRepository;

import com.helloworld.jpa.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
		
	public User findByUsername(String username);
}
