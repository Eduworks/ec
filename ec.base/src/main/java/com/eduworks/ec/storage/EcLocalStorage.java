package com.eduworks.ec.storage;

import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Storage;
import org.stjs.javascript.functions.Function1;

public class EcLocalStorage {

    public static void removeItem(Storage s, String key) {
        ((Function1)JSObjectAdapter.$get(s, "removeItem")).$invoke(key);
    }
}
