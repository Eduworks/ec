package com.eduworks.ec.service.task.model;

import com.eduworks.ec.service.task.TaskListManager;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;

/**
 * Example of a Model, maintains state information about itself and provides methods for
 * CRUD on the server model. This could also contain a static cache that could be used to
 * minimize impact on the server for computationally heavy tasks
 *
 * @author djunker
 */
public class TaskList {
	public String name;
	public Array<TaskItem> tasks;

	public TaskList(String name, Array<TaskItem> tasks) {
		this.name = name;

		if (tasks == null) {
			this.tasks = new Array<TaskItem>();
		} else {
			this.tasks = tasks;
		}
	}

	public static TaskList parse(Object obj) {
		String name;
		Array<TaskItem> tasks = new Array<TaskItem>();

		name = (String) JSObjectAdapter.$get(obj, "name");

		Array<Object> taskArray = (Array<Object>) JSObjectAdapter.$get(obj, "tasks");

		for (int i = 0; i < taskArray.$length(); i++) {
			TaskItem task = TaskItem.parse(taskArray.$get(i));
			if (task != null)
				tasks.push(task);
		}


		return new TaskList(name, tasks);
	}

	public static void getList(final Callback1<TaskList> success, final Callback1<String> failure) {
		TaskListManager.readTaskList(new Callback1<Object>() {
			@Override
			public void $invoke(Object object) {
				TaskList list = parse(object);

				if (success != null)
					success.$invoke(list);
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				if (failure != null)
					failure.$invoke(p1);
			}
		});
	}
}
