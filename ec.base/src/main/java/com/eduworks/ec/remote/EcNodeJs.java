package com.eduworks.ec.remote;

import org.stjs.javascript.annotation.GlobalScope;
import org.stjs.javascript.annotation.STJSBridge;
import org.stjs.javascript.functions.Callback3;

/**
 * Interface to functions from node, presuming the javascript is being run in a node environment.
 *
 * @author fritz.ray@eduworks.com
 * @class EcNodeJs
 */
@GlobalScope
@STJSBridge()
public class EcNodeJs {

    /***
     * Method handle for httpStatus. Use .call if necessary to invoke.
     */
    public static Object isNodeJs;
    public static void request(Object request, Callback3<String,Object,String> handler){}
}
