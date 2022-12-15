package com.gabrielpdc.sigercommandline.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.gabrielpdc.sigercommandline.models.DesktopSigerCommandLines;
import com.gabrielpdc.sigercommandline.models.Sig;
import com.gabrielpdc.sigercommandline.models.SigerCommandLineException;
import com.gabrielpdc.sigercommandline.models.SigerCommandLines;
import com.gabrielpdc.sigercommandline.models.ThinClientSigerCommandLines;
import com.gabrielpdc.sigercommandline.models.Itc.OperatingSystem;

public class SigerCommandLineController {

    /* Arquitetura de execução */
    private Architecture architecture;
    public enum Architecture {
        DESKTOP,
        THIN_CLIENT;
    }

    //Server options
    private boolean serverIsPanel;
    private Optional<Integer> serverPort;
    private boolean serverIsDebug;
    private boolean serverIs64;
    private boolean serverIsJavaOutput;
    private OperatingSystem serverServerOperatingSystem;

    //Server options
    private Optional<String> clientCompany;
    private Optional<String> clientUser;
    private Optional<String> clientPassword;
    private Optional<String> clientMenu;
    private boolean clientIsDebug;
    private boolean clientIsDebugJava;
    private boolean clientIsProfiler;
    private boolean clientIsWebClient;
    private boolean clientIsThinClient;
    private Optional<Integer> clientThinClientPort;

    public void setServerIsPanel(boolean serverIsPanel) {
        this.serverIsPanel = serverIsPanel;
    }

    public void setServerPort(Optional<Integer> serverPort) {
        this.serverPort = serverPort;
    }

    public void setServerIsDebug(boolean serverIsDebug) {
        this.serverIsDebug = serverIsDebug;
    }

    public void setServerIs64(boolean serverIs64) {
        this.serverIs64 = serverIs64;
    }

    public void setServerIsJavaOutput(boolean serverIsJavaOutput) {
        this.serverIsJavaOutput = serverIsJavaOutput;
    }

    public void setServerServerOperatingSystem(OperatingSystem serverServerOperatingSystem) {
        this.serverServerOperatingSystem = serverServerOperatingSystem;
    }

    public void setClientCompany(Optional<String> clientCompany) {
        this.clientCompany = clientCompany;
    }

    public void setClientUser(Optional<String> clientUser) {
        this.clientUser = clientUser;
    }

    public void setClientPassword(Optional<String> clientPassword) {
        this.clientPassword = clientPassword;
    }

    public void setClientMenu(Optional<String> clientMenu) {
        this.clientMenu = clientMenu;
    }

    public void setClientIsDebug(boolean clientIsDebug) {
        this.clientIsDebug = clientIsDebug;
    }

    public void setClientIsDebugJava(boolean clientIsDebugJava) {
        this.clientIsDebugJava = clientIsDebugJava;
    }

    public void setClientIsProfiler(boolean clientIsProfiler) {
        this.clientIsProfiler = clientIsProfiler;
    }

    public void setClientIsWebClient(boolean clientIsWebClient) {
        this.clientIsWebClient = clientIsWebClient;
    }

    public void setClientIsThinClient(boolean clientIsThinClient) {
        this.clientIsThinClient = clientIsThinClient;
    }

    public void setClientThinClientPort(Optional<Integer> clientThinClientPort) {
        this.clientThinClientPort = clientThinClientPort;
    }

    /* Linhas de comando para execução */
    private SigerCommandLines sigerCommandLine;

    /**
     * @param architecture
     */
    public SigerCommandLineController(Architecture architecture) {
        this.architecture = architecture;
        if (architecture == Architecture.DESKTOP) {
            sigerCommandLine = new DesktopSigerCommandLines.Builder(Sig.builder().build()).build();
        } else {
            sigerCommandLine = new ThinClientSigerCommandLines.Builder().build();
        }
    }

    public ArrayList<String> build() throws SigerCommandLineException {
        ArrayList<String> commandLines = new ArrayList<>();
        for (String commandLine : sigerCommandLine.generateCommandLine()) {
            commandLines.add(commandLine);
        }
        return commandLines;
    }

}
