package com.eduworks.ec.task;

import com.eduworks.ec.random.EcRandom;
import org.stjs.javascript.*;
import org.stjs.javascript.functions.Callback0;

public class EcAsyncTaskManager {

	Map<String, EcAsyncTask> taskMap;

	Array<EcAsyncTaskWorker> workerList;

	int taskCleanupInterval = 2500;

	public EcAsyncTaskManager(int workerCount) {
		workerList = JSCollections.$array();
		for (int i = 0; i < workerCount; i++) {
			workerList.push(new EcAsyncTaskWorker());
		}

		final EcAsyncTaskManager that = this;
		Global.setInterval(new Callback0() {
			@Override
			public void $invoke() {
				that.cleanupTasks();
			}
		}, taskCleanupInterval);
	}

	public Map<String, EcAsyncTask> addTasks(Array<EcAsyncTask> tasks) {
		Map<String, EcAsyncTask> retMap = JSCollections.$map();

		if (tasks != JSGlobal.undefined) {
			for (int i = 0; i < tasks.$length(); i++) {
				EcAsyncTask task = tasks.$get(i);

				String key = addTask(task);

				retMap.$put(key, task);

			}
		}

		return retMap;
	}

	public String addTask(EcAsyncTask task) {
		if (taskMap == JSGlobal.undefined || taskMap == null) {
			taskMap = JSCollections.$map();
		}
		String key = "";
		while (key == "" || (taskMap.$get(key) != JSGlobal.undefined && taskMap.$get(key) != null)) {
			key = EcRandom.generateUUID();
		}

		taskMap.$put(key, task);

		assignNewTask(task);

		cleanupTasks();

		return key;
	}

	private void cleanupTasks() {
		for (String key : taskMap) {
			EcAsyncTask task = taskMap.$get(key);
			if (task.getIsStarted()) {
				int timeoutSec = task.getTimeout();
				if (task.getStart().getTime() < new Date().getTime() - (timeoutSec * 1000)) {
					task.setComplete();
				}
			}

			if (task.getIsComplete()) {
				taskMap.$delete(key);
			}
		}
	}


	private void assignNewTask(EcAsyncTask task) {

		int min = 10000;
		EcAsyncTaskWorker theGuy = null;
		for (int i = 0; i < workerList.$length(); i++) {
			if (workerList.$get(i).getAssignedCount() < min) {
				theGuy = workerList.$get(i);
				min = theGuy.getAssignedCount();
			}
		}
		if (theGuy != null)
			theGuy.assign(task);
	}


}
