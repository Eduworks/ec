package components;

import org.json.JSONObject;

public abstract class NavyComponent {

    protected static String FIELD_LANGUAGE = "en-US";

    private String externalSystemId;
    private String externalShortId;
    private String name;
    private String description;
    private String code;

    public NavyComponent(String externalSystemId, String externalShortId, String name, String description, String code) {
        setExternalSystemId(externalSystemId);
        setExternalShortId(externalShortId);
        setName(name);
        setDescription(description);
        setCode(code);
    }

    public String getExternalSystemId() {return externalSystemId;}
    public void setExternalSystemId(String externalSystemId) {this.externalSystemId = externalSystemId;}

    public String getExternalShortId() {return externalShortId;}
    public void setExternalShortId(String externalShortId) {this.externalShortId = externalShortId;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public String getCode() {return code;}
    public void setCode(String code) {this.code = code;}

    public abstract String getDcTermsType();

    public String toString() {
        return "**********************************\n" +
                "dcTermsType: '" + getDcTermsType() + "'\n" +
                "externalId: '" + getExternalSystemId() + "'\n" +
                "externalShortId: '" + getExternalShortId() + "'\n" +
                "code: '" + getCode() + "'\n" +
                "name: '" + getName() + "'\n" +
                "description: '" + getDescription() + "'";
    }

    public JSONObject toJson() {
        JSONObject jo = new JSONObject();
        jo.put("dcTermsType",getDcTermsType());
        jo.put("externalId",getExternalSystemId());
        jo.put("externalShortId",getExternalShortId());
        jo.put("code",getCode());
        jo.put("name",getName());
        jo.put("description",getDescription());
        return jo;
    }


}
