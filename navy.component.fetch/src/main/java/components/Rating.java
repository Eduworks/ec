package components;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Rating extends NavyComponent {

    private static final String DC_TERMS_TYPE = "Rating";

    private List<Job> jobs = new ArrayList<>();
    private List<Nec> necs = new ArrayList<>();

    public Rating(String externalSystemId, String externalShortId, String name, String description, String code) {
        super(externalSystemId,externalShortId,name,description,code);
    }

    public List<Job> getJobs() {return jobs;}
    public void setJobs(List<Job> jobs) {this.jobs = jobs;}

    public List<Nec> getNecs() {return necs;}
    public void setNecs(List<Nec> necs) {this.necs = necs;}

    public void addJob(Job job) {getJobs().add(job);}

    public void addNec(Nec nec) {getNecs().add(nec);}

    public String getDcTermsType() {return DC_TERMS_TYPE;}

    @Override
    public String toString() {
        String s = super.toString();
        s += "\n" + "Jobs: " + getJobs().size() + "\n" +
                "NECs: " + getNecs().size();
        return s;
    }

    @Override
    public JSONObject toJson() {
        JSONObject jo = super.toJson();
        JSONArray jobArray = new JSONArray();
        for (Job j:getJobs()) {
            jobArray.put(j.getExternalSystemId());
        }
        JSONArray necArray = new JSONArray();
        for (Nec n:getNecs()) {
            necArray.put(n.getExternalSystemId());
        }
        jo.put("jobs",jobArray);
        jo.put("necs",necArray);
        return jo;
    }


}
