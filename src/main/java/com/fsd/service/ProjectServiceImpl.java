package com.fsd.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.dao.ProjectDAO;
import com.fsd.dto.ProjectDTO;
import com.fsd.model.Project;
import com.fsd.util.ProjectStatus;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	ProjectDAO projDao;
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	/* (non-Javadoc)
	 * @see com.fsd.service.ProjectService#getAllProjects()
	 */
	@Override
	public List<ProjectDTO> getAllProjects() {
		List<Project> projectObjs = projDao.findAll();
		
		List<ProjectDTO> projects = transformProjects(projectObjs);
		
		return projects;
	}	

	@Override
	public ProjectDTO addProject(ProjectDTO project) {
		Project projObj = transformProject(project);
		projObj.setId(null);//AutoGenerated in DB
		projDao.saveAndFlush(projObj);
		return project;
	}	

	@Override
	public ProjectDTO updateProject(ProjectDTO project) {
		Project projObj = projDao.findOne(project.getId());
		if(projObj != null) {
			projObj = transformProject(project);
			projDao.saveAndFlush(projObj);
		}		
		return project;
	}
	
	@Override
	public ProjectDTO suspendProject(Long id) {
		ProjectDTO project = new ProjectDTO();
		Project projObj = projDao.findOne(id);
		if(projObj != null) {
			projObj.setStatus(ProjectStatus.SUSPENDED.val());
			projDao.saveAndFlush(projObj);
		}		
		return project;
	}

	@Override
	public boolean deleteProject(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private List<ProjectDTO> transformProjects(List<Project> projectObjs) {
		
		List<ProjectDTO> projs = new ArrayList<>();
		
		for(Project projObj : projectObjs) {
			ProjectDTO proj = new ProjectDTO();
			proj.setId(projObj.getId());
			proj.setName(projObj.getName());
			proj.setManagerId(projObj.getManagerId());
			proj.setPriority(projObj.getPriority());
			proj.setStartDate(projObj.getStartDate());
			proj.setEndDate(projObj.getEndDate());
			proj.setStatus(projObj.getStatus());
			
			projs.add(proj);
		}
		
		return projs;
	}

	public List<ProjectDTO> getProjectsMock() {
		List<ProjectDTO> projects = new ArrayList<ProjectDTO>();
		ProjectDTO project1 = new ProjectDTO();
		project1.setId(1L);
		project1.setName("Project1");
		project1.setManagerId(10001L);
		project1.setPriority(10);
		project1.setStatus("P");
		project1.setStartDate(new Date());
		project1.setStartDate(new Date());
		
		ProjectDTO project2 = new ProjectDTO();
		project2.setId(1L);
		project2.setName("Project2");
		project2.setManagerId(10002L);
		project2.setPriority(20);
		project2.setStatus("P");
		project2.setStartDate(new Date());
		project2.setStartDate(new Date());
		
		projects.add(project1);
		projects.add(project2);
		
		return projects;
	}
	
	private Project transformProject(ProjectDTO project) {
		Project projObj = new Project();
		
		projObj.setId(project.getId());
		projObj.setName(project.getName());
		projObj.setManagerId(project.getManagerId());
		projObj.setPriority(project.getPriority());
		projObj.setStartDate(project.getStartDate());
		projObj.setEndDate(project.getEndDate());
		projObj.setStatus(project.getStatus());
		
		return projObj;
	}

	

}
