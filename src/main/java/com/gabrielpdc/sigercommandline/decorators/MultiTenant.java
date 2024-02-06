package com.gabrielpdc.sigercommandline.decorators;

import java.util.ArrayList;
import java.util.Optional;

import com.gabrielpdc.sigercommandline.Execptions.SigerCommandLineException;
import com.gabrielpdc.sigercommandline.Interfaces.CommandLineBuilder;
import com.gabrielpdc.sigercommandline.Interfaces.SigerCommandLines;
import com.gabrielpdc.sigercommandline.models.Term;
import com.gabrielpdc.sigercommandline.models.TermType;

public class MultiTenant implements SigerCommandLines {

    private static String MULTI_TENANT_RUNNER = "MT.bat";

    private final Optional<Sig> sig;
    private final Optional<Itc> itc;

    public MultiTenant(Optional<Sig> sig, Optional<Itc> itc) {
        this.sig = sig;
        this.itc = itc;
    }

    public static Builder builder() {
        return new MultiTenant.Builder();
    }

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
