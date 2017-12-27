package com.fsd.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.fsd.model.User;

/*
 * Sample Repo to showcase the use of Spring's CrudRepository.
 */
@Repository
public interface UserXDAO extends CrudRepository<User, Long> {
	
	//findBy<EntityPropertyName>
	List<User> findByStatus(String isActive);
	
}
