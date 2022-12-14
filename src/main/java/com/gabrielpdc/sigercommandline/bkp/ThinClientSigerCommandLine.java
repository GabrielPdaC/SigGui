package com.gabrielpdc.sigercommandline.bkp;

import java.util.ArrayList;

import com.gabrielpdc.sigercommandline.SigerCommandLineException;
import com.gabrielpdc.sigercommandline.SigerCommandLines;

public class ThinClientSigerCommandLine implements SigerCommandLines {

    /* Script para executar o SIGER através do Web Client */
    static String WEB_CLIENT_RUNNER = "WEBCLIENT";
    /* Script para executar o server do SIGER */
    static String SIGER_SERVER_RUNNER = "itc";
    /* Script para executar o SIGER com ambiente Multi Tenant */
    static String SIGER_MULTI_TENANT_RUNNER = "mt";
    /* Parâmetro para executar o client como Thin Client */
    static String SIGER_THIN_CLIENT_RUNNER = "tc";
    /* Parâmetro para executar o client como Web Client */
    static String SIGER_WEB_CLIENT_RUNNER = "WebClient";

    /* Indica se o server é Multi Tenant */
    private boolean isServerMultiTenant;
    /* Sistema operacional para executar o server */
    private ServerOperatingSystem serverOperatingSystem;
    /* Tipo de execução do client */
    private ClientExecutionType clientExecutionType;

    public ThinClientSigerCommandLine() {
        this.isServerMultiTenant=false;
        this.serverOperatingSystem=ServerOperatingSystem.WINDOWS;
        this.clientExecutionType=ClientExecutionType.THIN_CLIENT;
    }

    @Override
    public SigerCommandLines setClientExecutionType(ClientExecutionType clientExecutionType)
            throws SigerCommandLineException {
        this.clientExecutionType=clientExecutionType;
        return this;
    }

    @Override
    public SigerCommandLines setServerMultiTenant(boolean isServerMultiTenant) throws SigerCommandLineException {
        this.isServerMultiTenant=isServerMultiTenant;
        return this;
    }

    @Override
    public SigerCommandLines setServerOperatingSystem(ServerOperatingSystem serverOperatingSystem)
            throws SigerCommandLineException {
        this.serverOperatingSystem=serverOperatingSystem;
        return this;
    }

    @Override
    public ArrayList<String> getCommandLine() throws SigerCommandLineException {
        ArrayList<String> commandLine = new ArrayList<>();
        if (isServerMultiTenant) {
            commandLine.add(SIGER_MULTI_TENANT_RUNNER + " " + SIGER_SERVER_RUNNER + " " + getServerOperatingSystem()
                    + " " + SIGER_RUNNER);
        } else {
            switch (clientExecutionType) {
                case THIN_CLIENT:
                    commandLine.add(SIGER_SERVER_RUNNER + getServerOperatingSystem());
                    commandLine.add(SIGER_RUNNER + " " + SIGER_THIN_CLIENT_RUNNER);
                    break;
                    case WEB_CLIENT:
                    commandLine.add(SIGER_SERVER_RUNNER + getServerOperatingSystem());
                    commandLine.add(SIGER_RUNNER + " " + SIGER_WEB_CLIENT_RUNNER);
                    break;
                case GO_GLOBAL:
                    commandLine.add(GO_GLOBAL_RUNNER);
                    break;
                default:
                    throw new SigerCommandLineException("Não foi indicado o modo de execução válido para o client");
            }
        }
        return commandLine;
    }

    /**
     * Retorna linha de comando concatenando sistema operacional
     *
     * @return String
     */
    String getServerOperatingSystem() {
        String commandLine = "";
        if (this.serverOperatingSystem == ServerOperatingSystem.LINUX) {
            commandLine = " linux";
        }
        return commandLine;
    }
}
