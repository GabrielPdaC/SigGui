package com.gabrielpdc.sigercommandline.decorators;

import java.util.ArrayList;
import java.util.Optional;

import com.gabrielpdc.sigercommandline.Execptions.SigerCommandLineException;
import com.gabrielpdc.sigercommandline.Interfaces.CommandLineBuilder;
import com.gabrielpdc.sigercommandline.Interfaces.SigerCommandLines;
import com.gabrielpdc.sigercommandline.models.Term;

public final class Desktop implements SigerCommandLines {

    private final Optional<GoGlobal> goGlobal;
    private final Sig sig;


    public Desktop(Optional<GoGlobal> goGlobal, Sig sig) {
        this.goGlobal = goGlobal;
        this.sig = sig;
    }

    public static Builder builder(Sig sig) {
        return new Desktop.Builder(sig);
    }

    @Override
    public ArrayList<Term> generateCommandLine() throws SigerCommandLineException {
        ArrayList<Term> commandLines = new ArrayList<Term>();
        if (goGlobal.isPresent()) {
            commandLines.addAll(goGlobal.get().generateCommandLine());
        }
        commandLines.addAll(sig.generateCommandLine());
        return commandLines;
    }

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
