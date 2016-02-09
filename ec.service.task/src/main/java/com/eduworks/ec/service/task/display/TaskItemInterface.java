package com.eduworks.ec.service.task.display;

public interface TaskItemInterface {

	void setCompleteSuccess(String taskId);
	void setCompleteFailure(String err);

	void setIncompleteSuccess(String taskId);
	void setIncompleteFailure(String err);

}
