package com.gabrielpdc.sigercommandline.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.gabrielpdc.sigercommandline.Execptions.SigerCommandLineException;
import com.gabrielpdc.sigercommandline.Interfaces.CommandLineBuilder;
import com.gabrielpdc.sigercommandline.decorators.Desktop;
import com.gabrielpdc.sigercommandline.decorators.GoGlobal;
import com.gabrielpdc.sigercommandline.decorators.Itc;
import com.gabrielpdc.sigercommandline.decorators.MultiTenant;
import com.gabrielpdc.sigercommandline.decorators.ServerWebClient;
import com.gabrielpdc.sigercommandline.decorators.Sig;
import com.gabrielpdc.sigercommandline.decorators.ThinClient;
import com.gabrielpdc.sigercommandline.decorators.VMLinux;
import com.gabrielpdc.sigercommandline.decorators.Itc.OperatingSystem;
import com.gabrielpdc.sigercommandline.decorators.ThinClient.Builder;
import com.gabrielpdc.sigercommandline.models.Term;
import com.gabrielpdc.sigercommandline.models.TermType;

public class CommandLineController {

    /* Arquitetura de execução */
    private Architecture architecture;

    public enum Architecture {
        DESKTOP,
        THIN_CLIENT,
        MULTI_TENANT;
    }

    // Server options
    private boolean serverIsPanel = false;
    private Optional<Integer> serverPort = Optional.empty();
    private boolean serverIsDebug = false;
    private boolean serverIs64 = false;
    private boolean serverIsJavaOutput = false;
    private boolean serverIsMultiTenant = false;
    private boolean serverIsWebClient = false;
    private OperatingSystem serverServerOperatingSystem = OperatingSystem.WINDOWS;

    // Client options
    private Optional<String> clientCompany = Optional.empty();
    private Optional<String> clientUser = Optional.empty();
    private Optional<String> clientPassword = Optional.empty();
    private Optional<String> clientMenu = Optional.empty();
    private boolean clientIsDebug = false;
    private boolean clientIsDebugJava = false;
    private boolean clientIsProfiler = false;
    private boolean clientIsWebClient = false;
    private boolean clientIsThinClient = false;
    private boolean clientIsGoGlobal = false;
    private Optional<Integer> clientThinClientPort = Optional.empty();

    /**
     * @param architecture
     */
    public CommandLineController(Architecture architecture) {
        this.architecture = architecture;
    }

    public ArrayList<String> generateCommandLine() throws SigerCommandLineException {
        CommandLineBuilder commandLineBuilder;
        if (architecture == Architecture.DESKTOP) {
            commandLineBuilder = generateDesktopCommandLine();
        } else {
            commandLineBuilder = generateThinClientCommandLine();
        }

        ArrayList<String> commandLines = new ArrayList<String>();
        StringBuilder commandLineStrBuilder = new StringBuilder();
        for (Term term : commandLineBuilder.build().generateCommandLine()) {

            if (term.getType()==TermType.COMMAND) {
                if (!commandLineStrBuilder.isEmpty()) {
                    commandLines.add(commandLineStrBuilder.toString());
                    commandLineStrBuilder = new StringBuilder();
                }
            } else {
                commandLineStrBuilder.append(" ");
            }
            commandLineStrBuilder.append(term.getTerm());
        }
        commandLines.add(commandLineStrBuilder.toString());
        return commandLines;
    }

    private CommandLineBuilder generateDesktopCommandLine() {
        Desktop.Builder desktopSigerCommandLines = Desktop.builder(sigBuilder());
        if (clientIsGoGlobal) {
            desktopSigerCommandLines.goGlobal(new GoGlobal());
        }
        return desktopSigerCommandLines;
    }

    private CommandLineBuilder generateThinClientCommandLine() {
        Builder commandLineBuilder = ThinClient.builder();

        if (serverIsMultiTenant) {
            commandLineBuilder = commandLineBuilder.multiTenant(multiTenantBuilder());
        } else if (serverIsWebClient) {
            commandLineBuilder = commandLineBuilder.serverWebClient(serverWebClientBuilder());
        } else {
            commandLineBuilder.sig(sigBuilder())
                              .itc(itcBuilder());
        }

        if (serverServerOperatingSystem==OperatingSystem.LINUX) {
            commandLineBuilder.vmLinux(new VMLinux());
        }

        return commandLineBuilder;
    }

