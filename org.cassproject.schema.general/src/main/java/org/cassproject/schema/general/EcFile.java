package org.cassproject.schema.general;

import com.eduworks.ec.blob.BlobHelper;

/**
 * A representation of a file.
 * 
 * @author fritz.ray@eduworks.com
 *
 */
public class EcFile extends EcRemoteLinkedData
{
	public static final String type = "http://schema.eduworks.com/general/0.2/file";

	public EcFile()
	{
		super(General.context, type);
	}

	/**
	 * Optional checksum of the file, used to verify if the file has been
	 * transmitted correctly.
	 */
	public String checksum;
	/**
	 * Mime type of the file.
	 */
	public String mimeType;
	/**
	 * Base-64 encoded version of the bytestream of a file.
	 * 
	 * Please note: This field will be empty in search results, but be populated
	 * in a direct get.
	 */
	public String data;
	/**
	 * Name of the file.
	 */
	public String name;

	/**
	 * Helper method to force the browser to download the file.
	 */
	public void download()
	{
		Object blob = BlobHelper.base64ToBlob(data, mimeType);
		FileSaver.saveAs(blob, name);
	}

}
