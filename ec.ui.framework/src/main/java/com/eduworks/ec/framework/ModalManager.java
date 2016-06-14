package com.eduworks.ec.framework;

import org.stjs.javascript.dom.Element;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.jquery.Event;
import org.stjs.javascript.jquery.EventHandler;
import org.stjs.javascript.jquery.GlobalJQuery;

import com.eduworks.ec.framework.view.EcModal;
import com.eduworks.foundation.jquery.plugin.Foundation;

/**
 * View Manager sub class that manages loading "modal"s and has a few helper functions to make sure that 
 * they work properly
 * 
 * @author djunker
 *
 */
public class ModalManager extends ViewManager  {
	/**
	 * DOM Selector (ID) of the container to display Modal's in
	 */
	static String MODAL_CONTAINER_ID = "#modalContainer";
	
	/**
	 * Application flag that is set when a modal is open, so we can check from the application whether we're in a 
	 * modal or not.
	 */
	static boolean inModal = false;
	
	/**
	 * Retrieves the current view that corresponds to the Modal Container Element (Should be a Modal)
	 * 
	 * @return
	 * 		EcModal instance that is currently being shown in the Modal container element
	 */
	public static EcModal getCurrentModal()
	{
		return (EcModal) getView(MODAL_CONTAINER_ID);
	}
	
	/**
	 * Sets the current modal and then shows it by calling the modals display function
	 *  
	 * @param modal
	 * 			Modal Instance to be displayed in the modal container and set as current
	 * @param callback
	 * 			Function to invoke after the modal has been displayed
	 */
	public static void showModal(EcModal modal, final Callback0 callback)
	{
		GlobalJQuery.$(MODAL_CONTAINER_ID).removeClass("tiny");
		GlobalJQuery.$(MODAL_CONTAINER_ID).removeClass("small");
		GlobalJQuery.$(MODAL_CONTAINER_ID).removeClass("medium");
		GlobalJQuery.$(MODAL_CONTAINER_ID).removeClass("large");
		GlobalJQuery.$(MODAL_CONTAINER_ID).removeClass("full");
		
		if(modal.modalSize.equals("tiny") || modal.modalSize.equals("small") || modal.modalSize.equals("medium") || 
				modal.modalSize.equals("large") || modal.modalSize.equals("full"))
		{
			GlobalJQuery.$(MODAL_CONTAINER_ID).addClass(modal.modalSize);
		}
		else
		{
			GlobalJQuery.$(MODAL_CONTAINER_ID).addClass("small");
		}
		
		
		showView(modal, MODAL_CONTAINER_ID, new Callback0(){
			@Override
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
	 */
	public static void hideModal(){
		((Foundation)GlobalJQuery.$(MODAL_CONTAINER_ID)).foundation("close");
		
		inModal = false;
	}
	
	/**
	 * Static helper that watches the modal container for the foundation close event, and then calls the curernt modal's
	 * onClose callback if it exists once the close event occurs.
	 */
	static{
		GlobalJQuery.$(MODAL_CONTAINER_ID).one("closed.zf.reveal", new EventHandler(){

			@Override
			public boolean onEvent(Event arg0, Element arg1) {
				if(getCurrentModal().onClose != null)
					getCurrentModal().onClose.$invoke();
				
				return true;
			}
			
		});
	}
}
