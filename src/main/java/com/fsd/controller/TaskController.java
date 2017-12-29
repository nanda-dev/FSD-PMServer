package com.fsd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.dto.TaskDTO;
import com.fsd.service.TaskService;

@RestController
@CrossOrigin
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value = "/api/task", method = RequestMethod.GET)
	public List<TaskDTO> getAllTasks() {
		return taskService.getAllTasks();
	}
	
	@RequestMapping(value = "/api/task/project/{id}", method = RequestMethod.GET)
	public List<TaskDTO> getAllTasksByProject(@PathVariable Long id) {
		return taskService.getAllTasksByProject(id);
	}
	
	@RequestMapping(value = "/api/task/{id}", method = RequestMethod.GET)
	public TaskDTO getTaskById(@PathVariable Long id) {
		return taskService.getTaskById(id);
	}
	
	@RequestMapping(value = "/api/task", method = RequestMethod.POST)
	public TaskDTO addTask(@RequestBody TaskDTO task) {
		return taskService.addTask(task);
	}
	
	@RequestMapping(value = "/api/task", method = RequestMethod.PUT)
	public TaskDTO editTask(@RequestBody TaskDTO task) {
		return taskService.updateTask(task);
	}
	
	@RequestMapping(value = "/api/task/{id}", method = RequestMethod.PUT)
	public TaskDTO editTask(@PathVariable Long id) {
		return taskService.endTask(id);
	}

}
