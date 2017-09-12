package com.eduworks.foundation.jquery.plugin;

import org.stjs.javascript.annotation.SyntheticType;
import org.stjs.javascript.jquery.JQueryCore;

/**
 * STJS Wrapper for the foundation functions used in the EC Framework
 *
 * @param <FullJQuery> Meaning that the foundation functions can be called on any JQueryCore instances
 *                     (Including Jquery wrapped elements)
 * @author devlin.junker@eduworks.com
 */
@SyntheticType
public interface Foundation<FullJQuery extends JQueryCore<?>> {

	/**
	 * Invokes foundation without any parameters on the JqueryCore Instance
	 *
	 * @return Returns the JQueryCore Instance so other JQuery functions could be called on it
	 */
	public FullJQuery foundation();

	/**
	 * Invokes a specific foundation method on the JqueryCore Instance
	 *
	 * @param methodName Name of the foundation method to invoke
	 * @return Returns the JQueryCore Instance so other JQuery functions could be called on it
	 */
	public FullJQuery foundation(String methodName);

	/**
	 * Invokes a specific foundation method with a type on the JqueryCore Instance
	 *
	 * @param type
	 * @param methodName Name of the foundation method to invoke
	 * @return Returns the JQueryCore Instance so other JQuery functions could be called on it
	 */
	public FullJQuery foundation(String type, String methodName);
}
