package cass.rollup.processors.util;

import org.stjs.javascript.Array;

public class EcGraphUtil {

    public static String buildIdSearchQueryForIdList(Array<String> idList) {
        String searchQuery = "";
        if (idList.$length() > 1) searchQuery = "(";
        for (int i = 0; i < idList.$length(); i++) {
            if (i > 0) searchQuery += " OR ";
            searchQuery += "(\\*@id:\"" + idList.$get(i) + "\")";
        }
        if (idList.$length() > 1) searchQuery += ")";
        return searchQuery;
    }

}
