package cass.rollup;

import org.stjs.javascript.functions.Callback1;

import cass.rollup.js.bridges.CommonTokenStream;
import cass.rollup.js.bridges.InputStream;
import cass.rollup.js.bridges.RollupLexer;
import cass.rollup.js.bridges.RollupListener;
import cass.rollup.js.bridges.RollupParser;
import cass.rollup.js.bridges.context;

public class RollupRuleInterface
{
	RollupListener listener;

	Callback1<Object> logFunction;

	private RollupParser parser;
	private RollupRuleProcessor processor;

	public Callback1<Boolean> success;
	public Callback1<String> failure;

	public RollupRuleInterface(String input, RollupRuleProcessor processor)
	{
		InputStream chars = new InputStream(input);
		RollupLexer lexer = new RollupLexer(chars);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		parser = new RollupParser(tokens);
		parser.buildParseTrees = true;

		listener = new RollupListener();
		this.processor = processor;

		final RollupRuleInterface me = this;
		listener.enterS = new Callback1<context>()
		{
			@Override
			public void $invoke(context ctx)
			{
				me.processor.enterS(ctx);
			}
		};
		listener.exitS = new Callback1<context>()
		{
			@Override
			public void $invoke(context ctx)
			{
				me.processor.exitS(ctx);
				me.success.$invoke(true);
			}
		};
		listener.exitToken = new Callback1<context>()
		{

			@Override
			public void $invoke(context ctx)
			{
				me.processor.exitToken(ctx);
			}
		};
		listener.enterQuery = new Callback1<context>()
		{

			@Override
			public void $invoke(context ctx)
			{
				me.processor.enterQuery(ctx);
			}
		};
		listener.exitQuery = new Callback1<context>()
		{

			@Override
			public void $invoke(context ctx)
			{
				me.processor.exitQuery(ctx);
			}
		};
		listener.exitInnerquery = new Callback1<context>()
		{

			@Override
			public void $invoke(context ctx)
			{
				me.processor.exitInnerquery(ctx);
			}
		};
		listener.exitLogical_or_math_operator = new Callback1<context>()
		{

			@Override
			public void $invoke(context ctx)
			{
				me.processor.exitLogical_or_math_operator(ctx);
			}
		};
		parser.addParseListener(listener);

	}

	public void go()
	{
		processor.logFunction = logFunction;
		processor.success = success;
		processor.failure = failure;
		parser.s();
	}

}
