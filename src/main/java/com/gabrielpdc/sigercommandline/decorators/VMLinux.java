package com.gabrielpdc.sigercommandline.decorators;

import java.util.ArrayList;

import com.gabrielpdc.sigercommandline.Execptions.SigerCommandLineException;
import com.gabrielpdc.sigercommandline.Interfaces.SigerCommandLines;
import com.gabrielpdc.sigercommandline.models.Term;
import com.gabrielpdc.sigercommandline.models.TermType;

public class VMLinux implements SigerCommandLines {

    private static String VM_LINUX_RUNNER = "VMLinux.bat";

    @Override
    public ArrayList<Term> generateCommandLine() throws SigerCommandLineException {
        ArrayList<Term> commandLines = new ArrayList<Term>();
        commandLines.add(new Term(TermType.COMMAND, VM_LINUX_RUNNER));
        return commandLines;
    }

}
