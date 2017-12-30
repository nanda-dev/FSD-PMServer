package com.fsd.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value = "/api/task", method = RequestMethod.GET)
	public List<TaskDTO> getAllTasks() {
		LOGGER.debug("API Invoked: getAllTasks()");
		return taskService.getAllTasks();
	}
	
	@RequestMapping(value = "/api/task/project/{id}", method = RequestMethod.GET)
	public List<TaskDTO> getAllTasksByProject(@PathVariable Long id) {
		LOGGER.debug("API Invoked: getAllTasksByProject(): " + id);
		return taskService.getAllTasksByProject(id);
	}
	
	@RequestMapping(value = "/api/task/{id}", method = RequestMethod.GET)
	public TaskDTO getTaskById(@PathVariable Long id) {
		LOGGER.debug("API Invoked: getTaskById(): " + id);
		return taskService.getTaskById(id);
	}
	
	@RequestMapping(value = "/api/task", method = RequestMethod.POST)
	public TaskDTO addTask(@RequestBody TaskDTO task) {
		LOGGER.debug("API Invoked: addTask(): " + task.toString());
		return taskService.addTask(task);
	}
	
	@RequestMapping(value = "/api/task", method = RequestMethod.PUT)
	public TaskDTO editTask(@RequestBody TaskDTO task) {
		LOGGER.debug("API Invoked: editTask(): " + task.toString());
		return taskService.updateTask(task);
	}
	
	@RequestMapping(value = "/api/task/{id}", method = RequestMethod.PUT)
	public TaskDTO endTask(@PathVariable Long id) {
		LOGGER.debug("API Invoked: endTask(): " + id);
		return taskService.endTask(id);
	}

}
