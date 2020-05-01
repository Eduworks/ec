package cass.rollup.rule;

import cass.rollup.js.bridges.*;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;

public class RollupRuleInterface {
	public Callback1<Object> logFunction;
	public Callback1<Boolean> success;
	public Callback2<String, Integer> failure;
	RollupListener listener;
	private RollupParser parser;
	private RollupRuleProcessor processor;

	public RollupRuleInterface(String input, RollupRuleProcessor processor) {
		InputStream chars = new InputStream(input);
		RollupLexer lexer = new RollupLexer(chars);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		parser = new RollupParser(tokens);
		parser.buildParseTrees = true;

		listener = new RollupListener();
		this.processor = processor;

		final RollupRuleInterface me = this;
		listener.enterS = new Callback1<context>() {
			@Override
			public void $invoke(context ctx) {
				me.processor.enterS(ctx);
			}
		};
		listener.exitS = new Callback1<context>() {
			@Override
			public void $invoke(context ctx) {
				me.processor.exitS(ctx);
				me.success.$invoke(true);
			}
		};
		listener.exitToken = new Callback1<context>() {

			@Override
			public void $invoke(context ctx) {
				me.processor.exitToken(ctx);
			}
		};
		listener.enterQuery = new Callback1<context>() {

			@Override
			public void $invoke(context ctx) {
				me.processor.enterQuery(ctx);
			}
		};
		listener.exitQuery = new Callback1<context>() {

			@Override
			public void $invoke(context ctx) {
				me.processor.exitQuery(ctx);
			}
		};
		listener.exitInnerquery = new Callback1<context>() {

			@Override
			public void $invoke(context ctx) {
				me.processor.exitInnerquery(ctx);
			}
		};
		listener.exitLogical_or_math_operator = new Callback1<context>() {

			@Override
			public void $invoke(context ctx) {
				me.processor.exitLogical_or_math_operator(ctx);
			}
		};
		parser.addParseListener(listener);

	}

	public void go() {
		processor.logFunction = logFunction;
		processor.success = success;
		processor.failure = failure;
		parser.s();
	}

}
