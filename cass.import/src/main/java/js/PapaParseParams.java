package js;

import org.stjs.javascript.annotation.SyntheticType;
import org.stjs.javascript.functions.Callback1;

@SyntheticType
public class PapaParseParams {
	public Callback1<Object> complete;
	public Boolean header;
	public Callback1<Object> error;
	public String encoding;
}
