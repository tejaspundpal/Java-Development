package com.springboot.projects.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.projects.entities.User;

public interface UserRepository extends CrudRepository<User,Integer> {

}
