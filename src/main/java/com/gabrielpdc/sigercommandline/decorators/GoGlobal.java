package com.gabrielpdc.sigercommandline.decorators;

import java.util.ArrayList;

import com.gabrielpdc.sigercommandline.Execptions.SigerCommandLineException;
import com.gabrielpdc.sigercommandline.Interfaces.SigerCommandLines;
import com.gabrielpdc.sigercommandline.models.Term;
import com.gabrielpdc.sigercommandline.models.TermType;

public final class GoGlobal implements SigerCommandLines {

    private static String GO_GLOBAL_RUNNER = "GoGlobal.bat";

    @Override
    public final ArrayList<Term> generateCommandLine() throws SigerCommandLineException {
        ArrayList<Term> commandLines = new ArrayList<>();
        commandLines.add(new Term(TermType.COMMAND, GO_GLOBAL_RUNNER));
        return commandLines;
    }

}
