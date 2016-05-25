package com.eduworks.ec.framework.history;

import com.eduworks.ec.framework.view.EcScreen;


public class HistoryClosure {
	public String pageName;
	public EcScreen screen;
	public String containerId;
	public HistoryClosure(String name, EcScreen screen, String containerId){
		this.pageName = name;
		this.screen = screen;
		this.containerId = containerId;
	}
}
