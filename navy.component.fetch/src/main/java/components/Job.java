package components;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Job extends NavyComponent {

    private static final String DC_TERMS_TYPE = "Job";

    private List<OccupationalTask> occupationalTasks = new ArrayList<>();

    private JSONArray occupationalTaskIds = new JSONArray();

    public Job(String externalSystemId, String externalShortId, String name, String description, String code) {
        super(externalSystemId,externalShortId,name,description,code);
    }

    public JSONArray getOccupationalTaskIds() {return occupationalTaskIds;}
    public void setOccupationalTaskIds(JSONArray occupationalTaskIds) {this.occupationalTaskIds = occupationalTaskIds;}

    public List<OccupationalTask> getOccupationalTasks() {return occupationalTasks;}
    public void setOccupationalTasks(List<OccupationalTask> occupationalTasks) {this.occupationalTasks = occupationalTasks;}

    public void addOccupationalTask(OccupationalTask occupationalTask) {getOccupationalTasks().add(occupationalTask);}

    public String getDcTermsType() {return DC_TERMS_TYPE;}

    @Override
    public String toString() {
        String s = super.toString();
        s += "\n" + "OccupationalTaskIds: " + getOccupationalTaskIds().toString() + "\n" +
                "OccupationalTasks: " + getOccupationalTasks().size();
        return s;
    }

//    @Override
//    public JSONObject toJson() {
//        JSONObject jo = super.toJson();
//        JSONArray skillArray = new JSONArray();
//        JSONArray abilityArray = new JSONArray();
//        for (OccupationalTask ot:getOccupationalTasks()) {
//            for (Skill s: ot.getSkills()) {
//                skillArray.put(s.getExternalSystemId());
//            }
//            for (Ability a: ot.getAbilities()) {
//                abilityArray.put(a.getExternalSystemId());
//            }
//        }
//        jo.put("skills",skillArray);
//        jo.put("abilities",abilityArray);
//        return jo;
//    }

    @Override
    public JSONObject toJson() {
        JSONObject jo = super.toJson();
        JSONArray otArray = new JSONArray();
        for (OccupationalTask ot:getOccupationalTasks()) {
            otArray.put(ot.getExternalSystemId());
        }
        jo.put("occupationalTasks",otArray);
        return jo;
    }
}
