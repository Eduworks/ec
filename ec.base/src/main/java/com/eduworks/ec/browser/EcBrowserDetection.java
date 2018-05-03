package com.eduworks.ec.browser;

import org.stjs.javascript.Global;

public class EcBrowserDetection {
	public static Boolean isIeOrEdge() {
		return Global.window.navigator.appName == "Microsoft Internet Explorer" ||
				(Global.window.navigator.appName == "Netscape" && Global.window.navigator.appVersion.indexOf("Edge") > -1);
	}
}
