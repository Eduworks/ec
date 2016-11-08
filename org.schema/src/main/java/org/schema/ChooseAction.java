package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ChooseAction
 * The act of expressing a preference from a set of options or a large or unbounded set of choices/options.
 * @author schema.org
 * @class ChooseAction
 * @module org.schema
 * @extends AssessAction
 */
public class ChooseAction extends AssessAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ChooseAction()
	{
		context="http://schema.org/";
		type="ChooseAction";
	}

	/**
	 * Schema.org/actionOption
	 * A sub property of object. The options subject to this action.
	 * @property actionOption
	 * @type schema,Thing | schema,Text
	 */
	public Object actionOption;

	/**
	 * Schema.org/option
	 * A sub property of object. The options subject to this action.
	 * @property option
	 * @type schema,Thing | schema,Text
	 */
	public Object option;

}