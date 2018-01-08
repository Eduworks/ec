package js;

import org.stjs.javascript.annotation.STJSBridge;
import org.stjs.javascript.functions.Callback3;

@STJSBridge(sources = {"/src/main/resources/jsonld.js"})
public class jsonld{

	/**
	 * Performs JSON-LD compaction.
	 *
	 * @param input the JSON-LD input to compact.
	 * @param ctx the context to compact with.
	 * @param [options] options to use:
	 *          [base] the base IRI to use.
	 *          [compactArrays] true to compact arrays to single values when
	 *            appropriate, false not to (default: true).
	 *          [graph] true to always output a top-level graph (default: false).
	 *          [expandContext] a context to expand with.
	 *          [skipExpansion] true to assume the input is expanded and skip
	 *            expansion, false not to, defaults to false.
	 *          [documentLoader(url, callback(err, remoteDoc))] the document loader.
	 * @param callback(err, compacted, ctx) called once the operation completes.
	 */
	public static void compact(Object input, Object context, Object options, Callback3<String,Object,Object> callback){}
}