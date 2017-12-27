package com.fsd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.dto.ProjectDTO;
import com.fsd.service.ProjectService;

@RestController
@CrossOrigin
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value = "/api/project", method = RequestMethod.GET)
	public List<ProjectDTO> getAllProjects() {		
		return projectService.getAllProjects();
	}
	
	@RequestMapping(value = "/api/project", method = RequestMethod.POST)
	public ProjectDTO addProject(@RequestBody ProjectDTO project) {		
		return projectService.addProject(project);
	}
	
	@RequestMapping(value = "/api/project", method = RequestMethod.PUT)
	public ProjectDTO editProject(@RequestBody ProjectDTO project) {
		return projectService.updateProject(project);
	}
	
	@RequestMapping(value = "/api/project/{id}", method = RequestMethod.PUT)
	public ProjectDTO suspendProject(@PathVariable Long id) {
		return projectService.suspendProject(id);
	}
}
