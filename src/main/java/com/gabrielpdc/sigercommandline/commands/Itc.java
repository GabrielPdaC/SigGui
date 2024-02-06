package com.gabrielpdc.sigercommandline.commands;

import java.util.ArrayList;
import java.util.Optional;

import com.gabrielpdc.sigercommandline.Interfaces.CommandLineBuilder;
import com.gabrielpdc.sigercommandline.Interfaces.SigerCommandLines;
import com.gabrielpdc.sigercommandline.exceptions.SigerCommandLineException;
import com.gabrielpdc.sigercommandline.models.Term;
import com.gabrielpdc.sigercommandline.models.TermType;

/**
 * Classe {@code Itc} responsável por construir linhas de comando para a execução
 * de servidores ITC com opções configuráveis como painel de controle, porta,
 * modo debug, arquitetura 64 bits, saída Java e sistema operacional do servidor.
 *
 * Esta classe final implementa a interface {@code SigerCommandLines} e suporta
 * a customização das linhas de comando através de um padrão Builder.
 */
public final class Itc implements SigerCommandLines {

    private static String ITC_RUNNER = "ITC.bat";
    private static String PANEL_PARAM = "PANEL";
    private static String PORT_PARAM = "PORT:";
    private static String DEBUG_PARAM = "D";
    private static String ARCH64_PARAM = "64";
    private static String JAVA_OUTPUT_PARAM = "EX";
    private static String LINUX_PARAM = "LINUX";

    private final boolean isPanel;
    private final Optional<Integer> port;
    private final boolean isDebug;
    private final boolean is64;
    private final boolean isJavaOutput;
    private final OperatingSystem serverOperatingSystem;

    /**
     * Enumeração de sistemas operacionais suportados para execução do servidor.
     */
    public enum OperatingSystem {
        WINDOWS,
        LINUX;
    }

    /**
     * Construtor da classe {@code Itc}.
     *
     * @param isPanel Indica se o painel de controle deve ser ativado.
     * @param port A porta na qual o servidor deve escutar.
     * @param isDebug Indica se o modo debug está ativado.
     * @param is64 Indica se a arquitetura 64 bits está ativada.
     * @param isJavaOutput Indica se a saída Java está ativada.
     * @param serverOperatingSystem O sistema operacional do servidor.
     */
    public Itc(boolean isPanel, Optional<Integer> port, boolean isDebug, boolean is64, boolean isJavaOutput,
            OperatingSystem serverOperatingSystem) {
        this.isPanel = isPanel;
        this.port = port;
        this.isDebug = isDebug;
        this.is64 = is64;
        this.isJavaOutput = isJavaOutput;
        this.serverOperatingSystem = serverOperatingSystem;
    }

    public static Builder builder() {
        return new Itc.Builder();
    }

    /**
     * Método para construir linhas de comando com as configurações especificadas.
     *
     * @return Uma lista de {@code Term} contendo os comandos de linha de comando.
     * @throws SigerCommandLineException Se ocorrer um erro na geração dos comandos.
     */
    @Override
    public ArrayList<Term> generateCommandLine() throws SigerCommandLineException {
        ArrayList<Term> commandLines = new ArrayList<Term>();
        commandLines.add(new Term(TermType.COMMAND, ITC_RUNNER));
        if (isPanel) {
            commandLines.add(new Term(TermType.PARAM, PANEL_PARAM));
        }
        if (port.isPresent()) {
            commandLines.add(new Term(TermType.PARAM, PORT_PARAM + port.get()));
        }
        if (isDebug) {
            commandLines.add(new Term(TermType.PARAM, DEBUG_PARAM));
        }
        if (is64) {
            commandLines.add(new Term(TermType.PARAM, ARCH64_PARAM));
        }
        if (isJavaOutput) {
            commandLines.add(new Term(TermType.PARAM, JAVA_OUTPUT_PARAM));
        }
        if (serverOperatingSystem == OperatingSystem.LINUX) {
            commandLines.add(new Term(TermType.PARAM, LINUX_PARAM));
        }
        return commandLines;
    }

    /**
     * Builder para a classe {@code Itc} que facilita a configuração e construção
     * de uma instância com opções específicas.
     */
    public static class Builder implements CommandLineBuilder {

        private boolean isPanel = false;
        private Optional<Integer> port = Optional.empty();
        private boolean isDebug = false;
        private boolean is64bits = false;
        private boolean isJavaOutput = false;
        private OperatingSystem serverOperatingSystem = OperatingSystem.WINDOWS;

        public Builder withPanel(boolean isPanel) {
            this.isPanel = isPanel;
            return this;
        }

        public Builder port(Integer port) {
            this.port = Optional.of(port);
            return this;
        }

        public Builder withDebug(boolean isDebug) {
            this.isDebug = isDebug;
            return this;
        }

        public Builder with64bits(boolean is64bits) {
            this.is64bits = is64bits;
            return this;
        }

        public Builder withJavaOutput(boolean isJavaOutput) {
            this.isJavaOutput = isJavaOutput;
            return this;
        }

        public Builder serverOperatingSystem(OperatingSystem serverOperatingSystem) {
            this.serverOperatingSystem = serverOperatingSystem;
            return this;
        }

        @Override
        public Itc build() {
            return new Itc(isPanel, port, isDebug, is64bits, isJavaOutput, serverOperatingSystem);
        }
    }

}
