package com.fsd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.dto.TaskDTO;
import com.fsd.service.TaskService;

@RestController
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value = "/api/task", method = RequestMethod.GET)
	public List<TaskDTO> getAllTasks() {
		return taskService.getAllTasks();
	}

}
