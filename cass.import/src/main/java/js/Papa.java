package js;

import org.stjs.javascript.annotation.STJSBridge;

@STJSBridge( sources = {"/src/main/resources/papaparse.js"})
public class Papa {
	
	public static void parse(Object file, PapaParseParams params){}
}
