/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Aug 22 12:47:53 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;

public class ItemInProductVariant extends EcRemoteLinkedData {

    protected ProductVariantReference prodVarRef;
    protected ItemInProductVariant.RangeEfys rangeEfys;
    protected s3000l.ConditionInstance.Rmks rmks;
    protected String uid;
    protected CrudCodeValues crud;

    public ProductVariantReference getProdVarRef() {
        return prodVarRef;
    }

    public void setProdVarRef(ProductVariantReference value) {
        this.prodVarRef = value;
    }

    public ItemInProductVariant.RangeEfys getRangeEfys() {
        return rangeEfys;
    }

    public void setRangeEfys(ItemInProductVariant.RangeEfys value) {
        this.rangeEfys = value;
    }

    public s3000l.ConditionInstance.Rmks getRmks() {
        return rmks;
    }

    public void setRmks(s3000l.ConditionInstance.Rmks value) {
        this.rmks = value;
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

    public static class RangeEfys {

        protected Array<ApplicableSerialNumberRange> efy;

        public Array<ApplicableSerialNumberRange> getEfy() {
            if (efy == null) {
                efy = new Array<ApplicableSerialNumberRange>();
            }
            return this.efy;
        }

    }

	public ItemInProductVariant() {
		super("http://www.asd-europe.org/s-series/s3000l", "ItemInProductVariant");
	}

}
