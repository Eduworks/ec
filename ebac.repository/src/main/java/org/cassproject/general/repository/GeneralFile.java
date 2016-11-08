package org.cassproject.general.repository;

import org.cassproject.schema.general.EcRemoteLinkedData;
import org.cassproject.schema.general.FileSaver;
import org.cassproject.schema.general.General;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;

import com.eduworks.ec.blob.BlobHelper;

/**
 * A representation of a file.
 * 
 * @module com.eduworks.ec
 * @class GeneralFile
 * @extends EcRemoteLinkedData
 * @constructor
 * 
 * @author fritz.ray@eduworks.com
 */
public class GeneralFile extends EcRemoteLinkedData
{
	private static final String TYPE_0_1 = "http://schema.eduworks.com/general/0.1/file";
	private static final String TYPE_0_2 = "http://schema.eduworks.com/general/0.2/file";
	public static final String myType = TYPE_0_2;

	public GeneralFile()
	{
		super(General.context, myType);
	}

	/**
	 * Optional checksum of the file, used to verify if the file has been
	 * transmitted correctly.
	 * 
	 * @property checksum
	 * @type String
	 */
	public String checksum;
	
	/**
	 * Mime type of the file.
	 * 
	 * @property mimeType
	 * @type String
	 */
	public String mimeType;
	
	/**
	 * Base-64 encoded version of the bytestream of a file.
	 * 
	 * @property data
	 * @type String
	 */
	public String data;

	/**
	 * Name of the file, used to distinguish it
	 * 
	 * @property name
	 * @type String
	 */
	public String name;
	
	/**
	 * Helper method to force the browser to download the file.
	 * 
	 * @memberOf GeneralFile
	 * @method download
	 */
	public void download()
	{
		Object blob = BlobHelper.base64ToBlob(data, mimeType);
		FileSaver.saveAs(blob, name);
	}

	@Override
	protected void upgrade()
	{
		super.upgrade();
		if (TYPE_0_1.equals(type))
		{
			Map<String, Object> me = JSObjectAdapter.$properties(this);
			// Error in older versions of LD objects: We used @schema instead of
			// @context. Whoops.
			if (me.$get("@context") == null && me.$get("@schema") != null)
				me.$put("@context", me.$get("@schema"));
			setContextAndType(General.context_0_2,TYPE_0_2);
		}
	}

	@Override
	public Array<String> getTypes()
	{
		Array<String> a = new Array<String>();
		a.push(TYPE_0_2);
		a.push(TYPE_0_1);
		return a;
	}
}
