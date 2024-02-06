package com.gabrielpdc.sigercommandline.Interfaces;

import java.util.ArrayList;

import com.gabrielpdc.sigercommandline.exceptions.SigerCommandLineException;
import com.gabrielpdc.sigercommandline.models.Term;

/**
 * Interface definindo o contrato para implementações que geram linhas de comando
 * para a execução de operações dentro do sistema SIGER.
 *
 * As implementações desta interface são responsáveis por construir uma lista de
 * {@code Term}, que juntos formam a linha de comando completa para execução de
 * uma operação específica no SIGER.
 */
public interface SigerCommandLines {

    /**
     * Gera e retorna uma lista de {@code Term}, representando os componentes da linha de
     * comando necessária para executar uma operação no SIGER.
     *
     * Este método permite a construção flexível de linhas de comando, possibilitando
     * a inclusão de parâmetros e configurações específicas conforme necessário.
     *
     * @return Uma lista de {@code Term} representando a linha de comando para execução.
     * @throws SigerCommandLineException Se ocorrer um problema na geração da linha de comando,
     *         uma exceção específica do sistema SIGER será lançada.
     */
    ArrayList<Term> generateCommandLine() throws SigerCommandLineException;
}
