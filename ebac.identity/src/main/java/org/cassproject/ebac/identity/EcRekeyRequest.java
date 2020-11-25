package org.cassproject.ebac.identity;

import com.eduworks.ec.crypto.EcPk;
import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.ec.crypto.EcRsaOaep;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.json.ld.EcLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSGlobal;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Function0;

/**
 * The record used to request a rekey of a given public key
 */
public class EcRekeyRequest extends EcRemoteLinkedData {

    public static final String REKEY_ID_PREFIX = "rekey_";

    /**
     * PEM encoded public key of the replacement (new) key
     * @property rekeyPk
     * @type string (PEM)
     */
    public String rekeyPk;

    /**
     * SHA256 signature of the rekey request
     * @property rekeySignature
     * @type string (SHA256 signature)
     */
    private String rekeySignature;

    /**
     * Generates the ID of the rekey request in the appropriate format
     *
     * {string} server      Base URL of the server's repository functionality.
     * {EcPk}   oldKeyPk    The public key to replace
     * @method generateRekeyRequestId
     */
    private void generateRekeyRequestId(String server, EcPk oldKeyPk) {
        assignId(server, REKEY_ID_PREFIX+oldKeyPk.fingerprint());
    }

    /**
     * Adds a signature to the rekey request and finalizes before save
     *
     * {EcPpk}  oldKeyPpk   The old PPK
     * @method generateRekeyRequestId
     */
    private void finalizeRequest(EcPpk oldKeyPpk) {
        rekeySignature = EcRsaOaep.signSha256(oldKeyPpk,this.toSignableJson());
    }

    /**
     * Generates and populates a rekey request with the given information
     *
     * {String} server  Base URL of the server's repository functionality.
     * {EcPpk}  oldKey  The old PPK
     * {EcPpk}  newKey  The new PPK
     * @method generateRekeyRequest
     */
    public static EcRekeyRequest generateRekeyRequest(String server, EcPpk oldKey, EcPpk newKey) {
        EcRekeyRequest err = new EcRekeyRequest();
        err.addOwner(newKey.toPk());
        err.rekeyPk = oldKey.toPk().toPem();
        err.generateRekeyRequestId(server, oldKey.toPk());
        err.finalizeRequest(oldKey);
        return err;
    }

    /**
     * Constructor, automatically sets @context and @type.
     *
     * @constructor
     */
    public EcRekeyRequest() {
        super("https://schema.cassproject.org/0.4/kbac", "RekeyRequest");
    }

    /**
     * Encodes the object in a form where it is ready to be signed.
     * This method is under long term review, and may change from version to version.
     *
     * @return ASCII-sort order encoded space-free and tab-free JSON-LD.
     * @method toSignableJson
     */
    public String toSignableRekeyJson() {
        EcLinkedData d = (EcLinkedData) JSGlobal.JSON.parse(super.toSignableJson());
        JSObjectAdapter.$properties(d).$delete("rekeySignature");
        EcLinkedData e = new EcLinkedData(d.context, d.type);
        e.copyFrom(d);
        return e.toJson();
    }

    /**
     * Verifies both the integrity of the rekey request and the signed nonce of the old key. Returns false if either of these fail.
     * @return True if the rekey request is valid and maintains its cryptographically integrity.
     */
    public boolean verify()
    {
        if (!super.verify())
            return false;
        return EcRsaOaep.verifySha256(EcPk.fromPem(this.rekeyPk), toSignableRekeyJson(), this.rekeySignature);
    }

    public void addRekeyRequestToForwardingTable()
    {
        if (!verify())
            return;
        if (owner != null)
            EcRemoteLinkedData.forwardKey(rekeyPk,owner.$get(0));
    }

}
