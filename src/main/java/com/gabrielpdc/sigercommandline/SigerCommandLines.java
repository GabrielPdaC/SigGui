package com.gabrielpdc.sigercommandline;

import java.util.ArrayList;

/**
 * Interface para implementar linha de comando para execução do SIGER
 */
public interface SigerCommandLines {

    /**
     * Constrói linha de comando para execução
     *
     * @return linha de comando para execução
     * @throws SigerCommandLineException
     */
    public ArrayList<String> buildCommandLine() throws SigerCommandLineException;
}
