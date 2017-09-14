package cass.rollup.processors.predictor;

import org.stjs.javascript.Array;

public class PapDependency extends PapDependencyParms {

    //STJS doesn't like HashMaps with enums...
    //public enum DependencyType{NECESSARY, SUFFICIENT, EQUIVALENCE, BROADENS, NULL}

    //If more types are added getDependencyTypes() and hashCode() must also be modified
    public static final String NECESSARY_TYPE = "NECESSARY";
    public static final String SUFFICIENT_TYPE = "SUFFICIENT";
    public static final String EQUIVALENCE_TYPE = "EQUIVALENCE";
    public static final String BROADENS_TYPE = "BROADENS";
    public static final String NULL_TYPE = "NULL";

    private static final int HASH_CODE_MULTIPLIER = 41;
    private static final int HASH_CODE_PERCENTAGE_MULTIPLIER = 97;

    public PapDependency(PapDependencyParms depParms) {
        if (depParms.getDependencyFirst()) {
            setParentIndex(depParms.getParentIndex());
            setChildIndex(depParms.getChildIndex());
        }
        else {
            setChildIndex(depParms.getParentIndex());
            setParentIndex(depParms.getChildIndex());
        }
        setType(depParms.getType());
        setWeight(depParms.getWeight());
        setLeak(depParms.getLeak());
    }

    //Modify if more types are added
    public static Array<String> getDependencyTypes() {
        Array<String> dt = new Array<String>();
        dt.push(NECESSARY_TYPE);
        dt.push(SUFFICIENT_TYPE);
        dt.push(EQUIVALENCE_TYPE);
        dt.push(BROADENS_TYPE);
        dt.push(NULL_TYPE);
        return dt;
    }

    public String toString() {return "Dependency: ["+getType().toString()+"] "+getParentIndex()+" <-- "+getChildIndex();}

    public boolean equals(Object other) {
        return (getParentIndex() == ((PapDependency) other).getParentIndex()) &&
                (getChildIndex() == ((PapDependency) other).getChildIndex()) && (getType() == ((PapDependency)other).getType());
    }

    public int hashCode() {
        int temp = 0;
        if (NECESSARY_TYPE.equalsIgnoreCase(getType())) temp = 1;
        else if (EQUIVALENCE_TYPE.equalsIgnoreCase(getType())) temp = 2;
        else if (SUFFICIENT_TYPE.equalsIgnoreCase(getType())) temp = 3;
        else if (BROADENS_TYPE.equalsIgnoreCase(getType())) temp = 4;
        temp *= HASH_CODE_MULTIPLIER;
        temp += getParentIndex();
        temp *= HASH_CODE_MULTIPLIER;
        temp += getChildIndex();
        return temp + ((int) (100 * getWeight()) % HASH_CODE_PERCENTAGE_MULTIPLIER);
    }


}
