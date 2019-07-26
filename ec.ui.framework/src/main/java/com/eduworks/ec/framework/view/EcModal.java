package com.eduworks.ec.framework.view;

/**
 * View Subclass representing modal views that are displayed in the modal container
 *
 * @author devlin.junker@eduworks.com
 * @module com.eduworks.ec.ui
 * @class EcModal
 * @extends EcView
 */
public abstract class EcModal extends EcView {
	/**
	 * To be overrided in subclasses, lets the developer define the size of the modal
	 * (Possible: tiny, small, medium, large, xlarge)
	 *
	 * @property modalSize
	 * @type String
	 */
	private String modalSize = "small";

	/**
	 * @return tiny, small, medium, large, or full depending on how large the modal should be
	 * @memberOf EcModal
	 * @method getModalSize
	 * @abstract
	 */
	public abstract String getModalSize();
}
