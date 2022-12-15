package com.gabrielpdc.sigercommandline;

import java.util.ArrayList;

public class SigerCommandLineFactory {

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
    public SigerCommandLineFactory(Architecture architecture) {
        this.architecture = architecture;
        if (architecture == Architecture.DESKTOP) {
            sigerCommandLine = new DesktopSigerCommandLines.Builder(Sig.builder().build()).build();
        } else {
            sigerCommandLine = new ThinClientSigerCommandLines.Builder().build();
        }
    }

    public ArrayList<String> build() throws SigerCommandLineException {
        ArrayList<String> commandLines = new ArrayList<>();
        for (String commandLine : sigerCommandLine.generateCommandLine()) {
            commandLines.add(commandLine);
        }
        return commandLines;
    }


}
