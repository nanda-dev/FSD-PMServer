package com.fsd.dto;

import java.util.Date;

public class ProjectDTO {
	private Long id;
	private String name;
	private Long managerId;
	private Integer priority;
	private Date startDate;
	private Date endDate;
	private String status;
	private Long taskCount = 0L;
	
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
	public Long getManagerId() {
		return managerId;
	}
	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
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
	
	public Long getTaskCount() {
		return taskCount;
	}
	public void setTaskCount(Long taskCount) {
		this.taskCount = taskCount;
	}
	@Override
	public String toString() {
		return "ProjectDTO [id=" + id + ", name=" + name + ", managerId=" + managerId + ", priority=" + priority
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", status=" + status + ", taskCount="
				+ taskCount + "]";
	}
	

}
