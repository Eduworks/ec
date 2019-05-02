package com.eduworks.ec.task;

import com.eduworks.ec.date.Date;
import com.eduworks.ec.remote.EcRemote;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.TimeoutHandler;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.CallbackOrFunction;

/**
 * Class with static methods to prevent unnecessary overhead with small operations that don't prevent drawing,
 * but to setTimeout on methods that slow down the browser sufficiently to interfere with drawing.
 * Uses a framerate timer to determine between the two.
 *
 * @class Task
 */
public class Task {
    public static int desiredFps = 2;
    public static Long lastFrame = null;
    public static Array<CallbackOrFunction> tasks = new Array();
    public static int delayedFunctions = 0;
    public static int immediateFunctions = 0;
    public static int calledFunctions = 0;
    public static int asyncImmediateFunctions = 0;
    public static int runningAsyncFunctions = 0;
    public static Object updateFrameHandle = null;

    static {
        updateFrame();
    }

    /***
     * Updates the framerate timer/counter.
     * @method updateFrame
     * @static
     */
    public static void updateFrame() {
        updateFrameHandle = Global.setTimeout(new Callback0() {
            @Override
            public void $invoke() {
                lastFrame = Date.now();
                if (calledFunctions - delayedFunctions - immediateFunctions == 0) {
                    updateFrameHandle = null;
                } else
                    updateFrame();
            }
        }, 100);
    }

    /***
     * Invoke a method now or later based on whether some time has passed since we last drew the screen.
     * @param {function()} c Method to invoke
     * @return Timeout Handler, can use clearTimeout on it if needed.
     */
    public static TimeoutHandler immediate(final Callback0 c) {
        final Long currentMs = Date.now();
        int nextFrameMs = 1000 / desiredFps;
        calledFunctions++;
        if (EcRemote.async == true && (lastFrame == null || currentMs > lastFrame + nextFrameMs)) {
            if (updateFrameHandle == null)
                updateFrame();
            return Global.setTimeout(new Callback0() {
                @Override
                public void $invoke() {
                    delayedFunctions++;
                    c.$invoke();
                }
            }, 0);
        } else {
            immediateFunctions++;
            c.$invoke();
        }
        return null;
    }

    /***
     * Invoke a method at some point in the future, allowing draw methods to occur periodically.
     * @param {function()} c Method to invoke
     * @return Timeout Handler, can use clearTimeout on it if needed.
     */
    public static TimeoutHandler asyncImmediate(final Callback1 c) {
        tasks.push(c);
        asyncImmediateFunctions++;
        if (runningAsyncFunctions < 20) {
            runningAsyncFunctions++;
            return Global.setTimeout(new Callback0() {
                @Override
                public void $invoke() {
                    asyncContinue();
                }
            }, 0);
        }
        return null;
    }

    public static void asyncContinue() {
        Callback0 keepGoing = new Callback0() {
            @Override
            public void $invoke() {
                asyncContinue();
            }
        };
        if (tasks.$length() > 0) {
            Callback1 c = (Callback1) tasks.pop();
            c.$invoke(keepGoing);
        } else
            runningAsyncFunctions--;
    }
}
