package org.cassproject.ebac.identity;

import com.eduworks.ec.crypto.EcPk;

public class EcContact
{
	public EcPk pk;
	public String displayName;
	public String source;
	
	public String getImageUrl()
	{
		return "https://upload.wikimedia.org/wikipedia/commons/thumb/1/12/User_icon_2.svg/48px-User_icon_2.svg.png";
	}
}
