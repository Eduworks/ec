package com.eduworks.ec.task;

import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSGlobal;
import org.stjs.javascript.TimeoutHandler;
import org.stjs.javascript.functions.Callback0;

public class EcAsyncTaskWorker{
	
	EcAsyncTask currentTask;
	Array<EcAsyncTask> assignedList;
	
	public int checkWorkInterval = 100;
	
	public TimeoutHandler intervalHandler;
	public TimeoutHandler taskHandler;
	
	public EcAsyncTaskWorker(){
		assignedList = JSCollections.$array();
		final EcAsyncTaskWorker that = this;
		intervalHandler = Global.setInterval(new Callback0() {
			@Override
			public void $invoke() {
				that.run();
			}
		}, checkWorkInterval);
	}

	public int getAssignedCount(){
		return assignedList.$length();
	}
	
	public void assign(EcAsyncTask task){
		if(currentTask == null || currentTask == JSGlobal.undefined || currentTask.getIsComplete()){
			currentTask = task;
		}else{
			assignedList.push(task);
		}
	}
	
	private void invoke(){
		if(!currentTask.getIsComplete()){
			Array<Object> args = currentTask.getArguments();
	 	
			if(args == null || args == JSGlobal.undefined || args.$length() == 0){
				currentTask.doTask();
			}else if(args.$length() == 1){
				currentTask.doTask(args.$get(0));
			}else if(args.$length() == 2){
				currentTask.doTask(args.$get(0), args.$get(1));
			}else if(args.$length() == 3){
				currentTask.doTask(args.$get(0), args.$get(1), args.$get(2));
			}else if(args.$length() == 4){
				currentTask.doTask(args.$get(0), args.$get(1), args.$get(2), args.$get(3));
			}
		}
	}
	
	protected void run() {
		final EcAsyncTaskWorker that = this;
		taskHandler = Task.immediate(new Callback0(){

			@Override
			public void $invoke() {			 
				if(that.currentTask != JSGlobal.undefined && that.currentTask != null && !that.currentTask.getIsStarted()){
					that.invoke();
				}
				
				if(that.currentTask != JSGlobal.undefined && that.currentTask != null && that.currentTask.getIsComplete()){
					that.currentTask = that.assignedList.shift();
				}
				
			}
		});
		
	}

}
