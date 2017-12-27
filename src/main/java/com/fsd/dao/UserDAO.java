package com.fsd.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fsd.model.User;

@Repository

public interface UserDAO extends JpaRepository<User, Long>{
	

}