    private Itc itcBuilder() {
        Itc.Builder itcBuilder = Itc.builder()
                .withPanel(serverIsPanel)
                .withDebug(serverIsDebug)
                .with64bits(serverIs64)
                .withJavaOutput(serverIsJavaOutput)
                .serverOperatingSystem(serverServerOperatingSystem);
        if (serverPort.isPresent()) {
            itcBuilder.port(serverPort.get());
        }
        return itcBuilder.build();
    }

    private Sig sigBuilder() {
        Sig.Builder sigBuilder = Sig.builder()
                .withDebug(clientIsDebug)
                .withDebugJava(clientIsDebugJava)
                .withProfiler(clientIsProfiler)
                .withWebClient(clientIsWebClient)
                .withThinClient(clientIsThinClient);
        if (clientCompany.isPresent()) {
            sigBuilder.company(clientCompany.get());
        }
        if (clientUser.isPresent()) {
            sigBuilder.user(clientUser.get());
        }

        if (clientPassword.isPresent()) {
            sigBuilder.password(clientPassword.get());
        }
        if (clientMenu.isPresent()) {
            sigBuilder.menu(clientMenu.get());
        }
        if (clientThinClientPort.isPresent()) {
            sigBuilder.thinClientPort(clientThinClientPort.get());
        }
        return sigBuilder.build();
    }

    private MultiTenant multiTenantBuilder() {
        MultiTenant.Builder multiTenantBuilder = MultiTenant.builder()
                .itc(itcBuilder())
                .sig(sigBuilder());
        return multiTenantBuilder.build();
    }

    private ServerWebClient serverWebClientBuilder() {
        return ServerWebClient.builder()
                .withDebugJava(clientIsDebugJava)
                .withJavaOutput(serverIsJavaOutput)
                .withShowInfo(serverIsJavaOutput)
                .build();
    }

    public CommandLineController setServerIsPanel(boolean serverIsPanel) {
        this.serverIsPanel = serverIsPanel;
        return this;
    }

    public CommandLineController setServerPort(Integer serverPort) {
        this.serverPort = Optional.of(serverPort);
        return this;
    }

    public CommandLineController setServerIsDebug(boolean serverIsDebug) {
        this.serverIsDebug = serverIsDebug;
        return this;
    }

    public CommandLineController setServerIs64(boolean serverIs64) {
        this.serverIs64 = serverIs64;
        return this;
    }

    public CommandLineController setServerIsJavaOutput(boolean serverIsJavaOutput) {
        this.serverIsJavaOutput = serverIsJavaOutput;
        return this;
    }

    public void setServerIsMultiTenant(boolean serverIsMultiTenant) {
        this.serverIsMultiTenant = serverIsMultiTenant;
    }

    public void setServerIsWebClient(boolean serverIsWebClient) {
        this.serverIsWebClient = serverIsWebClient;
    }

    public CommandLineController setServerServerOperatingSystem(OperatingSystem serverServerOperatingSystem) {
        this.serverServerOperatingSystem = serverServerOperatingSystem;
        return this;
    }

    public CommandLineController setClientCompany(String clientCompany) {
        this.clientCompany = Optional.of(clientCompany);
        return this;
    }

    public CommandLineController setClientUser(String clientUser) {
        this.clientUser = Optional.of(clientUser);
        return this;
    }

    public CommandLineController setClientPassword(String clientPassword) {
        this.clientPassword = Optional.of(clientPassword);
        return this;
    }

    public CommandLineController setClientMenu(String clientMenu) {
        this.clientMenu = Optional.of(clientMenu);
        return this;
    }

    public CommandLineController setClientIsDebug(boolean clientIsDebug) {
        this.clientIsDebug = clientIsDebug;
        return this;
    }

    public CommandLineController setClientIsDebugJava(boolean clientIsDebugJava) {
        this.clientIsDebugJava = clientIsDebugJava;
        return this;
    }

    public CommandLineController setClientIsProfiler(boolean clientIsProfiler) {
        this.clientIsProfiler = clientIsProfiler;
        return this;
    }

    public CommandLineController setClientIsWebClient(boolean clientIsWebClient) {
        this.clientIsWebClient = clientIsWebClient;
        return this;
    }

    public CommandLineController setClientIsThinClient(boolean clientIsThinClient) {
        this.clientIsThinClient = clientIsThinClient;
        return this;
    }

    public CommandLineController setClientIsGoGlobal(boolean clientIsGoGlobal) {
        this.clientIsGoGlobal = clientIsGoGlobal;
        return this;
    }

    public CommandLineController setClientThinClientPort(Integer clientThinClientPort) {
        this.clientThinClientPort = Optional.of(clientThinClientPort);
        return this;
    }

}
