package com.gabrielpdc.sigercommandline;

import java.util.ArrayList;

public class Sig implements SigerCommandLines {

    private static String SIG_RUNNER = "Sig.bat";

    @Override
    public ArrayList<String> buildCommandLine() throws SigerCommandLineException {
        ArrayList<String> commandLines = new ArrayList<>();
        commandLines.add(SIG_RUNNER);
        return commandLines;
    }

}
