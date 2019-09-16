package components;

public class Nec extends NavyComponent {

    private static final String DC_TERMS_TYPE = "NEC";

    public Nec(String externalSystemId, String externalShortId, String name, String description, String code) {
        super(externalSystemId,externalShortId,name,description,code);
    }

    public String getDcTermsType() {return DC_TERMS_TYPE;}

}
