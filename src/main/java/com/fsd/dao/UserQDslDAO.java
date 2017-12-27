package com.fsd.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fsd.model.User;


public interface UserQDslDAO {
	List<User> getAllUsersByStatus(String isActive);

}
