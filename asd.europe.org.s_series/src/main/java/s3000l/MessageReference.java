/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Aug 22 12:47:54 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;

public class MessageReference extends EcRemoteLinkedData {

    protected MessageIdentifier msgId;
    protected Object uidRef;

    public MessageIdentifier getMsgId() {
        return msgId;
    }

    public void setMsgId(MessageIdentifier value) {
        this.msgId = value;
    }

    public Object getUidRef() {
        return uidRef;
    }

    public void setUidRef(Object value) {
        this.uidRef = value;
    }

	public MessageReference() {
		super("http://www.asd-europe.org/s-series/s3000l", "MessageReference");
	}

}
