package com.fsd.dto;

import java.util.Date;

public class TaskDTO {
	
	private Long id;
	private String name;
	private Long projectId;
	private Integer priority;
	private Long parentTaskId;
	private Long userId;
	private Date startDate;
	private Date endDate;
	private String status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Long getParentTaskId() {
		return parentTaskId;
	}
	public void setParentTaskId(Long parentTaskId) {
		this.parentTaskId = parentTaskId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "TaskDTO [id=" + id + ", name=" + name + ", projectId=" + projectId + ", priority=" + priority
				+ ", parentTaskId=" + parentTaskId + ", userId=" + userId + ", startDate=" + startDate + ", endDate="
				+ endDate + ", status=" + status + "]";
	}	
	
}
