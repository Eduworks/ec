/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Mon Jul 29 11:33:20 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;

public class ItemInAllowedProductConfiguration extends EcRemoteLinkedData {

    protected Array<ItemInAllowedProductConfiguration.NonConf> nonConf;
    protected PartAsDesignedReference hwConfPartRef;
    protected AllowedProductConfigurationByConfigurationIdentifierReference prodConfRef;
    protected ItemInProductVariant.RangeEfys rangeEfys;
    protected ConditionInstance.Docs docs;
    protected ConditionInstance.Rmks rmks;
    protected String uid;
    protected CrudCodeValues crud;

    public Array<ItemInAllowedProductConfiguration.NonConf> getNonConf() {
        if (nonConf == null) {
            nonConf = new Array<ItemInAllowedProductConfiguration.NonConf>();
        }
        return this.nonConf;
    }

    public PartAsDesignedReference getHwConfPartRef() {
        return hwConfPartRef;
    }

    public void setHwConfPartRef(PartAsDesignedReference value) {
        this.hwConfPartRef = value;
    }

    public AllowedProductConfigurationByConfigurationIdentifierReference getProdConfRef() {
        return prodConfRef;
    }

    public void setProdConfRef(AllowedProductConfigurationByConfigurationIdentifierReference value) {
        this.prodConfRef = value;
    }

    public ItemInProductVariant.RangeEfys getRangeEfys() {
        return rangeEfys;
    }

    public void setRangeEfys(ItemInProductVariant.RangeEfys value) {
        this.rangeEfys = value;
    }

    public ConditionInstance.Docs getDocs() {
        return docs;
    }

    public void setDocs(ConditionInstance.Docs value) {
        this.docs = value;
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

    public static class NonConf {

        protected NonConformanceType nonConfType;
        protected NonConformanceDescription nonConfDescr;
        protected Array<NonConformanceRestriction> nonConfRestr;

        public NonConformanceType getNonConfType() {
            return nonConfType;
        }

        public void setNonConfType(NonConformanceType value) {
            this.nonConfType = value;
        }

        public NonConformanceDescription getNonConfDescr() {
            return nonConfDescr;
        }

        public void setNonConfDescr(NonConformanceDescription value) {
            this.nonConfDescr = value;
        }

        public Array<NonConformanceRestriction> getNonConfRestr() {
            if (nonConfRestr == null) {
                nonConfRestr = new Array<NonConformanceRestriction>();
            }
            return this.nonConfRestr;
        }

    }

	public ItemInAllowedProductConfiguration() {
		super("http://www.asd-europe.org/s-series/s3000l", "ItemInAllowedProductConfiguration");
	}

}