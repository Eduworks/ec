package com.eduworks.ec.framework;

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
import com.eduworks.ec.framework.history.HistoryClosure;
import com.eduworks.ec.framework.history.HistoryObject;
import com.eduworks.ec.framework.view.EcScreen;
import com.eduworks.foundation.jquery.plugin.Foundation;

public class ScreenManager extends ViewManager {
	static String SCREEN_CONTAINER_ID = "#screenContainer";
	
	static Array<HistoryClosure> myHistory = JSCollections.$array();
	
	public final static EcScreen LOADING_STARTUP_PAGE = new EcScreen(){
		@Override
		public void display(String containerId, Callback0 callback) {
			if(callback != null)
				callback.$invoke();
		}
	};
	
	public static EcScreen defaultScreen = null;
	public static EcScreen startupScreen = null;
	
	static Callback1<String> startupCallback;
	static Callback1<EcScreen> loadHistoryCallback;
	
	static Array<Callback0> startupScreenCallbacks = JSCollections.$array();
	
	public static void addStartupScreenCallback(Callback0 callback){
		startupScreenCallbacks.unshift(callback);
	}
	
	public static EcScreen getCurrentScreen(){
		return (EcScreen)getView(SCREEN_CONTAINER_ID);
	}
	
	public static void setDefaultScreen(EcScreen page)
	{
		defaultScreen = page;
		
		GlobalJQuery.$(window.document).ready(new EventHandler(){

			@Override
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
						@Override
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
					@Override
					public void $invoke() {
						if(startupCallback != null)
							startupCallback.$invoke(locationHash);
					}
				});
				
				return true;
			}
		});
	}
	
	public static void changeScreen(EcScreen page, Boolean addHistory, final Callback0 callback)
	{		
		if(addHistory == null)
			addHistory = true;
		if(addHistory)
			addHistory(page, SCREEN_CONTAINER_ID);
			
		showView(page, SCREEN_CONTAINER_ID, new Callback0(){
			@Override
			public void $invoke() {
				((Foundation)GlobalJQuery.$(SCREEN_CONTAINER_ID)).foundation();
				
				if(callback != null)
					callback.$invoke();
			}
		});
	}
	public static void replaceScreen(EcScreen page, final Callback0 callback)
	{
		replaceHistory(page, SCREEN_CONTAINER_ID, null);
		
		showView(page, SCREEN_CONTAINER_ID, new Callback0(){
			@Override
			public void $invoke() {
				((Foundation)GlobalJQuery.$(SCREEN_CONTAINER_ID)).foundation();
				
				if(callback != null)
					callback.$invoke();
			}
		});
	}
	
	public static void reloadCurrentScreen(final Callback0 callback){
		showView(getCurrentScreen(), SCREEN_CONTAINER_ID, new Callback0(){
			@Override
			public void $invoke() {
				((Foundation)GlobalJQuery.$(SCREEN_CONTAINER_ID)).foundation();
				
				if(callback != null)
					callback.$invoke();
			}
		});
	}
	
	
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
						@Override
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
	
	static{
		GlobalJQuery.$(window).on("popstate", new EventHandler(){
			@Override
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
