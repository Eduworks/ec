/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Mon Jul 29 11:33:20 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;

public class MessageRelationship extends EcRemoteLinkedData {

    protected MessageRelationshipType relType;
    protected MessageReference msgRef;
    protected String uid;
    protected CrudCodeValues crud;

    public MessageRelationshipType getRelType() {
        return relType;
    }

    public void setRelType(MessageRelationshipType value) {
        this.relType = value;
    }

    public MessageReference getMsgRef() {
        return msgRef;
    }

    public void setMsgRef(MessageReference value) {
        this.msgRef = value;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String value) {
        this.uid = value;
    }

    public CrudCodeValues getCrud() {
        if (crud == null) {
            return CrudCodeValues.I;
        } else {
            return crud;
        }
    }

    public void setCrud(CrudCodeValues value) {
        this.crud = value;
    }

	public MessageRelationship() {
		super("http://www.asd-europe.org/s-series/s3000l", "MessageRelationship");
	}

}