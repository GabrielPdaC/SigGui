package com.gabrielpdc.sigercommandline.models;

import java.util.ArrayList;

public class VMLinux implements SigerCommandLines {

    private static String VM_LINUX_RUNNER = "VMLinux.bat";

    @Override
    public ArrayList<String> generateCommandLine() throws SigerCommandLineException {
        ArrayList<String> commandLines = new ArrayList<>();
        commandLines.add(VM_LINUX_RUNNER);
        return commandLines;
    }

}
