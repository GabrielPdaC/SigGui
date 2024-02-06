package com.gabrielpdc.sigercommandline.commands;

import java.util.ArrayList;

import com.gabrielpdc.sigercommandline.Interfaces.SigerCommandLines;
import com.gabrielpdc.sigercommandline.exceptions.SigerCommandLineException;
import com.gabrielpdc.sigercommandline.models.Term;
import com.gabrielpdc.sigercommandline.models.TermType;

/**
 * Classe {@code GoGlobal} responsável por gerar comandos de linha de comando
 * para a execução do GoGlobal. Implementa a interface {@code SigerCommandLines}
 * e fornece uma maneira simples de criar uma linha de comando que invoca o
 * script GoGlobal.bat.
 *
 * Esta classe é útil para situações onde é necessário iniciar o GoGlobal
 * dentro de um contexto de linha de comando, permitindo sua execução através
 * de scripts automatizados ou integrações de sistema.
 */
public final class GoGlobal implements SigerCommandLines {

    private static String GO_GLOBAL_RUNNER = "GoGlobal.bat";

    /**
     * Gera uma lista de {@code Term} representando o comando de linha de comando
     * para iniciar o GoGlobal.
     *
     * @return Uma lista de {@code Term} contendo o comando para executar o GoGlobal.
     * @throws SigerCommandLineException Se ocorrer um erro na geração do comando.
     */
    @Override
    public final ArrayList<Term> generateCommandLine() throws SigerCommandLineException {
        ArrayList<Term> commandLines = new ArrayList<>();
        commandLines.add(new Term(TermType.COMMAND, GO_GLOBAL_RUNNER));
        return commandLines;
    }

}
