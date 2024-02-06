package com.gabrielpdc.sigercommandline.commands;

import java.util.ArrayList;

import com.gabrielpdc.sigercommandline.Interfaces.CommandLineBuilder;
import com.gabrielpdc.sigercommandline.Interfaces.SigerCommandLines;
import com.gabrielpdc.sigercommandline.exceptions.SigerCommandLineException;
import com.gabrielpdc.sigercommandline.models.Term;
import com.gabrielpdc.sigercommandline.models.TermType;

/**
 * A classe {@code ServerWebClient} implementa a interface {@code SigerCommandLines}
 * para gerar linhas de comando específicas para configuração e execução do servidor
 * web cliente, oferecendo opções para exibição de informações, saída de debug Java,
 * entre outras.
 *
 * Esta classe permite a configuração de diversos parâmetros que influenciam o
 * comportamento do servidor web cliente, como a exibição de informações, saída
 * de execução Java, modo de debug Java e operação em modo trunk.
 */
public final class ServerWebClient implements SigerCommandLines {

    private static String SERVER_WC_RUNNER = "SRVWC.bat";
    private static String SHOW_INFO_PARAM = "INF";
    private static String JAVA_OUTPUT_PARAM = "EX";
    private static String DEBUG_JAVA_PARAM = "DJ";
    private static String TRUNK_PARAM = "/F";

    private final boolean isShowInfo;
    private final boolean isJavaOutput;
    private final boolean isDebugJava;
    private final boolean isTrunk;

    /**
     * Construtor que inicializa uma nova instância de {@code ServerWebClient} com
     * configurações para exibição de informações, saída Java, debug Java e modo trunk.
     *
     * @param isShowInfo Se verdadeiro, ativa a exibição de informações.
     * @param isJavaOutput Se verdadeiro, ativa a saída Java.
     * @param isDebugJava Se verdadeiro, ativa o debug Java.
     * @param isTrunk Se verdadeiro, opera no modo trunk.
     */
    public ServerWebClient(boolean isShowInfo, boolean isJavaOutput, boolean isDebugJava, boolean isTrunk) {
        this.isShowInfo = isShowInfo;
        this.isJavaOutput = isJavaOutput;
        this.isDebugJava = isDebugJava;
        this.isTrunk = isTrunk;
    }

    /**
     * Cria um novo {@code Builder} para facilitar a configuração e construção de uma
     * instância {@code ServerWebClient}.
     *
     * @return Uma nova instância de {@code Builder}.
     */
    public static Builder builder() {
        return new ServerWebClient.Builder();
    }

    /**
     * Gera uma lista de {@code Term} representando os comandos de linha de comando
     * para o servidor web cliente com base nas configurações especificadas.
     *
     * @return Uma lista de {@code Term} com os comandos de linha de comando.
     * @throws SigerCommandLineException Se ocorrer um erro ao gerar os comandos.
     */
    @Override
    public ArrayList<Term> generateCommandLine() throws SigerCommandLineException {
        ArrayList<Term> commandLines = new ArrayList<Term>();
        commandLines.add(new Term(TermType.COMMAND, SERVER_WC_RUNNER));
        if (isShowInfo){
            commandLines.add(new Term(TermType.PARAM, SHOW_INFO_PARAM));
        }
        if (isJavaOutput){
            commandLines.add(new Term(TermType.PARAM, JAVA_OUTPUT_PARAM));
        }
        if (isDebugJava){
            commandLines.add(new Term(TermType.PARAM, DEBUG_JAVA_PARAM));
        }
        if (isTrunk){
            commandLines.add(new Term(TermType.PARAM, TRUNK_PARAM));
        }
        return commandLines;
    }

    /**
     * A classe {@code Builder} para {@code ServerWebClient} fornece uma interface fluente
     * para configurar e construir uma instância de {@code ServerWebClient} com as opções
     * desejadas.
     */
    public static class Builder implements CommandLineBuilder {

        private boolean isShowInfo = false;
        private boolean isJavaOutput = false;
        private boolean isDebugJava = false;
        private boolean isTrunk = false;

        public Builder withShowInfo(boolean isShowInfo) {
            this.isShowInfo = isShowInfo;
            return this;
        }

        public Builder withJavaOutput(boolean isJavaOutput) {
            this.isJavaOutput = isJavaOutput;
            return this;
        }

        public Builder withDebugJava(boolean isDebugJava) {
            this.isDebugJava = isDebugJava;
            return this;
        }

        public Builder withTrunk(boolean isTrunk) {
            this.isTrunk = isTrunk;
            return this;
        }

        @Override
        public ServerWebClient build() {
            return new ServerWebClient(isShowInfo, isJavaOutput, isDebugJava, isTrunk);
        }
    }
}
