package com.gabrielpdc.sigercommandline.commands;

import java.util.ArrayList;
import java.util.Optional;

import com.gabrielpdc.sigercommandline.Interfaces.CommandLineBuilder;
import com.gabrielpdc.sigercommandline.Interfaces.SigerCommandLines;
import com.gabrielpdc.sigercommandline.exceptions.SigerCommandLineException;
import com.gabrielpdc.sigercommandline.models.Term;
import com.gabrielpdc.sigercommandline.models.TermType;

/**
 * A classe {@code MultiTenant} implementa a interface {@code SigerCommandLines} para
 * fornecer uma maneira de gerar linhas de comando para ambientes multi-tenant. Esta classe
 * suporta a inclusão opcional de componentes {@code Sig} e {@code Itc} para a geração de
 * comandos de linha de comando específicos.
 *
 * É projetada para ser flexível, permitindo a configuração de diferentes componentes
 * através de um padrão Builder, o que facilita a integração e customização dos comandos
 * de linha de comando gerados para necessidades específicas de implantação multi-tenant.
 */
public class MultiTenant implements SigerCommandLines {

    private static String MULTI_TENANT_RUNNER = "MT.bat";

    private final Optional<Sig> sig;
    private final Optional<Itc> itc;

    /**
     * Construtor que inicializa uma nova instância de {@code MultiTenant} com os
     * componentes {@code Sig} e {@code Itc} configuráveis de forma opcional.
     *
     * @param sig O componente {@code Sig} opcional.
     * @param itc O componente {@code Itc} opcional.
     */
    public MultiTenant(Optional<Sig> sig, Optional<Itc> itc) {
        this.sig = sig;
        this.itc = itc;
    }

    /**
     * Cria um novo {@code Builder} para facilitar a configuração e construção de uma
     * instância {@code MultiTenant}.
     *
     * @return Uma nova instância de {@code Builder}.
     */
    public static Builder builder() {
        return new MultiTenant.Builder();
    }

    /**
     * Gera uma lista de {@code Term} que representam os comandos de linha de comando
     * para o ambiente multi-tenant, integrando comandos dos componentes {@code Sig} e
     * {@code Itc} se estiverem presentes.
     *
     * @return Uma lista de {@code Term} com os comandos de linha de comando.
     * @throws SigerCommandLineException Se ocorrer um erro ao gerar os comandos.
     */
    @Override
    public ArrayList<Term> generateCommandLine() throws SigerCommandLineException {
        ArrayList<Term> commandLines = new ArrayList<Term>();
        commandLines.add(new Term(TermType.COMMAND, MULTI_TENANT_RUNNER));
        if (itc.isPresent()) {
            commandLines.addAll(itc.get().generateCommandLine());
        }
        if (sig.isPresent()) {
            commandLines.addAll(sig.get().generateCommandLine());
        }
        return commandLines;
    }

    /**
     * A classe {@code Builder} para {@code MultiTenant} fornece uma interface fluente
     * para configurar e construir uma instância de {@code MultiTenant} com os componentes
     * {@code Sig} e {@code Itc} desejados.
     */
    public static class Builder implements CommandLineBuilder {

        private Optional<Sig> sig = Optional.empty();
        private Optional<Itc> itc = Optional.empty();

        public Builder sig(Sig sig) {
            this.sig = Optional.of(sig);
            return this;
        }

        public Builder itc(Itc itc) {
            this.itc = Optional.of(itc);
            return this;
        }

        @Override
        public MultiTenant build() {
            return new MultiTenant(sig, itc);
        }
    }

}
