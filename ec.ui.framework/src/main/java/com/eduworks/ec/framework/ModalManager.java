package com.eduworks.ec.framework;

import org.stjs.javascript.dom.Element;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.jquery.Event;
import org.stjs.javascript.jquery.EventHandler;
import org.stjs.javascript.jquery.GlobalJQuery;

import com.eduworks.ec.framework.view.EcModal;
import com.eduworks.foundation.jquery.plugin.Foundation;

public class ModalManager extends ViewManager  {
	static String MODAL_CONTAINER_ID = "#modalContainer";
	
	static boolean inModal = false;
	
	public static EcModal getCurrentModal()
	{
		return (EcModal) getView(MODAL_CONTAINER_ID);
	}
	
	public static void showModal(EcModal modal)
	{
		GlobalJQuery.$(MODAL_CONTAINER_ID).removeClass("tiny");
		GlobalJQuery.$(MODAL_CONTAINER_ID).removeClass("small");
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
			}
		});
		
	}
	public static void hideModal(){
		((Foundation)GlobalJQuery.$(MODAL_CONTAINER_ID)).foundation("close");
		
		inModal = false;
	}
	
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
