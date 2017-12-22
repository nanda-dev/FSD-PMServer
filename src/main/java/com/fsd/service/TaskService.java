package com.fsd.service;

import java.util.List;

import com.fsd.dto.TaskDTO;

public interface TaskService {

	List<TaskDTO> getAllTasks();
	
	TaskDTO addTask(TaskDTO task);
	
	TaskDTO updateTask(TaskDTO task);
	
	TaskDTO endTask(Long id);
	
	boolean deleteTask(Long id);

}