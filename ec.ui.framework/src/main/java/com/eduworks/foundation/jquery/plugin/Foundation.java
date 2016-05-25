package com.eduworks.foundation.jquery.plugin;

import org.stjs.javascript.annotation.SyntheticType;
import org.stjs.javascript.jquery.JQueryCore;

@SyntheticType
public interface Foundation<FullJQuery extends JQueryCore<?>> {
	
	public FullJQuery foundation();
	
	public FullJQuery foundation(String methodName);
	
	public FullJQuery foundation(String type, String methodName);
}
