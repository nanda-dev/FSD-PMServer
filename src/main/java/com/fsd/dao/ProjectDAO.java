package com.fsd.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsd.model.Project;

@Repository
public interface ProjectDAO extends JpaRepository<Project, Long>{

}
