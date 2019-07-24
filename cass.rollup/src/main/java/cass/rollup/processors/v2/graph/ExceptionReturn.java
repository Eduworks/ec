package cass.rollup.processors.v2.graph;

import org.stjs.javascript.Global;

public class ExceptionReturn {

    private String errorMessage;

    public ExceptionReturn(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {return errorMessage;}
    public void setErrorMessage(String errorMessage) {this.errorMessage = errorMessage;}

    public String getJsonString() {
        return Global.JSON.stringify(this);
    }

}
