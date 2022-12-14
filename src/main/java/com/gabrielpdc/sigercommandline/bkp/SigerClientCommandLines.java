package com.gabrielpdc.sigercommandline.bkp;

import java.util.ArrayList;

import com.gabrielpdc.sigercommandline.SigerCommandLineException;
import com.gabrielpdc.sigercommandline.SigerCommandLines;

public class SigerClientCommandLines implements SigerCommandLines {

    private ArrayList<SigerCommandLines> commandLines;

    public SigerClientCommandLines() {
        this.commandLines = new ArrayList<>();
    }

    @Override
    public ArrayList<String> buildCommandLine() throws SigerCommandLineException {
        ArrayList<String> commandLines = new ArrayList<>();
        for (SigerCommandLines sigerCommandLines: this.commandLines) {
            for (String commandLine: sigerCommandLines.buildCommandLine()) {
                commandLines.add(commandLine);
            }
        }
        return commandLines;
    }
}
