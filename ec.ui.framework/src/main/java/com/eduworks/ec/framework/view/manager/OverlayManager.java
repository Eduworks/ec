package com.eduworks.ec.framework.view.manager;

import static org.stjs.javascript.Global.window;

import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.dom.Element;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;
import org.stjs.javascript.jquery.Event;
import org.stjs.javascript.jquery.EventHandler;
import org.stjs.javascript.jquery.GlobalJQuery;

import com.eduworks.ec.framework.view.EcOverlay;
import com.eduworks.ec.framework.view.EcScreen;
import com.eduworks.foundation.jquery.plugin.Foundation;

/**
 * View Manager that manages displaying overlay views (views that take over the screen, but can be exited to return to
 * the previous screen) with a few helper functions for managing overlays
 * 
 * @author devlin.junker@eduworks.com
 * (NOT TESTED MUCH YET)
 */
public class OverlayManager extends ScreenManager {
	
	/**
	 * DOM Selector of the overlay wrapper (Should contain the overlay container and overlay close button)
	 */
	static String OVERLAY_WRAPPER_ID = "#overlay";
	
	/**
	 * DOM Selector of the overlay close button (clicking this should hide the current overlay) 
	 */
	static String OVERLAY_CLOSE_BTN_ID = "#closeOverlay";
	
	/**
	 * DOM Selector of the HTML Element that will display the Overlay's HTML
	 */
	static String OVERLAY_CONTAINER_ID = "#overlayContainer";
	
	/**
	 * Used if one of the startupOverlayCallbacks decides that it should be displayed on startup (usually using
	 * the URL to check what should be displayed on start)
	 */
	public static EcOverlay startupOverlay = null;
	
	/**
	 * Callbacks that can be defined and run on startup, that should check to see if an overlay should be displayed
	 * immediately when the application starts
	 */
	static Array<Callback1<String>> startupOverlayCallbacks = JSCollections.$array();
	
	/**
	 * Adds a callback to be run on startup that can check if an overlay should be displayed (the callback should
	 * be defined in the overlay)
	 * 
	 * @param callback
	 * 			callback to be added to the startupOverlayCallbacks list
	 */
	public static void addStartupOverlayCallback(Callback1<String> callback){
		startupOverlayCallbacks.unshift(callback);
	}
	
	/**
	 * Application flag to check if we're currently in an overlay or not
	 */
	static boolean inOverlay = false;
	
	/**
	 * Retrieves the current view that corresponds to the Overlay Container Element (Should be a Overlay)
	 * 
	 * @return
	 * 		EcModal instance that is currently being shown in the Overlay container element
	 */
	public static EcOverlay getCurrentOverlay()
	{
		return (EcOverlay) getView(OVERLAY_CONTAINER_ID);
	}
	
	/**
	 * Variable to hold the last screen, this is useful if we follow a chain of overlays and then want to close them,
	 * we'll make sure to go back to the last screen that was visible to the user
	 */
	static EcScreen lastScreen;
	
	static Object lastScreenParams;
	
	/**
	 * Set's the current overlay, then show's it by calling the display function and unhiding the overlay container.
	 * Depending on the addHistory flag, will add the overlay passed in to the history array 
	 * 
	 * @param overlay
	 * 			The overlay to set as current and display
	 * @param addHistory
	 * 			Flag for whether to store this overlay in the history array
	 */
	public static void showOverlay(EcOverlay overlay, Boolean addHistory)
	{
		if(!inOverlay && myHistory.$get(myHistory.$length()-1) != null)
		{
			lastScreen = myHistory.$get(myHistory.$length()-1).screen;
			lastScreenParams = myHistory.$get(myHistory.$length()-1).screenParameters;
		}
		
		
		if(addHistory == null)
			addHistory = true;
		if(addHistory)	// TODO : Figure out how to correctly fix history
			addHistory(overlay, OVERLAY_CONTAINER_ID, null);
		
		showView(overlay, OVERLAY_CONTAINER_ID, new Callback0(){
			public void $invoke() {
				((Foundation)GlobalJQuery.$(window.document)).foundation();
				
				GlobalJQuery.$(OVERLAY_WRAPPER_ID).addClass("active");
				GlobalJQuery.$(OVERLAY_WRAPPER_ID).fadeIn();
				
				inOverlay = true;
			}
		});
		
		GlobalJQuery.$(OVERLAY_CLOSE_BTN_ID).off("click");
		GlobalJQuery.$(OVERLAY_CLOSE_BTN_ID).click(new EventHandler(){
			public boolean onEvent(Event arg0, Element arg1) {
				hideOverlay();
				return true;
			}
		});
	}
	
	/**
	 * Hides the overlay container and sets the inOverlay flag to false, adds the last screen to the history array so
	 * there is a chain from initial screen to overlay (could be multiple) to initial screen. This way we can press the
	 * back button and be shown the last overlay.
	 */
	public static void hideOverlay()
	{
		GlobalJQuery.$(OVERLAY_WRAPPER_ID).fadeOut();
		
		inOverlay = false;
		
		if(myHistory.$length() <= 2)
			OverlayManager.changeScreen(lastScreen, null, lastScreenParams, null);
	}
	
	/**
	 * Static method to set up helpers
	 *  - Window Keydown event handler that checks if were in an overlay and the esc key was pressed 
	 *  	(if true hide the overlay)
	 *  - Sets the loadHistoryCallback so we can check if the history element loaded was an overlay and display it
	 *  	properly if it was
	 *  - Sets the startupCallback to run through the overlay startup callbacks to check if we should start
	 *  	the application on an overlay
	 */
	static
	{
		GlobalJQuery.$(window).keydown(new EventHandler(){
			public boolean onEvent(Event event, Element arg1) {
				// If Escape pressed in Overlay
				if(event.keyCode == 27 && inOverlay){
					hideOverlay();
				}
					
				
				return true;
			}
		});
		
		loadHistoryCallback = new Callback2<EcScreen, Object>() {
			public void $invoke(EcScreen screen, Object params) {
				EcOverlay overlay = screen.as(EcOverlay.class);
				if(overlay != null && !inOverlay)
				{
					showOverlay(overlay, false);
				}
				else if(inOverlay)
				{
					hideOverlay();
					
					inOverlay = false;
				}
			}
		};
		
		startupCallback = new Callback1<String>(){
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
