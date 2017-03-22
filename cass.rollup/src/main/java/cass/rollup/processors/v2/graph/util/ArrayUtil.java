package cass.rollup.processors.v2.graph.util;

import org.stjs.javascript.Array;

public class ArrayUtil {

    public static boolean arrayContains(Array a, Object o) {
        for (int i=0;i<a.$length();i++) {
            if (a.$get(i) == o) return true;
        }
        return false;
    }

    public static Array arrayRemove(Array a, Object o) {
        Array retArray = new Array();
        for (int i=0;i<a.$length();i++) {
            if (a.$get(i) != o) retArray.push(o);
        }
        return retArray;
    }

    public static int arrayLastIndexOf(Array a, Object o) {
        for (int i=(a.$length() - 1);i>=0;i--) {
            if (a.$get(i) == o) return i;
        }
        return -1;
    }

}
