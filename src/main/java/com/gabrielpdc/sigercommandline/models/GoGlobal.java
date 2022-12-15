package com.gabrielpdc.sigercommandline.models;

import java.util.ArrayList;

public final class GoGlobal implements SigerCommandLines {

    private static String GO_GLOBAL_RUNNER = "GoGlobal.bat";

    @Override
    public final ArrayList<String> generateCommandLine() throws SigerCommandLineException {
        ArrayList<String> commandLines = new ArrayList<>();
        commandLines.add(GO_GLOBAL_RUNNER);
        return commandLines;
    }

}
