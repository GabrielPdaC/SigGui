package com.gabrielpdc.sigercommandline;

import java.util.ArrayList;
import java.util.Optional;

public final class Sig implements SigerCommandLines {

    private static final String SIG_RUNNER = "Sig.bat";
    private static final String USER_PARAM = "VS-USUARI:";
    private static final String PASSWORD_PARAM = "VS-SENUSU:";
    private static final String COMPANY_PARAM = "VS-SIGEMP:";
    private static final String MENU_PARAM = "VS-OPCMEN:";
    private static final String DEBUG_PARAM = "D";
    private static final String WEB_CLIENT_PARAM = "WEBCLI";
    private static final String THIN_CLIENT_PARAM = "TC";
    private static final String THIN_CLIENT_PORT_PARAM = "TCPORT:";

    private final Optional<String> company;
    private final Optional<String> user;
    private final Optional<String> password;
    private final Optional<String> menu;
    private final boolean isDebug;
    private final boolean isWebClient;
    private final boolean isThinClient;
    private final Optional<Integer> thinClientPort;

    public Sig(Optional<String> company, Optional<String> user, Optional<String> password, Optional<String> menu, boolean isDebug, boolean isWebClient, boolean isThinClient, Optional<Integer> thinClientPort) {
        this.company = company;
        this.user = user;
        this.password = password;
        this.menu = menu;
        this.isDebug = isDebug;
        this.isWebClient = isWebClient;
        this.isThinClient = isThinClient;
        this.thinClientPort = thinClientPort;
    }

    public static Builder builder() {
        return new Sig.Builder();
    }

    @Override
    public final ArrayList<String> generateCommandLine() throws SigerCommandLineException {
        ArrayList<String> commandLines = new ArrayList<>();
        commandLines.add(SIG_RUNNER);
        if (user.isPresent()) {
            commandLines.add(USER_PARAM + user.get());
        }
        if (password.isPresent()) {
            commandLines.add(PASSWORD_PARAM + password.get());
        }
        if (company.isPresent()) {
            commandLines.add(COMPANY_PARAM + company.get());
        }
        if (menu.isPresent()) {
            commandLines.add(MENU_PARAM + menu.get());
        }
        if (isDebug) {
            commandLines.add(DEBUG_PARAM);
        }
        if (isWebClient) {
            commandLines.add(WEB_CLIENT_PARAM);
        }
        if (isThinClient) {
            commandLines.add(THIN_CLIENT_PARAM);
        }
        if (thinClientPort.isPresent()) {
            commandLines.add(THIN_CLIENT_PORT_PARAM + thinClientPort.get());
        }
        return commandLines;
    }

    public static final class Builder {

        private Optional<String> company = Optional.empty();
        private Optional<String> user = Optional.empty();
        private Optional<String> password = Optional.empty();
        private Optional<String> menu = Optional.empty();
        private boolean isDebug = false;
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

        public Builder isDebug(boolean isDebug) {
            this.isDebug = isDebug;
            return this;
        }

        public Builder isWebClient(boolean isWebClient) {
            this.isWebClient = isWebClient;
            return this;
        }

        public Builder isThinClient(boolean isThinClient) {
            this.isThinClient = isThinClient;
            return this;
        }

        public Builder thinClientPort(Integer thinClientPort) {
            this.thinClientPort = Optional.of(thinClientPort);
            return this;
        }

        public Sig build() {
            return new Sig(company, user, password, menu, isDebug, isWebClient, isThinClient, thinClientPort);
        }
    }
}
