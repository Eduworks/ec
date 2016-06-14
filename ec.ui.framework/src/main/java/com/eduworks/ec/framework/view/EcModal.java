package com.eduworks.ec.framework.view;

import org.stjs.javascript.functions.Callback0;

/**
 * View Subclass representing modal views that are displayed in the modal container
 * 
 * @author devlin.junker@eduworks.com
 *
 */
public abstract class EcModal extends EcView{
	/**
	 * To be overrided in subclasses, lets the developer define the size of the modal
	 */
	public String modalSize = "small";
	
	/**
	 * Function to be invoked when the modal is closed, can be overriden or left blank if nothing
	 * needs to happen on the modal close 
	 */
	public Callback0 onClose;
}
