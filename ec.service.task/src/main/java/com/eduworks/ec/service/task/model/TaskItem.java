package com.eduworks.ec.service.task.model;

import com.eduworks.ec.service.task.TaskItemManager;
import org.stjs.javascript.Date;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;

public class TaskItem {

	public String taskId;
	public String taskName;
	public boolean completed;
	public Date dueDate;

	private TaskItem(String taskId, String name, boolean completed, Date dueDate) {
		this.taskId = taskId;
		this.taskName = name;
		this.completed = completed;
		this.dueDate = dueDate;
	}

	public static TaskItem parse(Object obj) {
		String taskId, name;
		Boolean completed = false;
		Date due = null;

		taskId = (String) JSObjectAdapter.$get(obj, "taskId");
		name = (String) JSObjectAdapter.$get(obj, "taskName");

		completed = (Boolean) JSObjectAdapter.$get(obj, "completed");
		if (completed == null)
			completed = false;

		String date = (String) JSObjectAdapter.$get(obj, "dueDate");
		if (date != null)
			due = new Date();

		return new TaskItem(taskId, name, completed, due);
	}

	public static void create(String taskName, String dueDate, final Callback1<TaskItem> success, Callback1<String> failure) {
		TaskItemManager.create(taskName, dueDate, new Callback1<Object>() {
			@Override
			public void $invoke(Object object) {
				TaskItem task = parse(object);

				if (success != null)
					success.$invoke(task);
			}
		}, failure);
	}

	public void setComplete(final Callback1<TaskItem> success, Callback1<String> failure) {
		completed = true;

		TaskItemManager.setComplete(taskId, new Callback1<Object>() {
			@Override
			public void $invoke(Object object) {
				TaskItem task = parse(object);
				if (success != null)
					success.$invoke(task);
			}
		}, failure);

	}

	public void setIncomplete(final Callback1<TaskItem> success, Callback1<String> failure) {
		completed = false;

		TaskItemManager.setIncomplete(taskId, new Callback1<Object>() {
			@Override
			public void $invoke(Object object) {
				TaskItem task = parse(object);
				if (success != null)
					success.$invoke(task);
			}
		}, failure);
	}

}
