package com.gabrielpdc.sigercommandline.commands;

import java.util.ArrayList;
import java.util.Optional;

import com.gabrielpdc.sigercommandline.Interfaces.CommandLineBuilder;
import com.gabrielpdc.sigercommandline.Interfaces.SigerCommandLines;
import com.gabrielpdc.sigercommandline.exceptions.SigerCommandLineException;
import com.gabrielpdc.sigercommandline.models.Term;

/**
 * A classe {@code ThinClient} implementa a interface {@code SigerCommandLines},
 * proporcionando uma maneira de construir linhas de comando para diversos ambientes
 * e configurações específicas através da combinação de componentes opcionais.
 * <p>
 * Esta classe suporta a inclusão condicional de componentes como {@code GoGlobal},
 * {@code VMLinux}, {@code MultiTenant}, {@code Itc}, {@code ServerWebClient} e {@code Sig}
 * para a geração dinâmica de comandos de linha de comando baseados nas necessidades específicas
 * de configuração.
 * </p>
 */
public class ThinClient implements SigerCommandLines {

    private final Optional<GoGlobal> goGlobal;
    private final Optional<VMLinux> vmLinux;
    private final Optional<MultiTenant> multiTenant;
    private final Optional<Itc> itc;
    private final Optional<ServerWebClient> serverWebClient;
    private final Optional<Sig> sig;

    /**
     * Constrói uma instância de {@code ThinClient} com componentes configuráveis opcionais.
     *
     * @param goGlobal          Um componente {@code GoGlobal} opcional.
     * @param vmLinux           Um componente {@code VMLinux} opcional.
     * @param multiTenant       Um componente {@code MultiTenant} opcional.
     * @param serverWebClient   Um componente {@code ServerWebClient} opcional.
     * @param itc               Um componente {@code Itc} opcional.
     * @param sig               Um componente {@code Sig} opcional.
     */
    public ThinClient(Optional<GoGlobal> goGlobal, Optional<VMLinux> vmLinux,
            Optional<MultiTenant> multiTenant, Optional<ServerWebClient> serverWebClient, Optional<Itc> itc,
            Optional<Sig> sig) {
        this.goGlobal = goGlobal;
        this.vmLinux = vmLinux;
        this.multiTenant = multiTenant;
        this.itc = itc;
        this.serverWebClient = serverWebClient;
        this.sig = sig;
    }

    /**
     * Cria um novo {@code Builder} para a construção de uma instância {@code ThinClient}.
     *
     * @return Uma nova instância de {@code Builder}.
     */
    public static Builder builder() {
        return new ThinClient.Builder();
    }

    /**
     * Gera uma lista de {@code Term} que representam comandos de linha de comando,
     * combinando os comandos dos componentes configurados.
     *
     * @return Uma lista de {@code Term} representando os comandos de linha de comando.
     * @throws SigerCommandLineException Se ocorrer um erro na geração dos comandos.
     */
    @Override
    public ArrayList<Term> generateCommandLine() throws SigerCommandLineException {
        ArrayList<Term> commandLines = new ArrayList<Term>();
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

    /**
     * A classe {@code Builder} auxilia na construção de uma instância {@code ThinClient}
     * de maneira fluente e configurável.
     */
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
        public ThinClient build() {
            return new ThinClient(goGlobal, vmLinux, multiTenant, serverWebClient, itc, sig);
        }
    }
}
