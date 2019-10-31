package components;

import org.json.JSONArray;
import org.json.JSONObject;

public class JobFamily extends NavyComponent {

    private static final String DC_TERMS_TYPE = "Job Family";

    private JSONArray ratingIds  = new JSONArray();

    public JobFamily(String externalSystemId, String externalShortId, String name, String description, String code) {
        super(externalSystemId,externalShortId,name,description,code);
    }

    @Override
    public String getDcTermsType() {return DC_TERMS_TYPE;}

    public JSONArray getRatingIds() {return ratingIds;}
    public void setRatingIds(JSONArray ratingIds) {this.ratingIds = ratingIds;}

    @Override
    public String toString() {
        return "**********************************\n" +
                "dcTermsType: '" + getDcTermsType() + "'\n" +
                "externalId: '" + getExternalSystemId() + "'\n" +
                "externalShortId: '" + getExternalShortId() + "'\n" +
                "name: '" + getName() + "'\n" +
                "ratings: " + getRatingIds();
    }

    @Override
    @SuppressWarnings("Duplicates")
    public JSONObject toJson() {
        JSONObject jo = new JSONObject();
        jo.put("dcTermsType",getDcTermsType());
        jo.put("externalId",getExternalSystemId());
        jo.put("externalShortId",getExternalShortId());
        jo.put("name",getName());
        jo.put("ratings",getRatingIds());
        return jo;
    }
}
