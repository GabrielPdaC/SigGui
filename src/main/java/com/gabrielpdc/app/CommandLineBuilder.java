package com.gabrielpdc.app;

import java.util.ArrayList;

public class CommandLineBuilder {

    /* Script para executar o SIGER */
    static String SIGER_RUNNER = "sig";
    /* Script para executar o server do SIGER */
    static String SIGER_SERVER_RUNNER = "itc";
    /* Script para executar o SIGER com ambiente  Multi Tenant */
    static String SIGER_MULTI_TENANT_RUNNER = "mt";

    /* Sistema operacional para executar o SIGER */
    public enum OperatingSystem {
        WINDOWS,
        LINUX;
    }

    /* Tipo de execução do SIGER */
    public enum ExecutionType {
        DESKTOP,
        THIN_CLIENT;
    }

    private boolean isMultiTenant = false;
    private OperatingSystem operatingSystem = OperatingSystem.WINDOWS;
    private ExecutionType executionType = ExecutionType.DESKTOP;

    /**
     * Indica que executa o SIGER desktop
     *
     * @return CommandLineBuilder
     */
    public CommandLineBuilder setDesktop(){
        this.executionType = ExecutionType.DESKTOP;
        this.isMultiTenant = false;
        return this;
    }

    /**
     * Indica que executa o SIGER no modo Thin Client
     *
     * @return CommandLineBuilder
     */
    public CommandLineBuilder setThinClient(){
        this.executionType = ExecutionType.THIN_CLIENT;
        return this;
    }

    /**
     * Indica que executa o SIGER no ambiente Multi Tenant
     *
     * @return CommandLineBuilder
     */
    public CommandLineBuilder setMultiTenant(){
        this.executionType = ExecutionType.THIN_CLIENT;
        this.isMultiTenant = true;
        return this;
    }

    /**
     * Indica qual sistema operacional para executar o SIGER
     *
     * @return CommandLineBuilder
     */
    public CommandLineBuilder setOPeratingSystem(OperatingSystem operatingSystem){
        if (operatingSystem==OperatingSystem.LINUX) {
            setThinClient();
        }
        this.operatingSystem = operatingSystem;
        return this;
    }

    /**
     * Retorna linha de comando para execução do SIGER
     *
     * @return ArrayList<String>
     */
    public ArrayList<String> getCommandLine() {
        ArrayList<String> commandLine = new ArrayList<>();
        if (executionType==ExecutionType.DESKTOP) {
            commandLine = getDesktopCommandLine();
        } else {
            commandLine = getThinClientCommandLine();
        }
        return commandLine;
    }

    /**
     * Retorna linha de comando para execução do SIGER no modo desktop
     *
     * @return ArrayList<String>
     */
    ArrayList<String> getDesktopCommandLine() {
        ArrayList<String> commandLine = new ArrayList<>();
        commandLine.add(SIGER_RUNNER);
        return commandLine;
    }

    /**
     * Retorna linha de comando para execução do SIGER no modo Thin Client
     *
     * @return ArrayList<String>
     */
    ArrayList<String> getThinClientCommandLine() {
        ArrayList<String> commandLine = new ArrayList<>();
        if (isMultiTenant) {
            commandLine.add(SIGER_MULTI_TENANT_RUNNER + " " + getServerRunnerOperatingSystem(SIGER_SERVER_RUNNER) + " " + SIGER_RUNNER);
        } else {
            commandLine.add(getServerRunnerOperatingSystem(SIGER_SERVER_RUNNER));
            commandLine.add(SIGER_RUNNER);
        }
        return commandLine;
    }

    /**
     * Retorna linha de comando concatenando sistema operacional
     *
     * @return String
     */
    String getServerRunnerOperatingSystem(String SigerServerRunner) {
        String commandLine = SigerServerRunner;
        if (this.operatingSystem==OperatingSystem.LINUX) {
            commandLine = commandLine + " linux";
        }
        return commandLine;
    }
}
