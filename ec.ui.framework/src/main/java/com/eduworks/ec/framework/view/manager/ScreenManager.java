package com.eduworks.ec.framework.view.manager;

import static org.stjs.javascript.Global.console;
import static org.stjs.javascript.Global.window;

import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.dom.Element;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.jquery.Event;
import org.stjs.javascript.jquery.EventHandler;
import org.stjs.javascript.jquery.GlobalJQuery;

import com.eduworks.History.History;
import com.eduworks.ec.framework.browser.history.HistoryClosure;
import com.eduworks.ec.framework.browser.history.HistoryObject;
import com.eduworks.ec.framework.view.EcScreen;
import com.eduworks.foundation.jquery.plugin.Foundation;

/**
 * View Manager child class that manages loading "screen"s and saving screen history. This is the main view type
 * in an application and represents a view that takes up (mostly) the entire browser page. History is tracked in the
 * session, so  when the back button is pressed, the application will load the previous screen with any data that 
 * was associated with it.
 * 
 * @author devlin.junker@eduworks.com
 *
 */
public class ScreenManager extends ViewManager {
	
	/**
	 * DOM Selector (ID) of the Screen Container that will display all of the screen views
	 */
	static String SCREEN_CONTAINER_ID = "#screenContainer";
	
	/**
	 * Array to track the history of the current session
	 */
	static Array<HistoryClosure> myHistory = JSCollections.$array();
	
	/**
	 * Screen to be used when another screen is loading information from the server before being able to display
	 * itself. Notice that the display function does not affect the DOM on the page in any way.
	 */
	public final static EcScreen LOADING_STARTUP_PAGE = new EcScreen(){
		@Override
		public String getHtmlLocation() {
			return null;
		}
	};
	
	/**
	 * Screen to be set by application on application startup, dictates what the screen should be if the startup
	 * Screen hasn't been set
	 */
	public static EcScreen defaultScreen = null;
	
	/**
	 * Screen to be set by application if it notices that a certain screen should be loaded on startup that is 
	 * different from the default Screen
	 */
	public static EcScreen startupScreen = null;
	
	/**
	 * Callback to be invoked once the application has started and the first screen has been completely loaded
	 * and displayed
	 */
	static Callback1<String> startupCallback;
	
	/**
	 * Callback invoked during a history load (used in Overlay Manager to open an overlay if it was last history view)
	 */
	static Callback1<EcScreen> loadHistoryCallback;
	
	/**
	 * Array of callbacks that will compare any markers saved in the browser to see if a specific startup screen
	 * should be set. These callbacks should be defined in the screen Java implementation to check if the screen
	 * should be loaded.
	 */
	static Array<Callback0> startupScreenCallbacks = JSCollections.$array();
	
	/**
	 * Function to add startup screen callbacks to the array of callbacks
	 * 
	 * @param callback
	 * 			callback to add, all callbacks will be invoked on the application startup
	 */
	public static void addStartupScreenCallback(Callback0 callback){
		startupScreenCallbacks.unshift(callback);
	}
	
