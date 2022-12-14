package com.gabrielpdc.sigercommandline.models;

import java.util.ArrayList;
import java.util.Optional;

public class ThinClientSigerCommandLines implements SigerCommandLines {

    private final Optional<GoGlobal> goGlobal;
    private final Optional<VMLinux> vmLinux;
    private final Optional<MultiTenant> multiTenant;
    private final Optional<Itc> itc;
    private final Optional<ServerWebClient> serverWebClient;
    private final Optional<Sig> sig;

    public ThinClientSigerCommandLines(Optional<GoGlobal> goGlobal, Optional<VMLinux> vmLinux,
            Optional<MultiTenant> multiTenant, Optional<ServerWebClient> serverWebClient, Optional<Itc> itc,
            Optional<Sig> sig) {
        this.goGlobal = goGlobal;
        this.vmLinux = vmLinux;
        this.multiTenant = multiTenant;
        this.itc = itc;
        this.serverWebClient = serverWebClient;
        this.sig = sig;
    }

    public static Builder builder() {
        return new ThinClientSigerCommandLines.Builder();
    }

    @Override
    public ArrayList<String> generateCommandLine() throws SigerCommandLineException {
        ArrayList<String> commandLines = new ArrayList<>();
        if (goGlobal.isPresent()) {
            commandLines.addAll(goGlobal.get().generateCommandLine());
        }
        if (vmLinux.isPresent()) {
            commandLines.addAll(vmLinux.get().generateCommandLine());
        }
        if (multiTenant.isPresent()) {
            commandLines.addAll(multiTenant.get().generateCommandLine());
        }
        if (itc.isPresent()) {
            commandLines.addAll(itc.get().generateCommandLine());
        }
        if (serverWebClient.isPresent()) {
            commandLines.addAll(serverWebClient.get().generateCommandLine());
        }
        if (sig.isPresent()) {
            commandLines.addAll(sig.get().generateCommandLine());
        }
        return commandLines;
    }

    public static class Builder implements CommandLineBuilder  {

        private Optional<GoGlobal> goGlobal = Optional.empty();
        private Optional<VMLinux> vmLinux = Optional.empty();
        private Optional<MultiTenant> multiTenant = Optional.empty();
        private Optional<Itc> itc = Optional.empty();
        private Optional<ServerWebClient> serverWebClient = Optional.empty();
        private Optional<Sig> sig = Optional.empty();

        public Builder goGlobal(GoGlobal goGlobal) {
            this.goGlobal = Optional.of(goGlobal);
            return this;
        }

        public Builder vmLinux(VMLinux vmLinux) {
            this.vmLinux = Optional.of(vmLinux);
            return this;
        }

        public Builder multiTenant(MultiTenant multiTenant) {
            this.multiTenant = Optional.of(multiTenant);
            return this;
        }

        public Builder itc(Itc itc) {
            this.itc = Optional.of(itc);
            return this;
        }

        public Builder serverWebClient(ServerWebClient serverWebClient) {
            this.serverWebClient = Optional.of(serverWebClient);
            return this;
        }

        public Builder sig(Sig sig) {
            this.sig = Optional.of(sig);
            return this;
        }

        @Override
        public ThinClientSigerCommandLines build() {
            return new ThinClientSigerCommandLines(goGlobal, vmLinux, multiTenant, serverWebClient, itc, sig);
        }
    }
}
