package com.eduworks.ec.framework;

import static org.stjs.javascript.Global.window;

import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.dom.Element;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.jquery.Event;
import org.stjs.javascript.jquery.EventHandler;
import org.stjs.javascript.jquery.GlobalJQuery;

import com.eduworks.ec.framework.view.EcOverlay;
import com.eduworks.ec.framework.view.EcScreen;
import com.eduworks.foundation.jquery.plugin.Foundation;

public class OverlayManager extends ScreenManager {
	static String OVERLAY_WRAPPER_ID = "#overlay";
	static String OVERLAY_CLOSE_BTN_ID = "#closeOverlay";
	static String OVERLAY_CONTAINER_ID = "#overlayContainer";
	
	public static EcOverlay startupOverlay = null;
	
	static Array<Callback1<String>> startupOverlayCallbacks = JSCollections.$array();
	
	public static void addStartupOverlayCallback(Callback1<String> callback){
		startupOverlayCallbacks.unshift(callback);
	}
	
	static boolean inOverlay = false;
	
	public static EcOverlay getCurrentOverlay()
	{
		return (EcOverlay) getView(OVERLAY_CONTAINER_ID);
	}
	
	static EcScreen lastScreen;
	
	public static void showOverlay(EcOverlay overlay, Boolean addHistory)
	{
		if(!inOverlay && myHistory.$get(myHistory.$length()-1) != null)
			lastScreen = myHistory.$get(myHistory.$length()-1).screen;
			
		if(addHistory == null)
			addHistory = true;
		if(addHistory)	// TODO : Figure out how to correctly fix history
			addHistory(overlay, OVERLAY_CONTAINER_ID);
		
		showView(overlay, OVERLAY_CONTAINER_ID, new Callback0(){
			@Override
			public void $invoke() {
				((Foundation)GlobalJQuery.$(window.document)).foundation();
				
				GlobalJQuery.$(OVERLAY_WRAPPER_ID).addClass("active");
				GlobalJQuery.$(OVERLAY_WRAPPER_ID).fadeIn();
				
				inOverlay = true;
			}
		});
		
		GlobalJQuery.$(OVERLAY_CLOSE_BTN_ID).off("click");
		GlobalJQuery.$(OVERLAY_CLOSE_BTN_ID).click(new EventHandler(){
			@Override
			public boolean onEvent(Event arg0, Element arg1) {
				hideOverlay();
				return true;
			}
		});
	}
	public static void hideOverlay()
	{
		GlobalJQuery.$(OVERLAY_WRAPPER_ID).fadeOut();
		
		inOverlay = false;
		
		changeScreen(lastScreen, true, null);
	}
	
	static
	{
		GlobalJQuery.$(window).keydown(new EventHandler(){
			@Override
			public boolean onEvent(Event event, Element arg1) {
				// If Escape pressed in Overlay
				if(event.keyCode == 27 && inOverlay)
					hideOverlay();
				
				return true;
			}
		});
		
		loadHistoryCallback = new Callback1<EcScreen>() {
			@Override
			public void $invoke(EcScreen screen) {
				EcOverlay overlay = screen.as(EcOverlay.class);
				if(overlay != null && !inOverlay)
				{
					showOverlay(overlay, false);
				}
				else if(inOverlay)
				{
					hideOverlay();
				}
			}
		};
		
		startupCallback = new Callback1<String>(){
			@Override
			public void $invoke(String locationHash) {
				for(int i = 0; i < startupOverlayCallbacks.$length(); i++)
				{
					Callback1<String> cb = startupOverlayCallbacks.$get(i);
					
					cb.$invoke(locationHash);
				}
				
				if(startupOverlay != null)
				{
					showOverlay(startupOverlay, true);
				}
			}
		};
	}
}
