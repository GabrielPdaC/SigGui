package com.gabrielpdc.sigercommandline.commands;

import java.util.ArrayList;
import java.util.Optional;

import com.gabrielpdc.sigercommandline.Interfaces.CommandLineBuilder;
import com.gabrielpdc.sigercommandline.Interfaces.SigerCommandLines;
import com.gabrielpdc.sigercommandline.exceptions.SigerCommandLineException;
import com.gabrielpdc.sigercommandline.models.Term;

/**
 * Classe {@code Desktop} responsável por gerar linhas de comando para a execução
 * de aplicações desktop, podendo integrar opcionalmente com o GoGlobal e é obrigatória
 * a integração com o Sig. Esta classe facilita a composição de comandos para iniciar
 * aplicações com configurações específicas, proporcionando flexibilidade para diferentes
 * cenários de implantação.
 *
 * A integração com o GoGlobal é opcional e permite a execução de aplicações em ambientes
 * virtualizados ou remotos, enquanto a integração com o Sig é essencial para definir
 * parâmetros específicos da aplicação.
 */
public final class Desktop implements SigerCommandLines {

    private final Optional<GoGlobal> goGlobal;
    private final Sig sig;

    /**
     * Constrói uma instância de {@code Desktop} com a configuração do GoGlobal e do Sig.
     *
     * @param goGlobal Um {@code Optional<GoGlobal>} que representa a configuração opcional do GoGlobal.
     * @param sig Uma instância de {@code Sig} que representa a configuração obrigatória do Sig.
     */
    public Desktop(Optional<GoGlobal> goGlobal, Sig sig) {
        this.goGlobal = goGlobal;
        this.sig = sig;
    }

    /**
     * Cria um novo {@code Builder} para facilitar a construção de uma instância de {@code Desktop}
     * com configurações específicas.
     *
     * @param sig A instância obrigatória de {@code Sig} para a configuração do Desktop.
     * @return Uma nova instância de {@code Builder}.
     */
    public static Builder builder(Sig sig) {
        return new Desktop.Builder(sig);
    }

    /**
     * Gera uma lista de {@code Term} representando os comandos de linha de comando
     * para a aplicação desktop, incluindo os comandos do GoGlobal e do Sig, conforme configurado.
     *
     * @return Uma lista de {@code Term} com os comandos de linha de comando.
     * @throws SigerCommandLineException Se ocorrer um erro na geração dos comandos.
     */
    @Override
    public ArrayList<Term> generateCommandLine() throws SigerCommandLineException {
        ArrayList<Term> commandLines = new ArrayList<Term>();
        if (goGlobal.isPresent()) {
            commandLines.addAll(goGlobal.get().generateCommandLine());
        }
        commandLines.addAll(sig.generateCommandLine());
        return commandLines;
    }

    /**
     * A classe {@code Builder} fornece uma interface fluente para configurar e construir
     * uma instância de {@code Desktop} com as opções desejadas de GoGlobal e Sig.
     */
    public static final class Builder implements CommandLineBuilder {

        private Optional<GoGlobal> goGlobal = Optional.empty();
        private Sig sig;

        public Builder(Sig sig) {
            this.sig = sig;
        }

        public Builder goGlobal(GoGlobal goGlobal) {
            this.goGlobal = Optional.of(goGlobal);
            return this;
        }

        @Override
        public Desktop build() {
            return new Desktop(goGlobal, sig);
        }
    }
}
