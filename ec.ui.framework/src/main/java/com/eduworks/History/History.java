package com.eduworks.History;

import org.stjs.javascript.annotation.SyntheticType;

@SyntheticType
public interface History<H extends org.stjs.javascript.History> {
	
	public H pushState(Object obj, String title, String url);
	
	public H replaceState(Object obj, String title, String url);
	
	public H go(String pos);
	
	public int length();
}
