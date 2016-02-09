package com.eduworks.ec.service.task.model;

import org.stjs.javascript.Date;
import org.stjs.javascript.JSObjectAdapter;

import com.eduworks.ec.service.task.TaskItemManager;
import com.eduworks.ec.service.task.display.TaskItemInterface;

public class TaskItem {

	public String taskId;
	public String taskName;
	public boolean completed;
	public Date dueDate;
	
	public TaskItem(String taskId, String name, boolean completed, Date dueDate)
	{
		this.taskId = taskId;
		this.taskName = name;
		this.completed = completed;
		this.dueDate = dueDate;
	}
	
	public void setComplete(TaskItemInterface view)
	{
		completed = true;
		TaskItemManager.setComplete(this.taskId, view);
		
	}
	
	public void setIncomplete(TaskItemInterface view)
	{
		completed = false;
		TaskItemManager.setIncomplete(this.taskId, view);
	}
	
	public static TaskItem parse(Object obj) {
		String taskId, name;
		Boolean completed = false;
		Date due = null;
		
		taskId = (String) JSObjectAdapter.$get(obj, "taskId");
		name = (String) JSObjectAdapter.$get(obj, "taskName");
		
		completed = (Boolean) JSObjectAdapter.$get(obj, "taskName");
		if(completed == null)
			completed = false;
		
		due = (Date) JSObjectAdapter.$get(obj, "dueDate");
		
		return new TaskItem(taskId, name, completed, due);
	}

}
