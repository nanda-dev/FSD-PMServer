package com.fsd.service;

import java.util.List;

import com.fsd.dto.ProjectDTO;

public interface ProjectService {

	List<ProjectDTO> getAllProjects();
	
	ProjectDTO addProject(ProjectDTO project);
	
	ProjectDTO updateProject(ProjectDTO project);
	
	ProjectDTO suspendProject(Long id);
	
	boolean deleteProject(Long id);

}