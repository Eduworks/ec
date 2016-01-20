package org.cassproject.schema.general;

import com.eduworks.ec.Blob.BlobHelper;

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
		Object blob = BlobHelper.base64ToBlob(data, mimeType);
		FileSaver.saveAs(blob, name);
	}

}
