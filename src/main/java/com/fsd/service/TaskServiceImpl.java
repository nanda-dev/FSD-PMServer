package com.fsd.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fsd.dto.TaskDTO;

@Service
public class TaskServiceImpl implements TaskService {

	/* (non-Javadoc)
	 * @see com.fsd.service.TaskService#getAllTasks()
	 */
	@Override
	public List<TaskDTO> getAllTasks() {
		List<TaskDTO> tasks = new ArrayList<TaskDTO>();
		
		TaskDTO task1 = new TaskDTO();
		task1.setTaskId(1L);
		task1.setTask("Task1");
		task1.setProjectId(1L);
		task1.setPriority(10);
		task1.setParentTaskId(1L);
		task1.setStartDate(new Date());
		task1.setEndDate(new Date());
		
		TaskDTO task2 = new TaskDTO();
		task2.setTaskId(2L);
		task2.setTask("Task2");
		task2.setProjectId(1L);
		task2.setPriority(20);
		task2.setParentTaskId(1L);
		task2.setStartDate(new Date());
		task2.setEndDate(new Date());
		
		tasks.add(task1);
		tasks.add(task2);
		
		return tasks;
	}
}
