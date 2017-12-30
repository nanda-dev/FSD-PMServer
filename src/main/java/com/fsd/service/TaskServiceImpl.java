package com.fsd.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.dao.PMQDslDAO;
import com.fsd.dao.TaskDAO;
import com.fsd.dto.TaskDTO;
import com.fsd.model.Task;
import com.fsd.util.TaskStatus;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskDAO taskDao;
	
	@Autowired
	PMQDslDAO pmDao;
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	/* (non-Javadoc)
	 * @see com.fsd.service.TaskService#getAllTasks()
	 */
	@Override
	public List<TaskDTO> getAllTasks() {
		List<Task> taskObjs = taskDao.findAll();
		
		List<TaskDTO> tasks = transformTasks(taskObjs);		
		
		return tasks;
	}	
	
	@Override
	public List<TaskDTO> getAllTasksByProject(Long projectId) {
		List<Task> taskObjs = pmDao.getAllTasksByProject(projectId);
		
		List<TaskDTO> tasks = transformTasks(taskObjs);
		return tasks;
	}
	
	@Override
	public TaskDTO getTaskById(Long taskId) {
		Task taskObj = taskDao.findOne(taskId);
		TaskDTO task = transformTask(taskObj);
		return task;
	}

	@Override
	public TaskDTO addTask(TaskDTO task) {
		Task taskObj = transformTask(task);
		task.setId(null);//AutoGenerated in DB
		task.setStatus(TaskStatus.INPROGRESS.val());
		taskDao.saveAndFlush(taskObj);
		return task;
	}

	
	@Override
	public TaskDTO updateTask(TaskDTO task) {
		LOGGER.debug("Save Task Object:" + task.toString());
		Task taskObj = taskDao.findOne(task.getId());
		if(taskObj != null) {
			taskObj = transformTask(task);
			
			taskDao.saveAndFlush(taskObj);
		}
		return task;
	}

	@Override
	public TaskDTO endTask(Long id) {
		Task taskObj = taskDao.findOne(id);
		if(taskObj != null) {
			taskObj.setStatus(TaskStatus.COMPLETED.val());
			taskDao.saveAndFlush(taskObj);
		}
		return null;
	}
	
	@Override
	public boolean deleteTask(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private Task transformTask(TaskDTO task) {
		Task taskObj = new Task();
		taskObj.setId(task.getId());
		taskObj.setTaskName(task.getName());
		taskObj.setProjectId(task.getProjectId());
		taskObj.setParentTaskId(task.getParentTaskId());
		taskObj.setUserId(task.getUserId());
		taskObj.setPriority(task.getPriority());
		taskObj.setStartDate(task.getStartDate());
		taskObj.setEndDate(task.getEndDate());
		//taskObj.setStatus(task.getStatus());
		return taskObj;
	}
	private TaskDTO transformTask(Task taskObj) {
		TaskDTO task = new TaskDTO();
		task.setId(taskObj.getId());
		task.setName(taskObj.getTaskName());
		task.setProjectId(taskObj.getProjectId());
		task.setParentTaskId(taskObj.getParentTaskId());
		task.setUserId(taskObj.getUserId());
		task.setPriority(taskObj.getPriority());
		task.setStartDate(taskObj.getStartDate());
		task.setEndDate(taskObj.getEndDate());
		task.setStatus(taskObj.getStatus());
		return task;
	}

	
	private List<TaskDTO> transformTasks(List<Task> taskObjs) {
		List<TaskDTO> tasks = new ArrayList<>();
		
		for(Task t : taskObjs) {
			TaskDTO task = new TaskDTO();
			task.setId(t.getId());
			task.setName(t.getTaskName());
			task.setProjectId(t.getProjectId());
			task.setParentTaskId(t.getParentTaskId());
			task.setUserId(t.getUserId());
			task.setPriority(t.getPriority());
			task.setStartDate(t.getStartDate());
			task.setEndDate(t.getEndDate());
			task.setStatus(t.getStatus());
			
			tasks.add(task);
			
		}
		return tasks;
	}
	
	public List<TaskDTO> getAllTasksMock() {
		List<TaskDTO> tasks = new ArrayList<TaskDTO>();
		
		TaskDTO task1 = new TaskDTO();
		task1.setId(1L);
		task1.setName("Task1");
		task1.setProjectId(1L);
		task1.setPriority(10);
		task1.setParentTaskId(1L);
		task1.setStartDate(new Date());
		task1.setEndDate(new Date());
		
		TaskDTO task2 = new TaskDTO();
		task2.setId(2L);
		task2.setName("Task2");
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
