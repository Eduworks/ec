package fetcher;

import components.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class NavyComponentFetcher {

    private static final boolean LOG_ENABLED = true;

    private static final String KEYWORD_QUERY_URL = "https://credreg.net/NavyARTT/NavyGraph/KeywordQuery";
    private static final String REVERSE_LINK_QUERY_URL = "https://credreg.net/NavyARTT/NavyGraph/ReverseLinkQuery";
    private static final String ENTITY_LOOKUP_QUERY_URL_PREFIX = "https://credreg.net/NavyARTT/navygraph/resources/";
    private static final String USER_AGENT = "Mozilla/5.0";

    private static final String OUTPUT_ROOT_DIR = "E:\\TomsWork\\CurrentProjects\\ARTT\\";
    private static final String ABILITIES_OUTPUT_FILE_PREFIX = OUTPUT_ROOT_DIR + "testNavyComponentFetcher_ABILITIES_";
    private static final String SKILLS_OUTPUT_FILE_PREFIX = OUTPUT_ROOT_DIR + "testNavyComponentFetcher_SKILLS_";
    private static final String OTS_OUTPUT_FILE_PREFIX = OUTPUT_ROOT_DIR + "testNavyComponentFetcher_OCCTASKS_";
    private static final String JOBS_OUTPUT_FILE_PREFIX = OUTPUT_ROOT_DIR + "testNavyComponentFetcher_JOBS_";
    private static final String NECS_OUTPUT_FILE_PREFIX = OUTPUT_ROOT_DIR + "testNavyComponentFetcher_NECS_";
    private static final String RATINGS_OUTPUT_FILE_PREFIX = OUTPUT_ROOT_DIR + "testNavyComponentFetcher_RATINGS_";

    private static final boolean ONLY_FIRST_RATING = false; //for testing stuff

    private List<Rating> navyRatingList = new ArrayList<>();
    private HashMap<String, Nec> navyNecMap = new HashMap<>();
    private HashMap<String, Job> navyJobMap = new HashMap<>();
    private HashMap<String, Skill> navySkillMap = new HashMap<>();
    private HashMap<String, Ability> navyAbilityMap = new HashMap<>();
    private HashMap<String, OccupationalTask> navyOccupationalTaskMap = new HashMap<>();

    public List<Rating> getNavyRatingList() {return navyRatingList;}
    public void setNavyRatingList(List<Rating> navyRatingList) {this.navyRatingList = navyRatingList;}

    public HashMap<String, Nec> getNavyNecMap() {return navyNecMap;}
    public void setNavyNecMap(HashMap<String, Nec> navyNecMap) {this.navyNecMap = navyNecMap;}

    public HashMap<String, Job> getNavyJobMap() {return navyJobMap;}
    public void setNavyJobMap(HashMap<String, Job> navyJobMap) {this.navyJobMap = navyJobMap;}

    public HashMap<String, Skill> getNavySkillMap() {return navySkillMap;}
    public void setNavySkillMap(HashMap<String, Skill> navySkillMap) {this.navySkillMap = navySkillMap;}

    public HashMap<String, Ability> getNavyAbilityMap() {return navyAbilityMap;}
    public void setNavyAbilityMap(HashMap<String, Ability> navyAbilityMap) {this.navyAbilityMap = navyAbilityMap;}

    public HashMap<String, OccupationalTask> getNavyOccupationalTaskMap() {return navyOccupationalTaskMap;}
    public void setNavyOccupationalTaskMap(HashMap<String, OccupationalTask> navyOccupationalTaskMap) {this.navyOccupationalTaskMap = navyOccupationalTaskMap;}

    private void log(Object o) {
        if (LOG_ENABLED) {
            Calendar cal = Calendar.getInstance();
            System.out.println(cal.getTime().toString() + ": " + o.toString());
        }
    }

    private void logRatings() {
        log("*********************************RATINGS**********************************");
        for (Rating r:getNavyRatingList()) {
            log(r.toString());
        }
    }

    private void logJobs() {
        log("*********************************JOBS**********************************");
        Set<String> keys = getNavyJobMap().keySet();
        for (String key: keys) {
            log(getNavyJobMap().get(key).toString());
        }
    }

    private void logSkills() {
        log("*********************************SKILLS**********************************");
        Set<String> keys = getNavySkillMap().keySet();
        for (String key: keys) {
            log(getNavySkillMap().get(key).toString());
        }
    }

    private void logAbilities() {
        log("*********************************ABILITIES**********************************");
        Set<String> keys = getNavyAbilityMap().keySet();
        for (String key: keys) {
            log(getNavyAbilityMap().get(key).toString());
        }
    }

    private void logNecs() {
        log("*********************************NECS**********************************");
        Set<String> keys = getNavyNecMap().keySet();
        for (String key: keys) {
            log(getNavyNecMap().get(key).toString());
        }
    }

    private void logOccupationalTasks() {
        log("*********************************OCCUPATIONAL TASKS**********************************");
        Set<String> keys = getNavyOccupationalTaskMap().keySet();
        for (String key: keys) {
            log(getNavyOccupationalTaskMap().get(key).toString());
        }
    }

    private String getShortIdFromExternalId(String externalId) {
        return externalId.substring(externalId.lastIndexOf("/") + 1);
    }

    private String executeEntityLookup(String entityId) throws Exception {
        URL url = new URL(ENTITY_LOOKUP_QUERY_URL_PREFIX + entityId);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        if (con.getResponseCode() != 200) return "{}";
        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String responseLine;
        StringBuffer response = new StringBuffer();
        while ((responseLine = br.readLine()) != null) {
            response.append(responseLine);
        }
        br.close();
        return response.toString();
    }

    private String executePostQuery(JSONObject requestJson, String queryUrl) throws Exception {
        URL url = new URL (queryUrl);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
        String requestJsonString = requestJson.toString();
        OutputStream os = con.getOutputStream();
        byte[] input = requestJsonString.getBytes("utf-8");
        os.write(input, 0, input.length);
        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
        StringBuilder response = new StringBuilder();
        String responseLine = null;
        while ((responseLine = br.readLine()) != null) {
            response.append(responseLine.trim());
        }
        br.close();
        return response.toString();
    }

    private String executeKeywordQuery(JSONObject requestJson) throws Exception {
        return executePostQuery(requestJson,KEYWORD_QUERY_URL);
    }

    private String executeReverseLinkQuery(JSONObject requestJson) throws Exception {
        return executePostQuery(requestJson,REVERSE_LINK_QUERY_URL);
    }

    private void parseRatingQueryResponseObject(JSONObject ratingObject) throws Exception {
        Rating r = new Rating(
                ratingObject.getString("@id"),
                ratingObject.getString("ceterms:ctid"),
                ratingObject.getString("schema:name"),
                null,
                ratingObject.getString("ceasn:codedNotation")
        );
        getNavyRatingList().add(r);
    }

    private void parseRatingQueryResponse(String ratingQueryResponse) throws Exception {
        log("Parsing rating query response...");
        JSONObject ro = new JSONObject(ratingQueryResponse);
        if (ro.has("data")) {
            JSONArray ra = ro.getJSONArray("data");
            log("Parsing ratings: " + ra.length() + "...");
            for (int i = 0;i<ra.length();i++) {
                parseRatingQueryResponseObject(ra.getJSONObject(i));
                if (ONLY_FIRST_RATING) break;
            }
            log("Ratings generated: " + getNavyRatingList().size() + " out of " + ra.length());
        }
        else {
            log("!!No rating data found!!");
        }
    }

    private void fetchRatingList() throws Exception {
        log("Fetching rating list...");
        getNavyRatingList().clear();
        JSONObject ratingsJo = new JSONObject();
        JSONObject queryJo = new JSONObject();
        queryJo.put("dataSource","Ratings");
        queryJo.put("keywords","");
        ratingsJo.put("query",queryJo);
        String ratingQueryResponse = executeKeywordQuery(ratingsJo);
        //log("Rating query response: " + ratingQueryResponse);
        parseRatingQueryResponse(ratingQueryResponse);
        log("Ratings generated: " + getNavyRatingList().size());
    }

    private JSONObject generateReverseLinkQueryRequestObject(String dataSource, String pointsToId, String property) {
        JSONObject ro = new JSONObject();
        ro.put("dataSource",dataSource);
        ro.put("pointsToID",pointsToId);
        ro.put("property",property);
        return ro;
    }

    private JSONObject generateNecRequestObjectForRating(Rating rating) {
        return generateReverseLinkQueryRequestObject("NECCodes",rating.getExternalSystemId(),"navy:hasRating");
    }

    private JSONObject generateJobRequestObjectForRating(Rating rating) {
        return generateReverseLinkQueryRequestObject("Jobs",rating.getExternalSystemId(),"navy:hasRating");
    }

    private Job getOrGenerateJob(JSONObject ratingJobObject) {
        String jobId = ratingJobObject.getString("ceterms:ctid");
        Job j = getNavyJobMap().get(jobId);
        if (j == null) {
            j = new Job(
                    ratingJobObject.getString("@id"),
                    ratingJobObject.getString("ceterms:ctid"),
                    ratingJobObject.getString("schema:name"),
                    ratingJobObject.getString("schema:description"),
                    ratingJobObject.getString("ceasn:codedNotation")
            );
            if (ratingJobObject.has("navy:hasOccupationalTask")) {
                j.setOccupationalTaskIds(ratingJobObject.getJSONArray("navy:hasOccupationalTask"));
            }
            getNavyJobMap().put(jobId,j);
        }
        return j;
    }

    private void parseAndProcessRatingJobResponse(String ratingJobResponseString, Rating r) throws Exception {
        log("Parsing rating job query response...");
        JSONObject ro = new JSONObject(ratingJobResponseString);
        if (ro.has("data")) {
            JSONArray rja = ro.getJSONArray("data");
            log("Parsing rating jobs: " + rja.length() + "...");
            for (int i = 0;i<rja.length();i++) {
                r.addJob(getOrGenerateJob(rja.getJSONObject(i)));
            }
        }
        else {
            log("!!No rating job data found!!");
        }
    }

    private void fetchRatingJobList() throws Exception {
        log("Fetching rating job list...");
        getNavyJobMap().clear();
        Rating r;
        for (int i=0;i<getNavyRatingList().size();i++) {
            r = getNavyRatingList().get(i);
            String ratingJobResponseString = executeReverseLinkQuery(generateJobRequestObjectForRating(r));
            parseAndProcessRatingJobResponse(ratingJobResponseString,r);
        }
        log("Jobs generated: " + getNavyJobMap().keySet().size());
    }

    private Nec getOrGenerateNec(JSONObject ratingNecObject) {
        String necId = ratingNecObject.getString("ceterms:ctid");
        Nec n = getNavyNecMap().get(necId);
        if (n == null) {
            n = new Nec(
                    ratingNecObject.getString("@id"),
                    ratingNecObject.getString("ceterms:ctid"),
                    ratingNecObject.getString("schema:name"),
                    null,
                    ratingNecObject.getString("navy:codeNEC")
            );
            if (ratingNecObject.has("schema:description")) {
                n.setDescription(ratingNecObject.getString("schema:description"));
            }
            getNavyNecMap().put(necId,n);
        }
        return n;
    }

    private void parseAndProcessRatingNecResponse(String ratingNecResponseString, Rating r) throws Exception {
        log("Parsing rating NEC query response...");
        JSONObject ro = new JSONObject(ratingNecResponseString);
        if (ro.has("data")) {
            JSONArray rna = ro.getJSONArray("data");
            log("Parsing rating NECs: " + rna.length() + "...");
            for (int i = 0;i<rna.length();i++) {
                r.addNec(getOrGenerateNec(rna.getJSONObject(i)));
            }
        }
        else {
            log("!!No rating NEC data found!!");
        }
    }

    private void fetchRatingNecList() throws Exception {
        log("Fetching rating NEC list...");
        getNavyNecMap().clear();
        Rating r;
        for (int i=0;i<getNavyRatingList().size();i++) {
            r = getNavyRatingList().get(i);
            String ratingNecResponseString = executeReverseLinkQuery(generateNecRequestObjectForRating(r));
            parseAndProcessRatingNecResponse(ratingNecResponseString,r);
        }
        log("NECs generated: " + getNavyNecMap().keySet().size());
    }

    private void parseAndAddOccupationalTask(JSONObject otObject, String otId) throws Exception {
        OccupationalTask ot = new OccupationalTask(
            otObject.getString("@id"),
            otObject.getString("ceterms:ctid"),
            otObject.getString("navy:taskText"),
            null,
            otObject.getString("ceasn:codedNotation")
        );
        if (otObject.has("ceasn:abilityEmbodied")) {
            ot.setAbilityIds(otObject.getJSONArray("ceasn:abilityEmbodied"));
        }
        if (otObject.has("ceasn:skillEmbodied")) {
            ot.setSkillIds(otObject.getJSONArray("ceasn:skillEmbodied"));
        }
        getNavyOccupationalTaskMap().put(otId,ot);
    }

    private void fetchJobOccupationalTasks(Job j) throws Exception {
        log("Fetching job occupational tasks...");
        String otId;
        boolean validOt = false;
        for (int i=0;i<j.getOccupationalTaskIds().length();i++) {
            otId = getShortIdFromExternalId(j.getOccupationalTaskIds().getString(i));
            validOt = false;
            if (!getNavyOccupationalTaskMap().containsKey(otId)) {
                String jobOTResponseString = executeEntityLookup(otId);
                JSONObject jotJo = new JSONObject(jobOTResponseString);
                if (jotJo.has("@id")) {
                    parseAndAddOccupationalTask(jotJo,otId);
                    validOt = true;
                }
            }
            else validOt = true;
            if (validOt) {
                j.addOccupationalTask(getNavyOccupationalTaskMap().get(otId));
            }
        }
    }

    private void fetchJobOccupationalTaskList() throws Exception {
        log("Fetching job occupational task list...");
        getNavyOccupationalTaskMap().clear();
        Job j;
        Set<String> jobKeys = getNavyJobMap().keySet();
        for (String key:jobKeys) {
            j = getNavyJobMap().get(key);
            fetchJobOccupationalTasks(j);
        }
        log("Occupational Tasks generated: " + getNavyOccupationalTaskMap().keySet().size());
    }

    private void parseAndAddSkill(JSONObject skillObject, String skillId) throws Exception {
        Skill s = new Skill(
            skillObject.getString("@id"),
            skillObject.getString("ceterms:ctid"),
            skillObject.getString("ceasn:competencyText"),
            null,
            null
        );
        getNavySkillMap().put(skillId,s);
    }

    private void fetchOccupationalTaskSkills(OccupationalTask ot) throws Exception {
        log("Fetching occupational task skills...");
        String skillId;
        boolean validSkill = false;
        for (int i=0;i<ot.getSkillIds().length();i++) {
            skillId = getShortIdFromExternalId(ot.getSkillIds().getString(i));
            validSkill = false;
            if (!getNavySkillMap().containsKey(skillId)) {
                String otSkillResponseString = executeEntityLookup(skillId);
                JSONObject otSkillJo = new JSONObject(otSkillResponseString);
                if (otSkillJo.has("@id")) {
                    parseAndAddSkill(otSkillJo,skillId);
                    validSkill = true;
                }
            }
            else validSkill = true;
            if (validSkill) {
                ot.addSkill(getNavySkillMap().get(skillId));
            }
        }
    }

    private void fetchOccupationalTaskSkillList() throws Exception {
        log("Fetching occupational task skill list...");
        getNavySkillMap().clear();
        OccupationalTask ot;
        Set<String> otKeys = getNavyOccupationalTaskMap().keySet();
        for (String key:otKeys) {
            ot = getNavyOccupationalTaskMap().get(key);
            fetchOccupationalTaskSkills(ot);
        }
        log("Skills generated: " + getNavySkillMap().keySet().size());
    }

    private void parseAndAddAbility(JSONObject otAbilityJo, String abilityId) throws Exception {
        Ability a = new Ability(
            otAbilityJo.getString("@id"),
            otAbilityJo.getString("ceterms:ctid"),
            otAbilityJo.getString("ceasn:competencyText"),
            null,
            null
        );
        getNavyAbilityMap().put(abilityId,a);
    }

    private void fetchOccupationalTaskAbilities(OccupationalTask ot) throws Exception {
        log("Fetching occupational task abilities...");
        String abilityId;
        boolean validAbility = false;
        for (int i=0;i<ot.getAbilityIds().length();i++) {
            abilityId = getShortIdFromExternalId(ot.getAbilityIds().getString(i));
            validAbility = false;
            if (!getNavyAbilityMap().containsKey(abilityId)) {
                String otAbilityResponseString = executeEntityLookup(abilityId);
                JSONObject otAbilityJo = new JSONObject(otAbilityResponseString);
                if (otAbilityJo.has("@id")) {
                    parseAndAddAbility(otAbilityJo,abilityId);
                    validAbility = true;
                }
            }
            else validAbility = true;
            if (validAbility) {
                ot.addAbility(getNavyAbilityMap().get(abilityId));
            }
        }
    }

    private void fetchOccupationalTaskAbilityList() throws Exception {
        log("Fetching occupational task ability list...");
        getNavyAbilityMap().clear();
        OccupationalTask ot;
        Set<String> otKeys = getNavyOccupationalTaskMap().keySet();
        for (String key:otKeys) {
            ot = getNavyOccupationalTaskMap().get(key);
            fetchOccupationalTaskAbilities(ot);
        }
        log("Abilities generated: " + getNavyAbilityMap().keySet().size());
    }

    private JSONArray buildRatingsJsonArray() {
        JSONArray ja = new JSONArray();
        for (Rating r:getNavyRatingList()) {
            ja.put(r.toJson());
        }
        return ja;
    }

    private JSONArray buildJobsJsonArray() {
        JSONArray ja = new JSONArray();
        for (String key:getNavyJobMap().keySet()) {
            ja.put(getNavyJobMap().get(key).toJson());
        }
        return ja;
    }

    private JSONArray buildNecsJsonArray() {
        JSONArray ja = new JSONArray();
        for (String key:getNavyNecMap().keySet()) {
            ja.put(getNavyNecMap().get(key).toJson());
        }
        return ja;
    }

    private JSONArray buildOccupationTasksJsonArray() {
        JSONArray ja = new JSONArray();
        for (String key:getNavyOccupationalTaskMap().keySet()) {
            ja.put(getNavyOccupationalTaskMap().get(key).toJson());
        }
        return ja;
    }

    private JSONArray buildAbilitiesJsonArray() {
        JSONArray ja = new JSONArray();
        for (String key:getNavyAbilityMap().keySet()) {
            ja.put(getNavyAbilityMap().get(key).toJson());
        }
        return ja;
    }

    private JSONArray buildSkillsJsonArray() {
        JSONArray ja = new JSONArray();
        for (String key:getNavySkillMap().keySet()) {
            ja.put(getNavySkillMap().get(key).toJson());
        }
        return ja;
    }

//    private JSONObject buildComponentJson() throws Exception {
//        log("Building component JSON...");
//        JSONObject jo = new JSONObject();
//        jo.put("skills",buildSkillsJsonArray());
//        jo.put("abilities",buildAbilitiesJsonArray());
//        jo.put("jobs",buildJobsJsonArray());
//        jo.put("necs",buildNecsJsonArray());
//        jo.put("ratings",buildRatingsJsonArray());
//        return jo;
//    }

    private String generateTimestamp() {
        Calendar cal = Calendar.getInstance();
        return String.valueOf(cal.getTimeInMillis());
    }

    private void writeJsonArrayToFile(JSONArray ja, String filePrefix, String timeStamp) throws Exception {
        String fileName = filePrefix + timeStamp + ".json";
        log("Writing component JSON to output file: " + fileName);
        FileWriter fw = new FileWriter(fileName);
        fw.write(ja.toString(4));
        fw.close();
    }

    private void writeOutputFiles() throws Exception {
        String timeStamp = generateTimestamp();
        writeJsonArrayToFile(buildNecsJsonArray(),NECS_OUTPUT_FILE_PREFIX,timeStamp);
        writeJsonArrayToFile(buildSkillsJsonArray(),SKILLS_OUTPUT_FILE_PREFIX,timeStamp);
        writeJsonArrayToFile(buildAbilitiesJsonArray(),ABILITIES_OUTPUT_FILE_PREFIX,timeStamp);
        writeJsonArrayToFile(buildOccupationTasksJsonArray(),OTS_OUTPUT_FILE_PREFIX,timeStamp);
        writeJsonArrayToFile(buildJobsJsonArray(),JOBS_OUTPUT_FILE_PREFIX,timeStamp);
        writeJsonArrayToFile(buildRatingsJsonArray(),RATINGS_OUTPUT_FILE_PREFIX,timeStamp);
    }

    public void fetchNavyComponents() throws Exception {
        log("Fetching Navy Components...");
        log("Keyword Query URL: " + KEYWORD_QUERY_URL);
        log("Reverse Link Query URL: " + REVERSE_LINK_QUERY_URL);
        fetchRatingList();
        fetchRatingJobList();
        fetchRatingNecList();
        fetchJobOccupationalTaskList();
        fetchOccupationalTaskSkillList();
        fetchOccupationalTaskAbilityList();
        writeOutputFiles();
    }

    public static void main(String[] args) throws Exception {
        NavyComponentFetcher ncf = new NavyComponentFetcher();
        ncf.fetchNavyComponents();
    }

}
