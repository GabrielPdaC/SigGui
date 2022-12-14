package com.gabrielpdc.sigercommandline.bkp;

import java.util.ArrayList;

import com.gabrielpdc.sigercommandline.SigerCommandLineException;
import com.gabrielpdc.sigercommandline.SigerCommandLines;

public class SigCommandLines implements SigerCommandLines {

    /* Script para executar o SIGER */
    static String SIGER_RUNNER = "sig";

    /* Tipo de execução do client */
    public enum ClientExecutionType {
        THIN_CLIENT,
        WEB_CLIENT,
        GO_GLOBAL;
    }

    @Override
    public ArrayList<String> generateCommandLine() throws SigerCommandLineException {
        ArrayList<String> commandLines = new ArrayList<>();
        commandLines.add(SIGER_RUNNER);
        return commandLines;
    }

}
