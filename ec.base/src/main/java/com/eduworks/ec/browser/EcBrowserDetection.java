package com.eduworks.ec.browser;

import org.stjs.javascript.Global;

public class EcBrowserDetection {
    public static Boolean isIeOrEdge() {
        if (Global.window == null) return false;
        if (Global.window.navigator == null) return false;
        if (Global.window.navigator.appName == null) return false;

        return Global.window.navigator.appName == "Microsoft Internet Explorer" ||
                (Global.window.navigator.appName == "Netscape" && Global.window.navigator.appVersion.indexOf("Edge") > -1);
    }
}
