package fetcher;

import components.*;
import jdk.nashorn.internal.objects.annotations.Function;
import org.json.JSONArray;
import org.json.JSONObject;
import org.stjs.javascript.JSON;

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
    private static final String LIST_QUERY_URL = "https://credreg.net/NavyARTT/NavyGraph/ListQuery";
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

    private static final String FUNCTIONAL_AREAS_OUTPUT_FILE_PREFIX = OUTPUT_ROOT_DIR + "testNavyComponentFetcher_FUNCTIONAL_AREAS_";
    private static final String WORK_ACTIVITIES_OUTPUT_FILE_PREFIX = OUTPUT_ROOT_DIR + "testNavyComponentFetcher_WORK_ACTIVITIES_";
    private static final String DOD_OCCS_OUTPUT_FILE_PREFIX = OUTPUT_ROOT_DIR + "testNavyComponentFetcher_DOD_OCCS_";
    private static final String JOB_FAMILIES_OUTPUT_FILE_PREFIX = OUTPUT_ROOT_DIR + "testNavyComponentFetcher_JOB_FAMILIES_";
    private static final String PAY_GRADES_OUTPUT_FILE_PREFIX = OUTPUT_ROOT_DIR + "testNavyComponentFetcher_PAY_GRADES_";

    private static final boolean ONLY_FIRST_RATING = false; //for testing stuff

    private List<Rating> navyRatingList = new ArrayList<>();
    private HashMap<String, Nec> navyNecMap = new HashMap<>();
    private HashMap<String, Job> navyJobMap = new HashMap<>();
    private HashMap<String, Skill> navySkillMap = new HashMap<>();
    private HashMap<String, Ability> navyAbilityMap = new HashMap<>();
    private HashMap<String, OccupationalTask> navyOccupationalTaskMap = new HashMap<>();
    private HashMap<String, FunctionalArea> navyFunctionalAreaMap = new HashMap<>();
    private HashMap<String, DodOccupation> navyDodOccupationMap = new HashMap<>();
    private HashMap<String, JobFamily> navyJobFamilyMap = new HashMap<>();
    private HashMap<String, PayGrade> navyPayGradeMap = new HashMap<>();
    private HashMap<String, WorkActivity> navyWorkActivyMap = new HashMap<>();

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

    public HashMap<String, FunctionalArea> getNavyFunctionalAreaMap() {return navyFunctionalAreaMap;}
    public void setNavyFunctionalAreaMap(HashMap<String, FunctionalArea> navyFunctionalAreaMap) {this.navyFunctionalAreaMap = navyFunctionalAreaMap;}

    public HashMap<String, DodOccupation> getNavyDodOccupationMap() {return navyDodOccupationMap;}
    public void setNavyDodOccupationMap(HashMap<String, DodOccupation> navyDodOccupationMap) {this.navyDodOccupationMap = navyDodOccupationMap;}

    public HashMap<String, JobFamily> getNavyJobFamilyMap() {return navyJobFamilyMap;}
    public void setNavyJobFamilyMap(HashMap<String, JobFamily> navyJobFamilyMap) {this.navyJobFamilyMap = navyJobFamilyMap;}

    public HashMap<String, PayGrade> getNavyPayGradeMap() {return navyPayGradeMap;}
    public void setNavyPayGradeMap(HashMap<String, PayGrade> navyPayGradeMap) {this.navyPayGradeMap = navyPayGradeMap;}

    public HashMap<String, WorkActivity> getNavyWorkActivyMap() {return navyWorkActivyMap;}
    public void setNavyWorkActivyMap(HashMap<String, WorkActivity> navyWorkActivyMap) {this.navyWorkActivyMap = navyWorkActivyMap;}

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

    private String executeListQuery(JSONObject requestJson) throws Exception {
        return executePostQuery(requestJson, LIST_QUERY_URL);
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

    private JSONArray buildWorkActivityJsonArray() {
        JSONArray ja = new JSONArray();
        for (String key:getNavyWorkActivyMap().keySet()) {
            ja.put(getNavyWorkActivyMap().get(key).toJson());
        }
        return ja;
    }

    private JSONArray buildFunctionalAreaJsonArray() {
        JSONArray ja = new JSONArray();
        for (String key:getNavyFunctionalAreaMap().keySet()) {
            ja.put(getNavyFunctionalAreaMap().get(key).toJson());
        }
        return ja;
    }

    private JSONArray buildJobFamilyJsonArray() {
        JSONArray ja = new JSONArray();
        for (String key:getNavyJobFamilyMap().keySet()) {
            ja.put(getNavyJobFamilyMap().get(key).toJson());
        }
        return ja;
    }

    private JSONArray buildDodOccupationJsonArray() {
        JSONArray ja = new JSONArray();
        for (String key:getNavyDodOccupationMap().keySet()) {
            ja.put(getNavyDodOccupationMap().get(key).toJson());
        }
        return ja;
    }

    private JSONArray buildPayGradeJsonArray() {
        JSONArray ja = new JSONArray();
        for (String key:getNavyPayGradeMap().keySet()) {
            ja.put(getNavyPayGradeMap().get(key).toJson());
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

    private void writeOutputFilesPart1() throws Exception {
        String timeStamp = generateTimestamp();
        writeJsonArrayToFile(buildNecsJsonArray(),NECS_OUTPUT_FILE_PREFIX,timeStamp);
        writeJsonArrayToFile(buildSkillsJsonArray(),SKILLS_OUTPUT_FILE_PREFIX,timeStamp);
        writeJsonArrayToFile(buildAbilitiesJsonArray(),ABILITIES_OUTPUT_FILE_PREFIX,timeStamp);
        writeJsonArrayToFile(buildOccupationTasksJsonArray(),OTS_OUTPUT_FILE_PREFIX,timeStamp);
        writeJsonArrayToFile(buildJobsJsonArray(),JOBS_OUTPUT_FILE_PREFIX,timeStamp);
        writeJsonArrayToFile(buildRatingsJsonArray(),RATINGS_OUTPUT_FILE_PREFIX,timeStamp);
    }

    public void fetchNavyComponentsPart1() throws Exception {
        log("Fetching Navy Components...");
        log("Keyword Query URL: " + KEYWORD_QUERY_URL);
        log("Reverse Link Query URL: " + REVERSE_LINK_QUERY_URL);
        fetchRatingList();
        fetchRatingJobList();
        fetchRatingNecList();
        fetchJobOccupationalTaskList();
        fetchOccupationalTaskSkillList();
        fetchOccupationalTaskAbilityList();
        writeOutputFilesPart1();
    }

    private JSONArray parseRelatedResponseIdsForComponentResponse(String responseString) {
        JSONObject ro = new JSONObject(responseString);
        JSONArray da = ro.getJSONArray("data");
        JSONArray idArray = new JSONArray();
        for (int i=0;i<da.length();i++) {
            idArray.put(da.getJSONObject(i).getString("@id"));
        }
        return idArray;
    }

    private JSONArray fetchRelatedRatingIdsForComponent(String componentId, String propertyName) throws Exception {
        JSONObject queryJo = new JSONObject();
        queryJo.put("query",generateReverseLinkQueryRequestObject("Ratings",componentId,propertyName));
        String occTaskResponseString = executeReverseLinkQuery(queryJo);
        return parseRelatedResponseIdsForComponentResponse(occTaskResponseString);
    }

    private JSONArray fetchRelatedOccupationalTaskIdsForComponent(String componentId, String propertyName) throws Exception {
        JSONObject queryJo = new JSONObject();
        queryJo.put("query",generateReverseLinkQueryRequestObject("OccupationalTasks",componentId,propertyName));
        String occTaskResponseString = executeReverseLinkQuery(queryJo);
        return parseRelatedResponseIdsForComponentResponse(occTaskResponseString);
    }

    private void addOccupationalTasksToWorkActivities() throws Exception {
        log("Adding occ tasks to work activities...");
        for (String key:getNavyWorkActivyMap().keySet()) {
            WorkActivity wa = getNavyWorkActivyMap().get(key);
            wa.setOccupationalTaskIds(fetchRelatedOccupationalTaskIdsForComponent(wa.getExternalSystemId(),"navy:hasWorkActivity"));
        }
    }

    private void generateAndAddWorkActivy(JSONObject waObj) {
        WorkActivity wa = new WorkActivity(
                waObj.getString("@id"),
                waObj.getString("ceterms:ctid"),
                waObj.getString("skos:prefLabel"),
                null,
                waObj.getString("skos:notation")
        );
        if (waObj.has("skos:narrower")) wa.setChildWorkActivityIds(waObj.getJSONArray("skos:narrower"));
        getNavyWorkActivyMap().put(wa.getExternalSystemId(),wa);
    }

    private void parseWorkActivityQueryResponse(String queryResponse) {
        log("Parsing work activity query response...");
        JSONObject ro = new JSONObject(queryResponse);
        JSONArray rd = ro.getJSONArray("data");
        for (int i=0;i<rd.length();i++) {
            generateAndAddWorkActivy(rd.getJSONObject(i));
        }
    }

    private void addOccupationalTasksToFunctionalAreas() throws Exception {
        log("Adding occ tasks to functional areas...");
        for (String key:getNavyFunctionalAreaMap().keySet()) {
            FunctionalArea fa = getNavyFunctionalAreaMap().get(key);
            fa.setOccupationalTaskIds(fetchRelatedOccupationalTaskIdsForComponent(fa.getExternalSystemId(),"navy:hasWorkRole"));
        }
    }

    private void generateAndAddFunctionalArea(JSONObject faObj) {
        FunctionalArea fa = new FunctionalArea(
                faObj.getString("@id"),
                faObj.getString("ceterms:ctid"),
                faObj.getString("schema:name"),
                null,
                faObj.getString("ceasn:codedNotation")
        );
        getNavyFunctionalAreaMap().put(fa.getExternalSystemId(),fa);
    }

    private void parseFunctionalAreaQueryResponse(String queryResponse) {
        log("Parsing functional area query response...");
        JSONObject ro = new JSONObject(queryResponse);
        JSONArray rd = ro.getJSONArray("data");
        for (int i=0;i<rd.length();i++) {
            generateAndAddFunctionalArea(rd.getJSONObject(i));
        }
    }

    private void addRatingsToJobFamilies() throws Exception {
        log("Adding ratings to job families...");
        for (String key:getNavyJobFamilyMap().keySet()) {
            JobFamily jf = getNavyJobFamilyMap().get(key);
            jf.setRatingIds(fetchRelatedRatingIdsForComponent(jf.getExternalSystemId(),"navy:hasOccupationType"));
        }
    }

    private void generateAndAddJobFamily(JSONObject jfObj) {
        JobFamily jf = new JobFamily(
                jfObj.getString("@id"),
                jfObj.getString("ceterms:ctid"),
                jfObj.getString("skos:prefLabel"),
                null,
                null
        );
        getNavyJobFamilyMap().put(jf.getExternalSystemId(),jf);
    }

    private void parseJobFamilyQueryResponse(String queryResponse) {
        log("Parsing job family query response...");
        JSONObject ro = new JSONObject(queryResponse);
        JSONArray rd = ro.getJSONArray("data");
        for (int i=0;i<rd.length();i++) {
            generateAndAddJobFamily(rd.getJSONObject(i));
        }
    }

    private void addRatingsToDodOccupations() throws Exception {
        log("Adding ratings to DOD occupations...");
        for (String key:getNavyDodOccupationMap().keySet()) {
            DodOccupation dod = getNavyDodOccupationMap().get(key);
            dod.setRatingIds(fetchRelatedRatingIdsForComponent(dod.getExternalSystemId(),"navy:hasDoDOccupationType"));
        }
    }

    private void generateAndAddDodOccupation(JSONObject doObj) {
        DodOccupation dod = new DodOccupation(
                doObj.getString("@id"),
                doObj.getString("ceterms:ctid"),
                doObj.getString("skos:prefLabel"),
                null,
                doObj.getString("skos:notation")
        );
        getNavyDodOccupationMap().put(dod.getExternalSystemId(),dod);
    }

    private void parseDodOccupationQueryResponse(String queryResponse) {
        log("Parsing DOD occupation query response...");
        JSONObject ro = new JSONObject(queryResponse);
        JSONArray rd = ro.getJSONArray("data");
        for (int i=0;i<rd.length();i++) {
            generateAndAddDodOccupation(rd.getJSONObject(i));
        }
    }

    private void addOccupationalTasksToPayGrades() throws Exception {
        log("Adding occ tasks to pay grades...");
        for (String key:getNavyPayGradeMap().keySet()) {
            PayGrade pg = getNavyPayGradeMap().get(key);
            pg.setOccupationalTaskIds(fetchRelatedOccupationalTaskIdsForComponent(pg.getExternalSystemId(),"navy:hasPaygradeType"));
        }
    }

    private void generateAndAddPayGrade(JSONObject pgObj) {
        PayGrade pg = new PayGrade(
                pgObj.getString("@id"),
                pgObj.getString("ceterms:ctid"),
                pgObj.getString("skos:altLabel"),
                null,
                pgObj.getString("skos:prefLabel")
        );
        getNavyPayGradeMap().put(pg.getExternalSystemId(),pg);
    }

    private void parsePayGradeQueryResponse(String queryResponse) {
        log("Parsing pay grade query response...");
        JSONObject ro = new JSONObject(queryResponse);
        JSONArray rd = ro.getJSONArray("data");
        for (int i=0;i<rd.length();i++) {
            generateAndAddPayGrade(rd.getJSONObject(i));
        }
    }

    private void fetchWorkActivityList() throws Exception {
        log("Fetching work activity list...");
        getNavyWorkActivyMap().clear();
        JSONObject sourceJo = new JSONObject();
        JSONObject queryJo = new JSONObject();
        sourceJo.put("dataSource","Composite_WorkActivities");
        queryJo.put("query",sourceJo);
        String queryResponse = executeListQuery(queryJo);
        parseWorkActivityQueryResponse(queryResponse);
        addOccupationalTasksToWorkActivities();
        log("Work activities generated: " + getNavyWorkActivyMap().size());
    }

    private void fetchFunctionalAreaList() throws Exception {
        log("Fetching functional area list...");
        getNavyFunctionalAreaMap().clear();
        JSONObject sourceJo = new JSONObject();
        JSONObject queryJo = new JSONObject();
        sourceJo.put("dataSource","WorkRoles");
        queryJo.put("query",sourceJo);
        String queryResponse = executeListQuery(queryJo);
        parseFunctionalAreaQueryResponse(queryResponse);
        addOccupationalTasksToFunctionalAreas();
        log("Functional areas generated: " + getNavyFunctionalAreaMap().size());
    }

    private void fetchJobFamilyList() throws Exception {
        log("Fetching job family list...");
        getNavyJobFamilyMap().clear();
        JSONObject sourceJo = new JSONObject();
        JSONObject queryJo = new JSONObject();
        sourceJo.put("dataSource","JobFamilies");
        queryJo.put("query",sourceJo);
        String queryResponse = executeListQuery(queryJo);
        parseJobFamilyQueryResponse(queryResponse);
        addRatingsToJobFamilies();
        log("Job families generated: " + getNavyJobFamilyMap().size());
    }

    private void fetchDodOccupationList() throws Exception {
        log("Fetching DOD occupation list...");
        getNavyDodOccupationMap().clear();
        JSONObject sourceJo = new JSONObject();
        JSONObject queryJo = new JSONObject();
        sourceJo.put("dataSource","DoDOccupations");
        queryJo.put("query",sourceJo);
        String queryResponse = executeListQuery(queryJo);
        parseDodOccupationQueryResponse(queryResponse);
        addRatingsToDodOccupations();
        log("DOD occupations generated: " + getNavyDodOccupationMap().size());
    }

    private void fetchPayGradeList() throws Exception {
        log("Fetching pay grade list...");
        getNavyPayGradeMap().clear();
        JSONObject sourceJo = new JSONObject();
        JSONObject queryJo = new JSONObject();
        sourceJo.put("dataSource","PaygradeTypes");
        queryJo.put("query",sourceJo);
        String queryResponse = executeListQuery(queryJo);
        parsePayGradeQueryResponse(queryResponse);
        addOccupationalTasksToPayGrades();
        log("Pay grades generated: " + getNavyPayGradeMap().size());
    }


    private void writeOutputFilesPart2() throws Exception {
        System.out.println("TODO: writeOutputFilesPart2");
        String timeStamp = generateTimestamp();
        writeJsonArrayToFile(buildWorkActivityJsonArray(),WORK_ACTIVITIES_OUTPUT_FILE_PREFIX,timeStamp);
        writeJsonArrayToFile(buildFunctionalAreaJsonArray(),FUNCTIONAL_AREAS_OUTPUT_FILE_PREFIX,timeStamp);
        writeJsonArrayToFile(buildJobFamilyJsonArray(),JOB_FAMILIES_OUTPUT_FILE_PREFIX,timeStamp);
        writeJsonArrayToFile(buildDodOccupationJsonArray(),DOD_OCCS_OUTPUT_FILE_PREFIX,timeStamp);
        writeJsonArrayToFile(buildPayGradeJsonArray(),PAY_GRADES_OUTPUT_FILE_PREFIX,timeStamp);
    }

    public void fetchNavyComponentsPart2() throws Exception {
        log("Fetching Navy Components...");
        log("List Query URL: " + LIST_QUERY_URL);
        log("Reverse Link Query URL: " + REVERSE_LINK_QUERY_URL);
        fetchWorkActivityList();
        fetchFunctionalAreaList();
        fetchJobFamilyList();
        fetchDodOccupationList();
        fetchPayGradeList();
        writeOutputFilesPart2();
    }

    public static void main(String[] args) throws Exception {
        NavyComponentFetcher ncf = new NavyComponentFetcher();
        //ncf.fetchNavyComponentsPart1();
        ncf.fetchNavyComponentsPart2();
    }

}
