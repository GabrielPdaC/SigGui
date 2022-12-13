package com.gabrielpdc.sigercommandline;

import java.util.ArrayList;

public class SigerCommandLineBuilder {

    /* Arquitetura de execução */
    private Architecture architecture;

    public enum Architecture {
        DESKTOP,
        THIN_CLIENT;
    }

    /* Linhas de comando para execução */
    private SigerCommandLines sigerCommandLine;

    /**
     * @param architecture
     */
    public SigerCommandLineBuilder(Architecture architecture) {
        this.architecture = architecture;
    }

    public ArrayList<String> build() throws SigerCommandLineException {
        ArrayList<String> commandLines = new ArrayList<>();
        for (String commandLine: sigerCommandLine.buildCommandLine()) {
            commandLines.add(commandLine);
        }
        return commandLines;
    }
}
