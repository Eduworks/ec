package com.eduworks.ec.service.task.model;

import org.stjs.javascript.Date;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSGlobal;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;
import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.remote.EcRemote;
import com.eduworks.ec.remote.FormData;
import com.eduworks.ec.service.task.TaskItemManager;
import com.eduworks.ec.service.task.view.TaskItemInterface;

public class TaskItem {

	public String taskId;
	public String taskName;
	public boolean completed;
	public Date dueDate;
	
	private TaskItem(String taskId, String name, boolean completed, Date dueDate)
	{
		this.taskId = taskId;
		this.taskName = name;
		this.completed = completed;
		this.dueDate = dueDate;
	}
	
	public void setComplete(final TaskItemInterface view)
	{
		completed = true;
		
		TaskItemManager.setComplete(taskId, new Callback1<Object>()
		{
			@Override
			public void $invoke(Object object)
			{
				TaskItem task = parse(object);
				view.setCompleteSuccess(task);
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				view.setCompleteFailure(p1);				
			}
		});
		
	}
	
	public void setIncomplete(final TaskItemInterface view)
	{
		completed = false;
		
		TaskItemManager.setIncomplete(taskId, new Callback1<Object>()
		{
			@Override
			public void $invoke(Object object)
			{
				TaskItem task = parse(object);
				view.setIncompleteSuccess(task);
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				view.setIncompleteFailure(p1);				
			}
		});
	}
	
	public static TaskItem parse(Object obj) {
		String taskId, name;
		Boolean completed = false;
		Date due = null;
		
		taskId = (String) JSObjectAdapter.$get(obj, "taskId");
		name = (String) JSObjectAdapter.$get(obj, "taskName");
		
		completed = (Boolean) JSObjectAdapter.$get(obj, "completed");
		if(completed == null)
			completed = false;
		
		String date = (String)JSObjectAdapter.$get(obj, "dueDate");
		if(date != null)
			due = new Date();
		
		return new TaskItem(taskId, name, completed, due);
	}
	
	public static void create(String taskName, String dueDate, final TaskItemInterface view){
		TaskItemManager.create(taskName, dueDate, new Callback1<Object>()
		{
			@Override
			public void $invoke(Object object)
			{
				TaskItem task = parse(object);
				
				view.createSuccess(task);
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				view.createFailure(p1);				
			}
		});
	}

}
