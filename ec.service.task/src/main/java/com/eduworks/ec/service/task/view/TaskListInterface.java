package com.eduworks.ec.service.task.view;

import com.eduworks.ec.service.task.model.TaskList;

public interface TaskListInterface {

	void readTaskListSuccess(TaskList list);

	void readTaskListFailure(String err);

}
