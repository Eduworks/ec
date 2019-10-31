package components;

import org.json.JSONArray;
import org.json.JSONObject;

public class WorkActivity extends NavyComponent {

    private static final String DC_TERMS_TYPE = "Work Activity";

    //private JSONArray parentWorkActivityIds  = new JSONArray();
    private JSONArray childWorkActivityIds  = new JSONArray();
    private JSONArray occupationalTaskIds  = new JSONArray();

    public WorkActivity(String externalSystemId, String externalShortId, String name, String description, String code) {
        super(externalSystemId,externalShortId,name,description,code);
    }

    @Override
    public String getDcTermsType() {return DC_TERMS_TYPE;}

//    public JSONArray getParentWorkActivityIds() {return parentWorkActivityIds;}
//    public void setParentWorkActivityIds(JSONArray parentWorkActivityIds) {this.parentWorkActivityIds = parentWorkActivityIds;}

    public JSONArray getChildWorkActivityIds() {return childWorkActivityIds;}
    public void setChildWorkActivityIds(JSONArray childWorkActivityIds) {this.childWorkActivityIds = childWorkActivityIds;}

    public JSONArray getOccupationalTaskIds() {return occupationalTaskIds;}
    public void setOccupationalTaskIds(JSONArray occupationalTaskIds) {this.occupationalTaskIds = occupationalTaskIds;}

    @Override
    public String toString() {
        return "**********************************\n" +
                "dcTermsType: '" + getDcTermsType() + "'\n" +
                "externalId: '" + getExternalSystemId() + "'\n" +
                "externalShortId: '" + getExternalShortId() + "'\n" +
                "name: '" + getName() + "'\n" +
                "childWorkActivities: " + getChildWorkActivityIds() + "\n" +
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
        jo.put("childWorkActivities",getChildWorkActivityIds());
        jo.put("occupationalTasks",getOccupationalTaskIds());
        return jo;
    }
}
