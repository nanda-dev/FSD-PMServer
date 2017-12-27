package com.fsd.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fsd.model.QTask;
import com.fsd.model.QUser;
import com.fsd.model.Task;
import com.fsd.model.User;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class PMQDslDAOImpl implements PMQDslDAO {
	
	@Autowired
	EntityManager em;
	
	@Override
	public List<User> getAllUsersByStatus(String isActive) {
		JPAQueryFactory qf 	= new JPAQueryFactory(em);		
		QUser qUser 		= QUser.user;		
		ArrayList<User> activeUsers = (ArrayList<User>) qf.selectFrom(qUser)
															.where(qUser.status.eq(isActive))
															.fetch();		
		return activeUsers;
	}

	@Override
	public List<Task> getAllTasksByProject(Long projectId) {
		JPAQueryFactory qf 	= new JPAQueryFactory(em);
		QTask qTask 		= QTask.task;
		ArrayList<Task> tasksByProject = (ArrayList<Task>) qf.selectFrom(qTask)
											.where(qTask.projectId.eq(projectId))
											.fetch();
		return tasksByProject;
	}

	@Override
	public Long getTaskCountForProject(Long projectId) {
		JPAQueryFactory qf 	= new JPAQueryFactory(em);
		QTask qTask 		= QTask.task;
		Long taskCount 		= qf.selectFrom(qTask).where(qTask.projectId.eq(projectId)).fetchCount();
		return taskCount;
	}

}
