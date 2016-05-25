package com.eduworks.ec.framework.view;

import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback0;

public abstract class EcView {
	
	public abstract void display(String containerId, Callback0 callback);
	
	public <T> T as(Class<T> _interface){
		Object prototype = JSObjectAdapter.$get(this, "__proto__");
		Object constructor = JSObjectAdapter.$get(prototype, "constructor");
		Array inherits = (Array)JSObjectAdapter.$get(constructor, "$inherit");
		
		if(inherits != null)
			for(int i = 0; i < inherits.$length(); i++){
				if(inherits.$get(i) == _interface){
					return (T) this;
				}
			}
		
		return null;
	}
}
