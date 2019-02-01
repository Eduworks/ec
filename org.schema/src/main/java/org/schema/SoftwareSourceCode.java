package org.schema;

/**
 * Schema.org/SoftwareSourceCode
 * Computer programming source code. Example: Full (compile ready) solutions, code snippet samples, scripts, templates.
 *
 * @author schema.org
 * @class SoftwareSourceCode
 * @module org.schema
 * @extends CreativeWork
 */
public class SoftwareSourceCode extends CreativeWork {
	/**
	 * Schema.org/targetProduct
	 * Target Operating System / Product to which the code applies.  If applies to several versions, just the product name can be used.
	 *
	 * @property targetProduct
	 * @type SoftwareApplication
	 */
	public SoftwareApplication targetProduct;
	/**
	 * Schema.org/codeRepository
	 * Link to the repository where the un-compiled, human readable code and related code is located (SVN, github, CodePlex).
	 *
	 * @property codeRepository
	 * @type URL
	 */
	public String codeRepository;
	/**
	 * Schema.org/programmingLanguage
	 * The computer programming language.
	 *
	 * @property programmingLanguage
	 * @type Text
	 */
	public String programmingLanguage;
	/**
	 * Schema.org/codeSampleType
	 * What type of code sample: full (compile ready) solution, code snippet, inline code, scripts, template.
	 *
	 * @property codeSampleType
	 * @type Text
	 */
	public String codeSampleType;
	/**
	 * Schema.org/runtimePlatform
	 * Runtime platform or script interpreter dependencies (Example - Java v1, Python2.3, .Net Framework 3.0).
	 *
	 * @property runtimePlatform
	 * @type Text
	 */
	public String runtimePlatform;
	/**
	 * Schema.org/sampleType
	 * What type of code sample: full (compile ready) solution, code snippet, inline code, scripts, template.
	 *
	 * @property sampleType
	 * @type Text
	 */
	public String sampleType;
	/**
	 * Schema.org/runtime
	 * Runtime platform or script interpreter dependencies (Example - Java v1, Python2.3, .Net Framework 3.0).
	 *
	 * @property runtime
	 * @type Text
	 */
	public String runtime;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public SoftwareSourceCode() {
		context = "http://schema.org/";
		type = "SoftwareSourceCode";
	}

}