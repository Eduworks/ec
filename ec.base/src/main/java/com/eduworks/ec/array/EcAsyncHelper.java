package com.eduworks.ec.array;

import com.eduworks.ec.task.Task;
import org.stjs.javascript.Array;
import org.stjs.javascript.functions.*;

/**
 * Pattern (probably similar to Promise) that provides fine grained control over asynchronous execution.
 * Will iterate over all items in an array and perform 'each(item,callback)'.
 * Every 'each' needs to call the callback. This callback can be passed down through several asynchronous calls.
 * When all callbacks have been called, 'after(array)' is called.
 *
 * @author fritz.ray@eduworks.com
 * @module com.eduworks.ec
 * @class EcAsyncHelper
 */
public class EcAsyncHelper<T> {
    public static String scriptPath = null;
    public static Callback1<String> setNull(final Callback1 set){
        return new Callback1<String>() {
            @Override
            public void $invoke(String s) {
                set.$invoke(null);
            }
        };
    }
    /**
     * Counter that counts down when each callback is called. Lots of tricks can be done to cause after to proc in different ways.
     *
     * @property counter
     * @type integer
     */
    public Integer counter;

    /**
     * "Each" method. See class description.
     *
     * @param {Array}                   array Array to iterate over.
     * @param {function(item,callback)} each Method that gets invoked per item in the array.
     * @param {function(array)}         after Method invoked when all callbacks are called.
     * @method each
     * @memberOf EcAsyncHelper
     */
    public void each(final Array<T> array, Callback2<T, Callback0> each, final Callback1<Array<T>> after) {
        final EcAsyncHelper me = this;
        counter = array.$length();
        if (array.$length() == 0)
            after.$invoke(array);
        for (int i = 0; i < array.$length(); i++) {
            if (counter > 0)
                execute(array, each, after, me, i);
        }
    }

    /**
     * "Each" method. Allows for replacing values in the array. See class description.
     *
     * @param {Array}                   array Array to iterate over.
     * @param {function(item,callback)} each Method that gets invoked per item in the array.
     * @param {function(array)}         after Method invoked when all callbacks are called.
     * @method each
     * @memberOf EcAsyncHelper
     */
    public void eachSet(final Array<T> array, Callback2<T, Callback1> each, final Callback1<Array<T>> after) {
        final EcAsyncHelper me = this;
        counter = array.$length();
        if (array.$length() == 0)
            after.$invoke(array);
        for (int i = 0; i < array.$length(); i++) {
            if (counter > 0)
                executeSet(array, each, after, me, i);
        }
    }

    private void execute(final Array<T> array, final Callback2<T, Callback0> each, final Callback1<Array<T>> after, final EcAsyncHelper me, final int i) {
        Task.immediate(new Callback0() {
            @Override
            public void $invoke() {
                each.$invoke(array.$get(i), new Callback0() {
                    @Override
                    public void $invoke() {
                        me.counter--;
                        if (me.counter == 0)
                            after.$invoke(array);
                    }
                });
            }
        });
    }

    private void executeSet(final Array<T> array, final Callback2<T, Callback1> each, final Callback1<Array<T>> after, final EcAsyncHelper me, final int i) {
        Task.immediate(new Callback0() {
            @Override
            public void $invoke() {
                each.$invoke(array.$get(i), new Callback1<T>() {
                    @Override
                    public void $invoke(T result) {
                        array.$set(i,result);
                        me.counter--;
                        if (me.counter == 0) {
                            Array<T> finalArray = new Array<>();
                            for (int j = 0;j < array.$length();j++)
                                if (array.$get(j) != null)
                                    finalArray.push(array.$get(j));
                            after.$invoke(finalArray);
                        }
                    }
                });
            }
        });
    }

    public Callback1<String> failWithCallback(final Callback1<String> failure, final Callback0 callback) {
        return new Callback1<String>() {
            @Override
            public void $invoke(String s) {
                callback.$invoke();
                failure.$invoke(s);
            }
        };
    }

    /**
     * Stops any remaining objects from being iterated over, if they have not already. Will prevent 'after' from being called.
     *
     * @method stop
     * @memberOf EcAsyncHelper
     */
    public void stop() {
        counter = -1;
    }

    /**
     * Stops any remaining objects from being iterated over, if they have not already. Will allow 'after' to be called.
     *
     * @method stop
     * @memberOf EcAsyncHelper
     */
    public void finish() {
        counter = 1;
    }

    /**
     * Is preventing 'after' from being called?
     *
     * @return whether it is stopped.
     * @method isStopped
     * @memberOf EcAsyncHelper
     */
    public boolean isStopped() {
        return counter <= -1;
    }
}
