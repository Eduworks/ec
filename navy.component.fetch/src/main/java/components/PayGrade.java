package components;

import org.json.JSONArray;
import org.json.JSONObject;

public class PayGrade extends NavyComponent {

    private static final String DC_TERMS_TYPE = "Pay Grade";

    private JSONArray occupationalTaskIds  = new JSONArray();

    public PayGrade(String externalSystemId, String externalShortId, String name, String description, String code) {
        super(externalSystemId,externalShortId,name,description,code);
    }

    @Override
    public String getDcTermsType() {return DC_TERMS_TYPE;}

    public JSONArray getOccupationalTaskIds() {return occupationalTaskIds;}
    public void setOccupationalTaskIds(JSONArray occupationalTaskIds) {this.occupationalTaskIds = occupationalTaskIds;}

    @Override
    public String toString() {
        return "**********************************\n" +
                "dcTermsType: '" + getDcTermsType() + "'\n" +
                "externalId: '" + getExternalSystemId() + "'\n" +
                "externalShortId: '" + getExternalShortId() + "'\n" +
                "name: '" + getName() + "'\n" +
                "occupationalTasks: " + getOccupationalTaskIds();
    }

    @Override
    @SuppressWarnings("Duplicates")
    public JSONObject toJson() {
        JSONObject jo = new JSONObject();
        jo.put("dcTermsType",getDcTermsType());
        jo.put("externalId",getExternalSystemId());
        jo.put("externalShortId",getExternalShortId());
        jo.put("name",getName());
        jo.put("code",getCode());
        jo.put("occupationalTasks",getOccupationalTaskIds());
        return jo;
    }
}
