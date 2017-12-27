package com.fsd.dao;

import java.util.List;

import com.fsd.model.Task;
import com.fsd.model.User;

/*
 * Sample Repo to showcase the use of QueryDSL for querying JPA.
 */
public interface PMQDslDAO {

	List<User> getAllUsersByStatus(String isActive);
	List<Task> getAllTasksByProject(Long projectId);
	Long getTaskCountForProject(Long projectId);
	
}
