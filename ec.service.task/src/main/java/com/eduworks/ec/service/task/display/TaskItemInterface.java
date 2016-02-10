package com.eduworks.ec.service.task.display;

import com.eduworks.ec.service.task.model.TaskItem;

public interface TaskItemInterface {

	void setCompleteSuccess(TaskItem task);
	void setCompleteFailure(String err);

	void setIncompleteSuccess(TaskItem task);
	void setIncompleteFailure(String err);
	
	void createSuccess(TaskItem task);
	void createFailure(String p1);

}
