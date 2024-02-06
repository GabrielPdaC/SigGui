package com.gabrielpdc.sigercommandline.Interfaces;

import java.util.ArrayList;

import com.gabrielpdc.sigercommandline.Execptions.SigerCommandLineException;
import com.gabrielpdc.sigercommandline.models.Term;

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
    public ArrayList<Term> generateCommandLine() throws SigerCommandLineException;
}
