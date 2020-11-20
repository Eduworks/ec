package org.cassproject.ebac.identity;

import com.eduworks.ec.crypto.EcPk;
import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.ec.crypto.EcRsaOaep;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * The record used to request a rekey of a given public key
 */
public class EcRekeyRequest extends EcRemoteLinkedData {

    private static final String REKEY_ID_PREFIX = "rekey_";

    /**
     * PEM encoded public key of the replacement (new) key
     * @property rekeyPk
     * @type string (PEM)
     */
    private String rekeyPk;

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
    public void generateRekeyRequestId(String server, EcPk oldKeyPk) {
        assignId(server, oldKeyPk.fingerprint());
    }

    /**
     * Adds a signature to the rekey request and finalizes before save
     *
     * {EcPpk   oldKeyPpk    The old PPK
     * @method generateRekeyRequestId
     */
    public void finalizeRequest(EcPpk oldKeyPpk) {
        rekeySignature = EcRsaOaep.signSha256(oldKeyPpk,this.toSignableJson());
    }

    /**
     * Constructor, automatically sets @context and @type.
     *
     * @constructor
     */
    public EcRekeyRequest(EcPk oldKey, EcPk newKey) {
        super("https://schema.cassproject.org/0.4/kbac", "RekeyRequest");
        this.addOwner(oldKey);
        rekeyPk = newKey.toPem();
    }
}
