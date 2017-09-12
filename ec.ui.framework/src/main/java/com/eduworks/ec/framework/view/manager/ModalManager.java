package com.eduworks.ec.framework.view.manager;

import com.eduworks.ec.framework.view.EcModal;
import com.eduworks.foundation.jquery.plugin.Foundation;
import org.stjs.javascript.JSGlobal;
import org.stjs.javascript.dom.Element;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.jquery.Event;
import org.stjs.javascript.jquery.EventHandler;
import org.stjs.javascript.jquery.GlobalJQuery;

/**
 * View Manager sub class that manages loading "modal"s and has a few helper functions to make sure that
 * they work properly
 *
 * @module com.eduworks.ec.ui
 * @class ModalManager
 * @extends ViewManager
 *
 * @author devlin.junker@eduworks.com
 */
public class ModalManager extends ViewManager  {

	/**
	 * DOM Selector (ID) of the container to display Modal's in
	 *
	 * @property MODAL_CONTAINER_ID
	 * @type String
	 */
	static String MODAL_CONTAINER_ID = "#modalContainer";

	/**
	 * Application flag that is set when a modal is open, so we can check from the application whether we're in a
	 * modal or not.
	 *
	 * @property inModal
	 * @type boolean
	 */
	static boolean inModal = false;

	/**
	 * Retrieves the current view that corresponds to the Modal Container Element (Should be a Modal)
	 *
	 * @memberOf ModalManager
	 * @method getCurrentModal
	 * @static
	 * @return {EcModal}
	 * 		EcModal instance that is currently being shown in the Modal container element
	 */
	public static EcModal getCurrentModal()
	{
		return (EcModal) getView(MODAL_CONTAINER_ID);
	}

	/**
	 * Sets the current modal and then shows it by calling the modals display function
	 *
	 * @memberOf ModalManager
	 * @method showModal
	 * @static
	 * @param {EcModal} modal
	 * 			Modal Instance to be displayed in the modal container and set as current
	 * @param {Callback0} callback
	 * 			Function to invoke after the modal has been displayed
	 */
	public static void showModal(EcModal modal, final Callback0 callback)
	{
		GlobalJQuery.$(MODAL_CONTAINER_ID).removeClass("tiny");
		GlobalJQuery.$(MODAL_CONTAINER_ID).removeClass("small");
		GlobalJQuery.$(MODAL_CONTAINER_ID).removeClass("medium");
		GlobalJQuery.$(MODAL_CONTAINER_ID).removeClass("large");
		GlobalJQuery.$(MODAL_CONTAINER_ID).removeClass("full");

		String modalSize = modal.getModalSize();

		if(modalSize.equals("tiny") || modalSize.equals("small") || modalSize.equals("medium") ||
				modalSize.equals("large") || modalSize.equals("full"))
		{
			GlobalJQuery.$(MODAL_CONTAINER_ID).addClass(modalSize);
		}
		else
		{
			GlobalJQuery.$(MODAL_CONTAINER_ID).addClass("small");
		}


		showView(modal, MODAL_CONTAINER_ID, new Callback0(){
			public void $invoke() {
				((Foundation)GlobalJQuery.$(MODAL_CONTAINER_ID)).foundation();

				((Foundation)GlobalJQuery.$(MODAL_CONTAINER_ID)).foundation("open");

				inModal = true;

				if(callback != null){
					callback.$invoke();
				}
			}
		});

	}

	/**
	 * Hides the modal container and returns to the screen or overlay that was being displayed beneath it
	 *
	 * @memberOf ModalManager
	 * @method hideModal
	 * @static
	 */
	public static void hideModal(){
		((Foundation)GlobalJQuery.$(MODAL_CONTAINER_ID)).foundation("close");

		inModal = false;
	}

	/**
	 * Static helper that watches the modal container for the foundation close event, and then calls the current modal's
	 * onClose callback if it exists once the close event occurs.
	 */
	static{
		GlobalJQuery.$(MODAL_CONTAINER_ID).one("closed.zf.reveal", new EventHandler(){

			public boolean onEvent(Event arg0, Element arg1) {
				Boolean result = getCurrentModal().onClose();
				if (result == null || JSGlobal.undefined == result)
					return true;
				return result;
			}

		});
	}
}