	/**
	 * Retrieves the current view that corresponds to the Screen Container Element (Should be a screen)
	 * 
	 * @return
	 * 		EcScreen instance that is currently being shown in the screen container element
	 */
	public static EcScreen getCurrentScreen(){
		return (EcScreen)getView(SCREEN_CONTAINER_ID);
	}
	
	
	/**
	 * Sets the application default Screen that is shown if no startup screen has been defined.
	 * Also sets up some code to run during the application load, that calls the startup callbacks
	 * to see if there is a startup screen different than the defaultScreen, then displays it or the
	 * defaultScreen depending on the results
	 * 
	 * @param page
	 * 			The default screen that will be displayed if no startup screen is defined during load
	 */
	public static void setDefaultScreen(EcScreen page)
	{
		defaultScreen = page;
		
		GlobalJQuery.$(window.document).ready(new EventHandler(){

			public boolean onEvent(Event arg0, Element arg1) {
				
				for(int i = 0; i < startupScreenCallbacks.$length(); i++)
				{
					Callback0 cb = startupScreenCallbacks.$get(i);
					
					cb.$invoke();
				}
				
				if(startupScreen != null)
				{
					Object params = null;
					if(window.document.location.hash.contains("?")){
						Array<String> hashSplit = JSCollections.$castArray(Global.window.document.location.hash.split("?"));
						if(hashSplit.$length() > 1 && hashSplit.$get(1) != ""){
							Array<String> paramSplit = JSCollections.$castArray(hashSplit.$get(1).split("&"));
							
							for(int i = 0; i< paramSplit.$length(); i++){
								Array<String> argSplit = JSCollections.$castArray(paramSplit.$get(i).split("="));
								
								if(argSplit.$length() == 2)
								if(params == null)
									params = new Object();
								JSObjectAdapter.$put(params, argSplit.$get(0), argSplit.$get(1));
							}
						}
					}
					
					replaceHistory(startupScreen, SCREEN_CONTAINER_ID, params);
					
					showView(startupScreen, SCREEN_CONTAINER_ID, new Callback0(){
						public void $invoke() {
							((Foundation)GlobalJQuery.$(SCREEN_CONTAINER_ID)).foundation();
						}
					});
					return true;
				}

				if(defaultScreen == null)
				{
					console.error("Default Page Not Set, Cannot Start Application");
					return false;
				}
				
				final String locationHash = Global.window.document.location.hash;
				
				replaceScreen(defaultScreen, new Callback0(){
					public void $invoke() {
						if(startupCallback != null)
							startupCallback.$invoke(locationHash);
					}
				});
				
				return true;
			}
		});
	}
	
	/**
	 * Set's the current screen, then show's it by calling the display function. Depending on the
	 * addHistory flag, will add the page passed in to the history array, tracking session page history
	 * 
	 * @param page
	 * 			The screen to set as current and display
	 * @param addHistory
	 * 			Flag for whether to store this page in the history array
	 * @param callback
	 * 			Function to invoke after the page has been displayed and foundation has been set up on the new HTML
	 */
	public static void changeScreen(EcScreen page, Boolean addHistory, final Callback0 callback)
	{		
		if(addHistory == null)
			addHistory = true;
		if(addHistory)
			addHistory(page, SCREEN_CONTAINER_ID);
			
		showView(page, SCREEN_CONTAINER_ID, new Callback0(){
			public void $invoke() {
				((Foundation)GlobalJQuery.$(SCREEN_CONTAINER_ID)).foundation();
				
				if(callback != null)
					callback.$invoke();
			}
		});
	}
	
	/**
	 * Set's the current screen, then show's it by calling the display function. This replaces the current HistoryClosure
	 * element for the current screen in the history array, rather than leaving it and (potentially) adding another
	 * history array element like changeScreen
	 * 
	 * @param page
	 * 			Screen to set as current and display
	 * @param callback
	 * 			Function to invoke after the page has been displayed and foundation has been set up on the new HTML
	 */
	public static void replaceScreen(EcScreen page, final Callback0 callback)
	{
		replaceHistory(page, SCREEN_CONTAINER_ID, null);
		
		showView(page, SCREEN_CONTAINER_ID, new Callback0(){
			public void $invoke() {
				((Foundation)GlobalJQuery.$(SCREEN_CONTAINER_ID)).foundation();
				
				if(callback != null)
					callback.$invoke();
			}
		});
	}
	
	/**
	 * Reloads the current screen, leaving the history alone
	 * 
	 * @param callback
	 * 			Function to invoke after the page has been redisplayed and foundation has been set up on the new HTML
	 */
	public static void reloadCurrentScreen(final Callback0 callback){
		showView(getCurrentScreen(), SCREEN_CONTAINER_ID, new Callback0(){
			public void $invoke() {
				((Foundation)GlobalJQuery.$(SCREEN_CONTAINER_ID)).foundation();
				
				if(callback != null)
					callback.$invoke();
			}
		});
	}
	
	/**
	 * Adds the screen passed in and the display container to a HistoryClosure element and pushes it 
	 * on the end of the history cache array. This does not ensure that the screen is displayed though.
	 * 
	 * @param screen
	 * 			The screen to add to the history cache array
	 * @param displayContainerId
	 * 			DOM Element ID corresponding to where the screen will be displayed (likely the SCREEN_CONTAINER_ID)
	 */
	public static void addHistory(EcScreen screen, String displayContainerId)
	{	
		String name = screen.getDisplayName();
		
		if(name.equals(""))
			name = screen.displayName;
		if(name.equals(""))
			return;
		
		final String pageName = name;
		myHistory.$set(myHistory.$length(), new HistoryClosure(pageName, screen, displayContainerId));
		((History)window.history).pushState(new HistoryObject(){{
			name = pageName;
		}}, pageName, "#"+pageName);
	}
	
