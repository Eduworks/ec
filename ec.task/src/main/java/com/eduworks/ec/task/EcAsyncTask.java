package com.eduworks.ec.task;

import org.stjs.javascript.*;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.CallbackOrFunction;

public class EcAsyncTask {

	CallbackOrFunction job;
	Array<Object> args;
	private int timeoutSec;

	private Date creationTime;

	private boolean isComplete;
	private boolean isStarted;


	private Date start;
	private Date stop;

	private String error;

	public EcAsyncTask(CallbackOrFunction job, Object param1, Object param2, Object param3, Object param4) {
		creationTime = new Date();
		this.job = job;
		this.args = JSCollections.$array();
		timeoutSec = 20;

		if (param1 != null && param1 != JSGlobal.undefined)
			this.args.push(param1);
		if (param2 != null && param2 != JSGlobal.undefined)
			this.args.push(param2);
		if (param3 != null && param2 != JSGlobal.undefined)
			this.args.push(param3);
		if (param4 != null && param4 != JSGlobal.undefined)
			this.args.push(param4);
	}

	public void setJob(CallbackOrFunction job) {
		this.job = job;
	}


	public Array<Object> getArguments() {
		return args;
	}

	public void setArguments(Object... arguments) {
		this.args = JSCollections.$array();

		for (int i = 0; i < arguments.length; i++) {
			args.$set(i, arguments[i]);
		}
	}

	public int getTimeout() {
		return timeoutSec;
	}

	public void setTimeout(int timeout) {
		timeoutSec = timeout;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public boolean getIsComplete() {
		return isComplete;
	}

	public void setComplete() {
		stop = new Date();
		isComplete = true;
	}


	public boolean getIsStarted() {
		return isStarted;
	}

	public Date getStart() {
		return start;
	}


	public Object doTask(Object... arguments) {
		Object ret = JSGlobal.undefined;

		if (!isStarted) {
			start = new Date();
			isStarted = true;
			try {
				if (arguments.length == 0) {
					ret = invoke0();
				} else if (arguments.length == 1) {
					ret = invoke1(arguments[0]);
				} else if (arguments.length == 2) {
					ret = invoke2(arguments[0], arguments[1]);
				} else if (arguments.length == 3) {
					ret = invoke3(arguments[0], arguments[1], arguments[2]);
				} else if (arguments.length == 4) {
					ret = invoke4(arguments[0], arguments[1], arguments[2], arguments[3]);
				} else {
					ret = JSGlobal.undefined;
				}
			} catch (Exception e) {
				stop = new Date();

				isComplete = true;
				error = e.getMessage();
				throw e;
			}
		}

		return ret;
	}


	public Object invoke0() {
		final EcAsyncTask that = this;
		Object ret = JSFunctionAdapter.call(job, this, new Callback0() {
			@Override
			public void $invoke() {
				that.setComplete();
			}
		});

		return ret;
	}

	public Object invoke1(Object arg1) {
		final EcAsyncTask that = this;
		Object ret = JSFunctionAdapter.call(job, this, arg1, new Callback0() {
			@Override
			public void $invoke() {
				that.setComplete();
			}
		});

		return ret;
	}

	public Object invoke2(Object arg1, Object arg2) {
		final EcAsyncTask that = this;
		Object ret = JSFunctionAdapter.call(job, this, arg1, arg2, new Callback0() {
			@Override
			public void $invoke() {
				that.setComplete();
			}
		});

		return ret;
	}

	public Object invoke3(Object arg1, Object arg2, Object arg3) {
		final EcAsyncTask that = this;
		Object ret = JSFunctionAdapter.call(job, this, arg1, arg2, arg3, new Callback0() {
			@Override
			public void $invoke() {
				that.setComplete();
			}
		});

		return ret;
	}

	public Object invoke4(Object arg1, Object arg2, Object arg3, Object arg4) {
		final EcAsyncTask that = this;
		Object ret = JSFunctionAdapter.call(job, this, arg1, arg2, arg3, arg4, new Callback0() {
			@Override
			public void $invoke() {
				that.setComplete();
			}
		});

		return ret;
	}
}
