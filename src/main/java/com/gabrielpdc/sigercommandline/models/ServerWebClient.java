package com.gabrielpdc.sigercommandline.models;

import java.util.ArrayList;

public final class ServerWebClient implements SigerCommandLines {

    private static String SERVER_WC_RUNNER = "SRVWC.bat";
    private static String SHOW_INFO_PARAM = "INF";
    private static String JAVA_OUTPUT_PARAM = "EX";
    private static String DEBUG_JAVA_PARAM = "DJ";
    private static String TRUNK_PARAM = "/F";

    private final boolean isShowInfo;
    private final boolean isJavaOutput;
    private final boolean isDebugJava;
    private final boolean isTrunk;

    public ServerWebClient(boolean isShowInfo, boolean isJavaOutput, boolean isDebugJava, boolean isTrunk) {
        this.isShowInfo = isShowInfo;
        this.isJavaOutput = isJavaOutput;
        this.isDebugJava = isDebugJava;
        this.isTrunk = isTrunk;
    }

    public static Builder builder() {
        return new ServerWebClient.Builder();
    }

    @Override
    public ArrayList<String> generateCommandLine() throws SigerCommandLineException {
        ArrayList<String> commandLines = new ArrayList<>();
        commandLines.add(SERVER_WC_RUNNER);
        if (isShowInfo){
            commandLines.add(SHOW_INFO_PARAM);
        }
        if (isJavaOutput){
            commandLines.add(JAVA_OUTPUT_PARAM);
        }
        if (isDebugJava){
            commandLines.add(DEBUG_JAVA_PARAM);
        }
        if (isTrunk){
            commandLines.add(TRUNK_PARAM);
        }
        return commandLines;
    }

    public static class Builder implements CommandLineBuilder {

        private boolean isShowInfo = false;
        private boolean isJavaOutput = false;
        private boolean isDebugJava = false;
        private boolean isTrunk = false;

        public Builder withShowInfo(boolean isShowInfo) {
            this.isShowInfo = isShowInfo;
            return this;
        }

        public Builder withJavaOutput(boolean isJavaOutput) {
            this.isJavaOutput = isJavaOutput;
            return this;
        }

        public Builder withDebugJava(boolean isDebugJava) {
            this.isDebugJava = isDebugJava;
            return this;
        }

        public Builder withTrunk(boolean isTrunk) {
            this.isTrunk = isTrunk;
            return this;
        }

        @Override
        public ServerWebClient build() {
            return new ServerWebClient(isShowInfo, isJavaOutput, isDebugJava, isTrunk);
        }
    }
}
