package FileReader;

import org.stjs.javascript.annotation.STJSBridge;
import org.stjs.javascript.functions.Callback1;
import org.w3c.dom.events.Event;

@STJSBridge(sources = "")
public class FileReader {
	
	public FileReader(){
		
	}
	
	public Callback1<Object> onload;
	public Callback1<Object> onerror;
	
	public void readAsText(Object file){
		
	}
}
