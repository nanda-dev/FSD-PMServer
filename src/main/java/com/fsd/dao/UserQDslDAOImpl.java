package com.fsd.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fsd.model.QUser;
import com.fsd.model.User;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class UserQDslDAOImpl implements UserQDslDAO {

	@Autowired
	EntityManager em;
	
	@Override
	public List<User> getAllUsersByStatus(String isActive) {
		JPAQueryFactory qf = new JPAQueryFactory(em);
		QUser qUser = QUser.user;
		ArrayList<User> activeUsers = (ArrayList<User>) qf.selectFrom(qUser).where(qUser.status.eq(isActive)).fetch();		
		return activeUsers;
	}

}
