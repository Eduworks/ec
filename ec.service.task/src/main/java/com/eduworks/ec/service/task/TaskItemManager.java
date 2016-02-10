package com.eduworks.ec.service.task;

import org.stjs.javascript.Date;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSGlobal;
import org.stjs.javascript.Map;
import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.remote.EcRemote;
import com.eduworks.ec.remote.FormData;
import com.eduworks.ec.service.task.display.TaskItemInterface;
import com.eduworks.ec.service.task.model.TaskItem;

public class TaskItemManager {

	private static String selectedServer = "http://localhost:9722/api/custom/task";
	
	private static final String CREATE = "create";
	
	private static final String SET_COMPLETE = "complete";
	private static final String SET_INCOMPLETE = "incomplete";
	
	public static void create(String taskName, Date dueDate, final TaskItemInterface view){
		Map<String, String> data = JSCollections.$map(
				"taskName", taskName,
				"taskDueDate", dueDate.toDateString()
			);
				
			FormData fd = new FormData();
			fd.append("task", JSGlobal.JSON.stringify(data));
			
			EcRemote.postExpectingObject(selectedServer, CREATE, fd, new Callback1<Object>()
			{
				@Override
				public void $invoke(Object object)
				{
					TaskItem task = TaskItem.parse(object);
					
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
	
	public static void setComplete(final String taskId, final TaskItemInterface view) {
		Map<String, String> data = JSCollections.$map(
			"taskId", taskId 
		);
			
		FormData fd = new FormData();
		fd.append("task", JSGlobal.JSON.stringify(data));
		
		EcRemote.postExpectingObject(selectedServer, SET_COMPLETE, fd, new Callback1<Object>()
		{
			@Override
			public void $invoke(Object object)
			{
				TaskItem task = TaskItem.parse(object);
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

	public static void setIncomplete(final String taskId, final TaskItemInterface view) {
		Map<String, String> data = JSCollections.$map(
			"taskId", taskId 
		);
			
		FormData fd = new FormData();
		fd.append("task", JSGlobal.JSON.stringify(data));
		
		EcRemote.postExpectingObject(selectedServer, SET_INCOMPLETE, fd, new Callback1<Object>()
		{
			@Override
			public void $invoke(Object object)
			{
				TaskItem task = TaskItem.parse(object);
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

}
