package org.cassproject.schema.general;

import org.stjs.javascript.annotation.GlobalScope;
import org.stjs.javascript.annotation.STJSBridge;

@GlobalScope
@STJSBridge(sources = {"FileSaver.js"})
public class FileSaver {

	public static void saveAs(Object blob, String name) {

	}

}
