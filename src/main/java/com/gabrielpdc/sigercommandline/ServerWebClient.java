package com.gabrielpdc.sigercommandline;

import java.util.ArrayList;

public class ServerWebClient implements SigerCommandLines {

    private static String SERVER_WC_RUNNER = "SRVWC.bat";


    @Override
    public ArrayList<String> generateCommandLine() throws SigerCommandLineException {
                ArrayList<String> commandLines = new ArrayList<>();
        commandLines.add(SERVER_WC_RUNNER);
        return commandLines;

        //todo: Continuar aqui
    }

}
