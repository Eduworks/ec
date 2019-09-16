package components;

import org.json.JSONObject;

public class Skill extends NavyComponent {

    private static final String DC_TERMS_TYPE = "Skill";

    public Skill(String externalSystemId, String externalShortId, String name, String description, String code) {
        super(externalSystemId,externalShortId,name,description,code);
    }

    public String getDcTermsType() {return DC_TERMS_TYPE;}

    @Override
    public String toString() {
        return "**********************************\n" +
                "dcTermsType: '" + getDcTermsType() + "'\n" +
                "externalId: '" + getExternalSystemId() + "'\n" +
                "externalShortId: '" + getExternalShortId() + "'\n" +
                "name: '" + getName() + "'";
    }

    @Override
    @SuppressWarnings("Duplicates")
    public JSONObject toJson() {
        JSONObject jo = new JSONObject();
        jo.put("dcTermsType",getDcTermsType());
        jo.put("externalId",getExternalSystemId());
        jo.put("externalShortId",getExternalShortId());
        jo.put("name",getName());
        return jo;
    }

}
