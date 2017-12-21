package com.fsd.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fsd.dto.ProjectDTO;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	/* (non-Javadoc)
	 * @see com.fsd.service.ProjectService#getAllProjects()
	 */
	@Override
	public List<ProjectDTO> getAllProjects() {
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

}
