package com.eduworks.ec.service.task;

import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.remote.EcRemote;
import com.eduworks.ec.service.task.model.TaskList;
import com.eduworks.ec.service.task.view.TaskListInterface;


public class TaskListManager {
	
	private static String selectedServer = "http://localhost:9722/api/custom/taskList";
	
	private static final String READ = "read";
	
	public static void readTaskList(final TaskListInterface view)
	{
		EcRemote.postExpectingObject(selectedServer,READ, null, new Callback1<Object>()
		{
			@Override
			public void $invoke(Object object)
			{
				TaskList list = TaskList.parse(object);
				
				view.readTaskListSuccess(list);
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				view.readTaskListFailure(p1);				
			}
		});
	}
	
}
