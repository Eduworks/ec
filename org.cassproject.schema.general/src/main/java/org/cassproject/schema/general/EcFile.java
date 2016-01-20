package org.cassproject.schema.general;

import org.json.ld.EcLinkedData;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.dom.Document;
import org.stjs.javascript.dom.Element;

public class EcFile extends EcRemoteLinkedData
{

	public static final String type = "http://schema.eduworks.com/general/0.1/file";

	public EcFile()
	{
		super(General.schema, type);
	}

	public String checksum;
	public String mimeType;
	/***
	 * This field will be empty in search results, but be populated in a direct
	 * get.
	 */
	public String data;
	public String name;

	public void download()
	{
		Document document = Global.window.document;
	    Element pom = document.createElement("a");
	    pom.setAttribute("href", "data:text/plain;base64," + data);
	    pom.setAttribute("download", name);

        JSObjectAdapter.$js("pom.click()");
	}
}