	/**
	 * Replaces the current end of the history array with a new HistoryClosure element that contains the screen and 
	 * containerId passed in.
	 * 
	 * @param screen
	 * 			Screen to add to the history element that will replace the last in the history array
	 * @param displayContainerId
	 * 			DOM Element ID corresponding to where the screen will be displayed (likely the SCREEN_CONTAINER_ID)
	 * @param params
	 * 			Object containing key to value pairs that should be put in the url bar to remember state at this history point
	 */
	public static void replaceHistory(EcScreen screen, String displayContainerId, Object params)
	{
		String name = screen.getDisplayName();
		if(name.equals(""))
			name = screen.displayName;
		if(name.equals(""))
			return;
		
		final String pageName = name;
		
		int idx = myHistory.$length()-1;
		if(idx < 0)
			idx = 0;
		myHistory.$set(idx, new HistoryClosure(pageName, screen, displayContainerId));
		
		String hash = "#"+pageName;
		if(params != null){
			hash += "?";
			for(String str : JSObjectAdapter.$properties(params))
			{
				if(!hash.endsWith("?"))
					hash+="&";
				hash += str + "=" + JSObjectAdapter.$get(params, str);
			}
		}
		if(hash.endsWith("?")){
			hash = hash.substring(0, hash.length()-1);
		}
		
		((History)window.history).replaceState(new HistoryObject(){{
			name = pageName;
		}}, pageName, hash);
	}
	
	/**
	 * Sets the url parameters on the current page
	 * @param params
	 * 		url parameters json object
	 */
	public static void setScreenParameters(Object params)
	{
		replaceHistory(myHistory.$get(myHistory.$length()-1).screen,SCREEN_CONTAINER_ID, params);
	}
	
	/**
	 * Searches through the history array for the last screen that was loaded with the name passed in, and then displays
	 * it in the container that it was associated with. If there is no screen in the history, then check
	 * if there is a startupScreen that can be loaded right now, otherwise load the default screen
	 * 
	 * @param name
	 * 			Name of the screen to search for in the history array
	 */
	protected static void loadHistoryScreen(String name){
		for(int i = myHistory.$length()-1; i > -1; i--){
			if(myHistory.$get(i).pageName == name)
			{
				if(myHistory.$get(i).screen != null)
				{
					EcScreen screen = myHistory.$get(i).screen;
					
					if(loadHistoryCallback != null)
						loadHistoryCallback.$invoke(screen);
						
					showView(screen, myHistory.$get(i).containerId, new Callback0(){
						public void $invoke() {
							((Foundation)GlobalJQuery.$(SCREEN_CONTAINER_ID)).foundation();
						}
					});					
					
					myHistory.$set(myHistory.$length(), new HistoryClosure(name, screen, myHistory.$get(i).containerId));
					
					return;
				}
			}
		}
		
		startupScreen = null;
		for(int i = 0; i < startupScreenCallbacks.$length(); i++)
		{
			Callback0 cb = startupScreenCallbacks.$get(i);
			
			cb.$invoke();
		}
		
		if(startupScreen != null)
			changeScreen(startupScreen, false, null);
		
		String tempName = defaultScreen.getDisplayName();
		if(tempName.equals(""))
			tempName = defaultScreen.displayName;
		if(tempName.equals(""))
			return;
		
		final String defaultName = name;
		
		if(name.equals(defaultName)){
			window.history.go(-1*window.history.length);
		}
	}
	
	/**
	 * Static setup to watch the window for popstate events (history back button) and then calls loadHistory
	 * with the name of the most previously recent screen (saved in the history and given to the popstate event)
	 */
	static{
		GlobalJQuery.$(window).on("popstate", new EventHandler(){
			public boolean onEvent(Event event, Element arg1) {
				Object state = JSObjectAdapter.$get(event.originalEvent, "state");
				
				if(state != null)
				{
					String poppedName = (String) JSObjectAdapter.$get(state, "name");
					loadHistoryScreen(poppedName);
				}
				return true;
			}
		});
	}
}
