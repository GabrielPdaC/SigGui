package com.gabrielpdc.sigercommandline;

import java.util.ArrayList;

public class GoGlobal implements SigerCommandLines {

    private static String GO_GLOBAL_RUNNER = "GoGlobal.bat";

    @Override
    public ArrayList<String> buildCommandLine() throws SigerCommandLineException {
        ArrayList<String> commandLines = new ArrayList<>();
        commandLines.add(GO_GLOBAL_RUNNER);
        return commandLines;
    }

}
