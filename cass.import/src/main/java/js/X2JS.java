package js;

import org.stjs.javascript.annotation.STJSBridge;

@STJSBridge(sources = {"/src/main/resources/xml2json.js"})
public class X2JS {
	public Object xml_str2json(String xmlString) {
		throw new RuntimeException();
	}
}
