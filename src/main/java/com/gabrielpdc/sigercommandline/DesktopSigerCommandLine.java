package com.gabrielpdc.sigercommandline;

import java.util.ArrayList;

import com.gabrielpdc.sigercommandline.bkp.GoGlobalCommandLines;
import com.gabrielpdc.sigercommandline.bkp.SigCommandLines;

public class DesktopSigerCommandLine implements SigerCommandLines {

    private ArrayList<SigerCommandLines> commandLines;

    public DesktopSigerCommandLine(boolean isGoGlobal) {
        this.commandLines = new ArrayList<>();
        if (isGoGlobal) {
            commandLines.add(new GoGlobalCommandLines());
        }
        commandLines.add(new SigCommandLines());
    }

    @Override
    public ArrayList<String> buildCommandLine() throws SigerCommandLineException {
        return null;
    }


}
