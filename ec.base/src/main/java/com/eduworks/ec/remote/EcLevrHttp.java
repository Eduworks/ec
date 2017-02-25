
package com.eduworks.ec.remote;

import org.stjs.javascript.annotation.GlobalScope;
import org.stjs.javascript.annotation.STJSBridge;

/**
 *
 * @author fray
 */
@GlobalScope
@STJSBridge()
public class EcLevrHttp
{
    /*function httpPost(vobj,vcontentType,vmultipart,vname,vauthToken){
var cru = new com.eduworks.cruncher.net.CruncherHttpPost();
cru.build('obj',com.eduworks.resolver.lang.LevrJsParser.jsToJava(vobj));
cru.build('contentType',com.eduworks.resolver.lang.LevrJsParser.jsToJava(vcontentType));
if (vmultipart != null) cru.build('multipart',com.eduworks.resolver.lang.LevrJsParser.jsToJava(vmultipart));
if (vname != null) cru.build('name',com.eduworks.resolver.lang.LevrJsParser.jsToJava(vname));
if (vauthToken != null) cru.build('authToken',com.eduworks.resolver.lang.LevrJsParser.jsToJava(vauthToken));
return cru.resolve(context,parameters,dataStreams);
}*/
    public static Object httpPost(Object obj, String url, String contentType, String multipart, String name){return null;}
    public static Object httpGet(String url){return null;}
    public static String httpDelete(String url){return null;}
}
