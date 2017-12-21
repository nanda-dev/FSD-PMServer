package com.fsd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.dto.ProjectDTO;
import com.fsd.service.ProjectService;

@RestController
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value = "/api/project", method = RequestMethod.GET)
	public List<ProjectDTO> getAllProjects() {
		
		return projectService.getAllProjects();
	}
}
