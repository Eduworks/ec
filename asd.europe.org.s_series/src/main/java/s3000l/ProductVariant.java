/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Aug 22 12:47:54 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;

public class ProductVariant extends EcRemoteLinkedData {

    protected Array<ProductVariantIdentifier> prodVarId;
    protected Array<ProductVariantName> name;
    protected Array<Object> allowedProductConfigurationInterfaceRealizedBy;
    protected Array<NestedProductVariantRelationship> nestedPV;
    protected ProductVariant.Bkdns bkdns;
    protected s3000l.DownTime.OrgInfos orgInfos;
    protected s3000l.ConditionInstance.Docs docs;
    protected s3000l.ConditionInstance.Rmks rmks;
    protected String uid;
    protected CrudCodeValues crud;

    public Array<ProductVariantIdentifier> getProdVarId() {
        if (prodVarId == null) {
            prodVarId = new Array<ProductVariantIdentifier>();
        }
        return this.prodVarId;
    }

    public Array<ProductVariantName> getName() {
        if (name == null) {
            name = new Array<ProductVariantName>();
        }
        return this.name;
    }

    public Array<Object> getAllowedProductConfigurationInterfaceRealizedBy() {
        if (allowedProductConfigurationInterfaceRealizedBy == null) {
            allowedProductConfigurationInterfaceRealizedBy = new Array<Object>();
        }
        return this.allowedProductConfigurationInterfaceRealizedBy;
    }

    public Array<NestedProductVariantRelationship> getNestedPV() {
        if (nestedPV == null) {
            nestedPV = new Array<NestedProductVariantRelationship>();
        }
        return this.nestedPV;
    }

    public ProductVariant.Bkdns getBkdns() {
        return bkdns;
    }

    public void setBkdns(ProductVariant.Bkdns value) {
        this.bkdns = value;
    }

    public s3000l.DownTime.OrgInfos getOrgInfos() {
        return orgInfos;
    }

    public void setOrgInfos(s3000l.DownTime.OrgInfos value) {
        this.orgInfos = value;
    }

    public s3000l.ConditionInstance.Docs getDocs() {
        return docs;
    }

    public void setDocs(s3000l.ConditionInstance.Docs value) {
        this.docs = value;
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

    public static class Bkdns {

        protected Array<Breakdown> bkdn;

        public Array<Breakdown> getBkdn() {
            if (bkdn == null) {
                bkdn = new Array<Breakdown>();
            }
            return this.bkdn;
        }

    }

	public ProductVariant() {
		super("http://www.asd-europe.org/s-series/s3000l", "ProductVariant");
	}

}
