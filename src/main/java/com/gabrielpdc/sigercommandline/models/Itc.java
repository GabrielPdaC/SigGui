package com.gabrielpdc.sigercommandline.models;

import java.util.ArrayList;
import java.util.Optional;

public final class Itc implements SigerCommandLines {

    private static String ITC_RUNNER = "ITC.bat";
    private static String PANEL_PARAM = "PANEL";
    private static String PORT_PARAM = "PORT:";
    private static String DEBUG_PARAM = "D";
    private static String ARCH64_PARAM = "64";
    private static String JAVA_OUTPUT_PARAM = "EX";
    private static String LINUX_PARAM = "LINUX";

    private final boolean isPanel;
    private final Optional<Integer> port;
    private final boolean isDebug;
    private final boolean is64;
    private final boolean isJavaOutput;
    private final OperatingSystem serverOperatingSystem;

    /* Sistemas operacionais para executar o server */
    public enum OperatingSystem {
        WINDOWS,
        LINUX;
    }

    public Itc(boolean isPanel, Optional<Integer> port, boolean isDebug, boolean is64, boolean isJavaOutput,
            OperatingSystem serverOperatingSystem) {
        this.isPanel = isPanel;
        this.port = port;
        this.isDebug = isDebug;
        this.is64 = is64;
        this.isJavaOutput = isJavaOutput;
        this.serverOperatingSystem = serverOperatingSystem;
    }

    public static Builder builder() {
        return new Itc.Builder();
    }

    @Override
    public ArrayList<String> generateCommandLine() throws SigerCommandLineException {
        ArrayList<String> commandLines = new ArrayList<>();
        commandLines.add(ITC_RUNNER);
        if (isPanel) {
            commandLines.add(PANEL_PARAM);
        }
        if (port.isPresent()) {
            commandLines.add(PORT_PARAM + port.get());
        }
        if (isDebug) {
            commandLines.add(DEBUG_PARAM);
        }
        if (is64) {
            commandLines.add(ARCH64_PARAM);
        }
        if (isJavaOutput) {
            commandLines.add(JAVA_OUTPUT_PARAM);
        }
        if (serverOperatingSystem == OperatingSystem.LINUX) {
            commandLines.add(LINUX_PARAM);
        }
        return commandLines;
    }

    public static class Builder implements CommandLineBuilder {

        private boolean isPanel = false;
        private Optional<Integer> port = Optional.empty();
        private boolean isDebug = false;
        private boolean is64bits = false;
        private boolean isJavaOutput = false;
        private OperatingSystem serverOperatingSystem = OperatingSystem.WINDOWS;

        public Builder withPanel(boolean isPanel) {
            this.isPanel = isPanel;
            return this;
        }

        public Builder port(Integer port) {
            this.port = Optional.of(port);
            return this;
        }

        public Builder withDebug(boolean isDebug) {
            this.isDebug = isDebug;
            return this;
        }

        public Builder with64bits(boolean is64bits) {
            this.is64bits = is64bits;
            return this;
        }

        public Builder withJavaOutput(boolean isJavaOutput) {
            this.isJavaOutput = isJavaOutput;
            return this;
        }

        public Builder serverOperatingSystem(OperatingSystem serverOperatingSystem) {
            this.serverOperatingSystem = serverOperatingSystem;
            return this;
        }

        @Override
        public Itc build() {
            return new Itc(isPanel, port, isDebug, is64bits, isJavaOutput, serverOperatingSystem);
        }
    }

}
