package cass.rollup.js.bridges;

import org.stjs.javascript.annotation.Namespace;
import org.stjs.javascript.annotation.STJSBridge;
import org.stjs.javascript.functions.Callback1;

@Namespace("RollupListener")
@STJSBridge()
public class RollupListener {

	public Callback1<context> enterS;
	public Callback1<context> exitS;
	public Callback1<context> exitToken;
	public Callback1<context> enterQuery;
	public Callback1<context> exitQuery;
	public Callback1<context> exitInnerquery;
	public Callback1<context> exitLogical_or_math_operator;

}
