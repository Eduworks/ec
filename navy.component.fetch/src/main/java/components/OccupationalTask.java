package components;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class OccupationalTask extends NavyComponent {

    private static final String DC_TERMS_TYPE = "Occupational Task";

    private JSONArray skillIds = new JSONArray();
    private JSONArray abilityIds = new JSONArray();

    private List<Skill> skills = new ArrayList<>();
    private List<Ability> abilities = new ArrayList<>();

    public OccupationalTask(String externalSystemId, String externalShortId, String name, String description, String code) {
        super(externalSystemId,externalShortId,name,description,code);
    }

    public JSONArray getSkillIds() {return skillIds;}
    public void setSkillIds(JSONArray skillIds) {this.skillIds = skillIds;}

    public JSONArray getAbilityIds() {return abilityIds;}
    public void setAbilityIds(JSONArray abilityIds) {this.abilityIds = abilityIds;}

    public List<Skill> getSkills() {return skills;}
    public void setSkills(List<Skill> skills) {this.skills = skills;}

    public List<Ability> getAbilities() {return abilities;}
    public void setAbilities(List<Ability> abilities) {this.abilities = abilities;}

    public void addSkill(Skill skill) {getSkills().add(skill);}

    public void addAbility(Ability ability) {getAbilities().add(ability);}

    public String getDcTermsType() {return DC_TERMS_TYPE;}

    @Override
    public String toString() {
        String s = super.toString();
        s += "\n" + "SkillIds: " + getSkillIds().toString() + "\n" +
                "AbilityIds: " + getAbilityIds().toString() + "\n" +
                "Skills: " + getSkills().size()+ "\n" +
                "Abilities: " + getAbilities().size();
        return s;
    }

    @Override
    @SuppressWarnings("Duplicates")
    public JSONObject toJson() {
        JSONObject jo = super.toJson();
        JSONArray skillArray = new JSONArray();
        JSONArray abilityArray = new JSONArray();
        for (Skill s: getSkills()) {
            skillArray.put(s.getExternalSystemId());
        }
        for (Ability a: getAbilities()) {
            abilityArray.put(a.getExternalSystemId());
        }
        jo.put("skills",skillArray);
        jo.put("abilities",abilityArray);
        return jo;
    }

}