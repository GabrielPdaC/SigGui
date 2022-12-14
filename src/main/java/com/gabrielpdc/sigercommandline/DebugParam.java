package com.gabrielpdc.sigercommandline;

public class DebugParam {

    static String DEBUG_PARAM = "D";

    private boolean isDebug;

    public DebugParam() {
        this.isDebug = false;
    }

    public DebugParam setDebug(boolean isDebug) {
        this.isDebug = isDebug;
        return this;
    }

}
