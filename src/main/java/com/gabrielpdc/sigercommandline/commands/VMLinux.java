package com.gabrielpdc.sigercommandline.commands;

import java.util.ArrayList;

import com.gabrielpdc.sigercommandline.Interfaces.SigerCommandLines;
import com.gabrielpdc.sigercommandline.exceptions.SigerCommandLineException;
import com.gabrielpdc.sigercommandline.models.Term;
import com.gabrielpdc.sigercommandline.models.TermType;

/**
 * A classe {@code VMLinux} implementa a interface {@code SigerCommandLines}
 * para gerar comandos de linha de comando específicos para ambientes Linux
 * virtualizados.
 * <p>
 * Esta classe é responsável por encapsular a lógica necessária para criar
 * comandos de linha de comando que são usados para operações em máquinas
 * virtuais Linux. Ela utiliza o arquivo {@code VMLinux.bat} como parte do comando.
 * </p>
 */
public class VMLinux implements SigerCommandLines {

    /**
     * O caminho ou nome do script batch que é utilizado para executar comandos
     * em uma máquina virtual Linux.
     */
    private static String VM_LINUX_RUNNER = "VMLinux.bat";

    /**
     * Gera uma lista de comandos de linha de comando para execução em máquinas
     * virtuais Linux.
     *
     * @return Uma lista de {@link Term} representando os comandos de linha de
     *         comando a serem executados.
     * @throws SigerCommandLineException Se ocorrer um erro ao gerar os comandos
     *         de linha de comando.
     */
    @Override
    public ArrayList<Term> generateCommandLine() throws SigerCommandLineException {
        ArrayList<Term> commandLines = new ArrayList<Term>();
        commandLines.add(new Term(TermType.COMMAND, VM_LINUX_RUNNER));
        return commandLines;
    }

}
