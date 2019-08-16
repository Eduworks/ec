/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Mon Jul 29 11:33:18 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;

public class ApplicabilityEvaluationByAssertionOfSerializedItems extends EcRemoteLinkedData {

    protected ApplicableSerialNumberRange range;
    protected PartAsDesignedReference partRef;
    protected ProductReference prodRef;
    protected ProductVariantReference prodVarRef;
    protected ConditionInstance.Rmks rmks;
    protected String uid;
    protected CrudCodeValues crud;

    public ApplicableSerialNumberRange getRange() {
        return range;
    }

    public void setRange(ApplicableSerialNumberRange value) {
        this.range = value;
    }

    public PartAsDesignedReference getPartRef() {
        return partRef;
    }

    public void setPartRef(PartAsDesignedReference value) {
        this.partRef = value;
    }

    public ProductReference getProdRef() {
        return prodRef;
    }

    public void setProdRef(ProductReference value) {
        this.prodRef = value;
    }

    public ProductVariantReference getProdVarRef() {
        return prodVarRef;
    }

    public void setProdVarRef(ProductVariantReference value) {
        this.prodVarRef = value;
    }

    public ConditionInstance.Rmks getRmks() {
        return rmks;
    }

    public void setRmks(ConditionInstance.Rmks value) {
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

	public ApplicabilityEvaluationByAssertionOfSerializedItems() {
		super("http://www.asd-europe.org/s-series/s3000l", "ApplicabilityEvaluationByAssertionOfSerializedItems");
	}

}