package com.eduworks.ec.framework.view;

import org.stjs.javascript.functions.Callback0;

/**
 * View Subclass representing modal views that are displayed in the modal container
 * 
 * @module com.eduworks.ec.ui
 * @class EcModal
 * @extends EcView
 * 
 * @author devlin.junker@eduworks.com
 */
public abstract class EcModal extends EcView{
	/**
	 * To be overrided in subclasses, lets the developer define the size of the modal
	 * (Possible: tiny, small, medium, large, xlarge) 
	 * 
	 * @property modalSize
	 * @type String
	 */
	private String modalSize = "small";

	/**
	 * 
	 * @memberOf EcModal
	 * @method getModalSize
	 * @abstract
	 * @return tiny, small, medium, large, or full depending on how large the modal should be
	 */
	public abstract String getModalSize();
}
