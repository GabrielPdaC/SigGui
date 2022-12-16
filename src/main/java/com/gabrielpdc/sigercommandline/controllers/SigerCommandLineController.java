package com.gabrielpdc.sigercommandline.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.gabrielpdc.sigercommandline.models.CommandLineBuilder;
import com.gabrielpdc.sigercommandline.models.DesktopSigerCommandLines;
import com.gabrielpdc.sigercommandline.models.GoGlobal;
import com.gabrielpdc.sigercommandline.models.Itc;
import com.gabrielpdc.sigercommandline.models.MultiTenant;
import com.gabrielpdc.sigercommandline.models.ServerWebClient;
import com.gabrielpdc.sigercommandline.models.Sig;
import com.gabrielpdc.sigercommandline.models.SigerCommandLineException;
import com.gabrielpdc.sigercommandline.models.ThinClientSigerCommandLines;
import com.gabrielpdc.sigercommandline.models.VMLinux;
import com.gabrielpdc.sigercommandline.models.Itc.OperatingSystem;

public class SigerCommandLineController {

    /* Arquitetura de execução */
    private Architecture architecture;

    public enum Architecture {
        DESKTOP,
        THIN_CLIENT;
    }

    // Server options
    private boolean serverIsPanel = false;
    private Optional<Integer> serverPort = Optional.empty();
    private boolean serverIsDebug = false;
    private boolean serverIs64 = false;
    private boolean serverIsJavaOutput = false;
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
    public SigerCommandLineController(Architecture architecture) {
        this.architecture = architecture;
    }

    public ArrayList<String> generateCommandLine() throws SigerCommandLineException {
        CommandLineBuilder commandLineBuilder;
        if (architecture == Architecture.DESKTOP) {
            commandLineBuilder = generateDesktopCommandLine();
        } else {
            commandLineBuilder = generateThinClientCommandLine();
        }
        return commandLineBuilder.build().generateCommandLine();
    }

    private CommandLineBuilder generateDesktopCommandLine() {
        DesktopSigerCommandLines.Builder desktopSigerCommandLines = DesktopSigerCommandLines.builder(sigBuilder());
        if (clientIsGoGlobal) {
            desktopSigerCommandLines.goGlobal(new GoGlobal());
        }
        return desktopSigerCommandLines;
    }

    private CommandLineBuilder generateThinClientCommandLine() {
        return ThinClientSigerCommandLines.builder()
                .sig(sigBuilder())
                .serverWebClient(serverWebClientBuilder())
                .multiTenant(multiTenantBuilder())
                .vmLinux(new VMLinux())
                .itc(itcBuilder());
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

    public SigerCommandLineController setServerIsPanel(boolean serverIsPanel) {
        this.serverIsPanel = serverIsPanel;
        return this;
    }

    public SigerCommandLineController setServerPort(Integer serverPort) {
        this.serverPort = Optional.of(serverPort);
        return this;
    }

    public SigerCommandLineController setServerIsDebug(boolean serverIsDebug) {
        this.serverIsDebug = serverIsDebug;
        return this;
    }

    public SigerCommandLineController setServerIs64(boolean serverIs64) {
        this.serverIs64 = serverIs64;
        return this;
    }

    public SigerCommandLineController setServerIsJavaOutput(boolean serverIsJavaOutput) {
        this.serverIsJavaOutput = serverIsJavaOutput;
        return this;
    }

    public SigerCommandLineController setServerServerOperatingSystem(OperatingSystem serverServerOperatingSystem) {
        this.serverServerOperatingSystem = serverServerOperatingSystem;
        return this;
    }

    public SigerCommandLineController setClientCompany(String clientCompany) {
        this.clientCompany = Optional.of(clientCompany);
        return this;
    }

    public SigerCommandLineController setClientUser(String clientUser) {
        this.clientUser = Optional.of(clientUser);
        return this;
    }

    public SigerCommandLineController setClientPassword(String clientPassword) {
        this.clientPassword = Optional.of(clientPassword);
        return this;
    }

    public SigerCommandLineController setClientMenu(String clientMenu) {
        this.clientMenu = Optional.of(clientMenu);
        return this;
    }

    public SigerCommandLineController setClientIsDebug(boolean clientIsDebug) {
        this.clientIsDebug = clientIsDebug;
        return this;
    }

    public SigerCommandLineController setClientIsDebugJava(boolean clientIsDebugJava) {
        this.clientIsDebugJava = clientIsDebugJava;
        return this;
    }

    public SigerCommandLineController setClientIsProfiler(boolean clientIsProfiler) {
        this.clientIsProfiler = clientIsProfiler;
        return this;
    }

    public SigerCommandLineController setClientIsWebClient(boolean clientIsWebClient) {
        this.clientIsWebClient = clientIsWebClient;
        return this;
    }

    public SigerCommandLineController setClientIsThinClient(boolean clientIsThinClient) {
        this.clientIsThinClient = clientIsThinClient;
        return this;
    }

    public SigerCommandLineController setClientIsGoGlobal(boolean clientIsGoGlobal) {
        this.clientIsGoGlobal = clientIsGoGlobal;
        return this;
    }

    public SigerCommandLineController setClientThinClientPort(Integer clientThinClientPort) {
        this.clientThinClientPort = Optional.of(clientThinClientPort);
        return this;
    }

}
