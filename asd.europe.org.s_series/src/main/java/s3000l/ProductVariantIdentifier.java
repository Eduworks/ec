/**
 *
 * Generated by JaxbToStjsAssimilater.
 * Assimilation Date: Thu Aug 22 12:47:54 CDT 2019
 *
 **/

package s3000l;

import org.cassproject.schema.general.EcRemoteLinkedData;

public class ProductVariantIdentifier extends EcRemoteLinkedData {

    protected ProductVariantIdentifierClassValues clazz;
    protected OrganizationReference setBy;

    public ProductVariantIdentifierClassValues getClazz() {
        return clazz;
    }

    public void setClazz(ProductVariantIdentifierClassValues value) {
        this.clazz = value;
    }

    public OrganizationReference getSetBy() {
        return setBy;
    }

    public void setSetBy(OrganizationReference value) {
        this.setBy = value;
    }

	public ProductVariantIdentifier() {
		super("http://www.asd-europe.org/s-series/s3000l", "ProductVariantIdentifier");
	}

}
