package cass.rollup.processors.v2.graph.util;

import org.stjs.javascript.Array;
import org.stjs.javascript.Global;

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
            if (a.$get(i) != o) retArray.push(a.$get(i));
        }
        return retArray;
    }

    public static int arrayLastIndexOf(Array a, Object o) {
        for (int i=(a.$length() - 1);i>=0;i--) {
            if (a.$get(i) == o) return i;
        }
        return -1;
    }

    public static String arrayToString(Array a) {
        if (a == null || a.$length() == 0) return "<Emtpy>";
        String ret = "";
        for (int i=0;i<a.$length();i++) {
            if ((i + 1) < a.$length()) ret = ret + a.$get(i).toString() + ", ";
            else ret = ret + a.$get(i).toString();
        }
        return ret;
    }

}
