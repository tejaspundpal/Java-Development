package com.springboot.jpa.test.dao;

import java.util.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springboot.jpa.test.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public List<User> findByName(String name);
	public List<User> findByNameAndCity(String name,String city);
	
	@Query("SELECT u FROM User u WHERE u.name=:n AND u.city=:c")
	public List<User> getUserByNameAndCity(@Param("n")String name,@Param("c")String city);
	
	@Query(value="SELECT * FROM User",nativeQuery = true)
	public List<User>getAllUsers();
}
