package js;

import org.stjs.javascript.annotation.STJSBridge;
import org.stjs.javascript.functions.Callback1;

@STJSBridge(sources = "")
public class FileReader {

	public Callback1<Object> onload;
	public Callback1<Object> onerror;
	public FileReader() {

	}

	public void readAsText(Object file) {

	}
}
