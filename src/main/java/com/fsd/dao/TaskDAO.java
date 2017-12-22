package com.fsd.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsd.model.Task;

@Repository
public interface TaskDAO extends JpaRepository<Task, Long>{

}
