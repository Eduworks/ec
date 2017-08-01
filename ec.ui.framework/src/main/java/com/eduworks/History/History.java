package com.eduworks.History;

import org.stjs.javascript.annotation.SyntheticType;

/**
 * STJS Wrapper for the browser's history, adding methods that were missing from the STJS wrapper
 * 
 * @author devlin.junker@eduworks.com
 *
 * @param <H>
 */
@SyntheticType
public interface History<H extends org.stjs.javascript.History> {
	
	/**
	 * Pushes the object onto the browser history with a name and url hash to put in the URL bar
	 * 
	 * @param obj
	 * 			Any object that contains any state we want to remember for a history element (usually a history closure
	 * 			object with a view that can be displayed)
	 * @param title
	 * 			Title of the History Element to be saved (not used) 
	 * @param url
	 * 			URL hash to display in the URL bar indicating which history element is being displayed
	 * @return
	 * 			Returns the history object so additional methods could be called on it
	 */
	public H pushState(Object obj, String title, String url);
	
	/**
	 * Replaces the top most object in the browser history
	 * 
	 * @param obj
	 * 			Any object that contains any state we want to remember for a history element (usually a history closure
	 * 			object with a view that can be displayed) 
	 * @param title
	 * 			Title of the History Element to be saved (not used) 
	 * @param url
	 * 			URL hash to display in the URL bar indicating which history element is being displayed
	 * @return
	 * 			Returns the history object so additional methods could be called on it
	 */
	public H replaceState(Object obj, String title, String url);
	
	/**
	 * Goes to the history index passed in and calls the browser's popstate event with the object in that index
	 * @param pos
	 * 			index to go in the browser's history
	 * @return
	 * 			Returns the history object so additional methods could be called on it
	 */
	public H go(String pos);

	/**
	 * Function to determine the length of the browser's history
	 * @return
	 * 			Integer representing how many items are in the browser's history
	 */
	public int length();

}
