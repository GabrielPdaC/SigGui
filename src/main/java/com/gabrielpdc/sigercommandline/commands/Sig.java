package com.gabrielpdc.sigercommandline.commands;

import java.util.ArrayList;
import java.util.Optional;

import com.gabrielpdc.sigercommandline.Interfaces.CommandLineBuilder;
import com.gabrielpdc.sigercommandline.Interfaces.SigerCommandLines;
import com.gabrielpdc.sigercommandline.exceptions.SigerCommandLineException;
import com.gabrielpdc.sigercommandline.models.Term;
import com.gabrielpdc.sigercommandline.models.TermType;

public final class Sig implements SigerCommandLines {

    private static final String SIG_RUNNER = "Sig.bat";
    private static final String USER_PARAM = "VS-USUARI:";
    private static final String PASSWORD_PARAM = "VS-SENUSU:";
    private static final String COMPANY_PARAM = "VS-SIGEMP:";
    private static final String MENU_PARAM = "VS-OPCMEN:";
    private static final String DEBUG_PARAM = "D";
    private static final String DEBUG_JAVA_PARAM = "DJ";
    private static final String PROFILER_JAVA_PARAM = "PJ";
    private static final String WEB_CLIENT_PARAM = "WEBCLI";
    private static final String THIN_CLIENT_PARAM = "TC";
    private static final String THIN_CLIENT_PORT_PARAM = "TCPORT:";

    private final Optional<String> company;
    private final Optional<String> user;
    private final Optional<String> password;
    private final Optional<String> menu;
    private final boolean isDebug;
    private final boolean isDebugJava;
    private final boolean isProfiler;
    private final boolean isWebClient;
    private final boolean isThinClient;
    private final Optional<Integer> thinClientPort;

    /**
     * A classe {@code Sig} implementa a interface {@code SigerCommandLines} para
     * fornecer uma maneira configurável de gerar linhas de comando para o SIGER,
     * suportando diversas opções como usuário, senha, empresa, menu, modos de depuração
     * e cliente web ou thin client.
     * <p>
     * Esta classe utiliza um padrão Builder para facilitar a configuração das diversas
     * opções disponíveis.
     * </p>
     */
    public Sig(Optional<String> company, Optional<String> user, Optional<String> password, Optional<String> menu,
            boolean isDebug, boolean isDebugJava, boolean isProfiler, boolean isWebClient, boolean isThinClient,
            Optional<Integer> thinClientPort) {
        this.company = company;
        this.user = user;
        this.password = password;
        this.menu = menu;
        this.isDebug = isDebug;
        this.isDebugJava = isDebugJava;
        this.isProfiler = isProfiler;
        this.isWebClient = isWebClient;
        this.isThinClient = isThinClient;
        this.thinClientPort = thinClientPort;
    }

    /**
     * Cria um novo {@code Builder} para a construção de uma instância {@code Sig}.
     *
     * @return Uma nova instância de {@code Builder}.
     */
    public static Builder builder() {
        return new Sig.Builder();
    }

    /**
     * Gera uma lista de {@code Term} que representam os comandos de linha de comando,
     * com base nas configurações fornecidas.
     *
     * @return Uma lista de {@code Term} representando os comandos de linha de comando.
     * @throws SigerCommandLineException Se ocorrer um erro na geração dos comandos.
     */
    @Override
    public final ArrayList<Term> generateCommandLine() throws SigerCommandLineException {
        ArrayList<Term> commandLines = new ArrayList<Term>();
        commandLines.add(new Term(TermType.COMMAND, SIG_RUNNER));
        if (user.isPresent()) {
            commandLines.add(new Term(TermType.PARAM, USER_PARAM + user.get()));
        }
        if (password.isPresent()) {
            commandLines.add(new Term(TermType.PARAM, PASSWORD_PARAM + password.get()));
        }
        if (company.isPresent()) {
            commandLines.add(new Term(TermType.PARAM, COMPANY_PARAM + company.get()));
        }
        if (menu.isPresent()) {
            commandLines.add(new Term(TermType.PARAM, MENU_PARAM + menu.get()));
        }
        if (isDebug) {
            commandLines.add(new Term(TermType.PARAM, DEBUG_PARAM));
        }
        if (isDebugJava) {
            commandLines.add(new Term(TermType.PARAM, DEBUG_JAVA_PARAM));
        }
        if (isProfiler) {
            commandLines.add(new Term(TermType.PARAM, PROFILER_JAVA_PARAM));
        }
        if (isWebClient) {
            commandLines.add(new Term(TermType.PARAM, WEB_CLIENT_PARAM));
        }
        if (isThinClient) {
            commandLines.add(new Term(TermType.PARAM, THIN_CLIENT_PARAM));
        }
        if (thinClientPort.isPresent()) {
            commandLines.add(new Term(TermType.PARAM, THIN_CLIENT_PORT_PARAM + thinClientPort.get()));
        }
        return commandLines;
    }

    /**
     * A classe {@code Builder} para {@code Sig} facilita a configuração e construção
     * de uma instância {@code Sig} com opções específicas de linha de comando.
     */
    public static final class Builder implements CommandLineBuilder  {

        private Optional<String> company = Optional.empty();
        private Optional<String> user = Optional.empty();
        private Optional<String> password = Optional.empty();
        private Optional<String> menu = Optional.empty();
        private boolean isDebug = false;
        private boolean isDebugJava = false;
        private boolean isProfiler = false;
        private boolean isWebClient = false;
        private boolean isThinClient = false;
        private Optional<Integer> thinClientPort = Optional.empty();

        public Builder user(String user) {
            this.user = Optional.of(user);
            return this;
        }

        public Builder password(String password) {
            this.password = Optional.of(password);
            return this;
        }

        public Builder company(String company) {
            this.company = Optional.of(company);
            return this;
        }

        public Builder menu(String menu) {
            this.menu = Optional.of(menu);
            return this;
        }

        public Builder withDebug(boolean isDebug) {
            this.isDebug = isDebug;
            return this;
        }

        public Builder withDebugJava(boolean isDebugJava) {
            this.isDebugJava = isDebugJava;
            return this;
        }

        public Builder withProfiler(boolean isProfiler) {
            this.isProfiler = isProfiler;
            return this;
        }

        public Builder withWebClient(boolean isWebClient) {
            this.isWebClient = isWebClient;
            return this;
        }

        public Builder withThinClient(boolean isThinClient) {
            this.isThinClient = isThinClient;
            return this;
        }

        public Builder thinClientPort(Integer thinClientPort) {
            this.thinClientPort = Optional.of(thinClientPort);
            return this;
        }

        @Override
        public Sig build() {
            return new Sig(company, user, password, menu, isDebug, isDebugJava, isProfiler, isWebClient, isThinClient, thinClientPort);
        }
    }
}
