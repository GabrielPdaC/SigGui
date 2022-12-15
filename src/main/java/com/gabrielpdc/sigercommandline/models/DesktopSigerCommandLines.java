package com.gabrielpdc.sigercommandline.models;

import java.util.ArrayList;
import java.util.Optional;

public final class DesktopSigerCommandLines implements SigerCommandLines {

    private final Optional<GoGlobal> goGlobal;
    private final Sig sig;


    public DesktopSigerCommandLines(Optional<GoGlobal> goGlobal, Sig sig) {
        this.goGlobal = goGlobal;
        this.sig = sig;
    }

    public static Builder builder(Sig sig) {
        return new DesktopSigerCommandLines.Builder(sig);
    }

    @Override
    public ArrayList<String> generateCommandLine() throws SigerCommandLineException {
        ArrayList<String> commandLines = new ArrayList<>();
        if (goGlobal.isPresent()) {
            commandLines.addAll(goGlobal.get().generateCommandLine());
        }
        commandLines.addAll(sig.generateCommandLine());
        return commandLines;
    }

    public static final class Builder {

        private Optional<GoGlobal> goGlobal = Optional.empty();
        private Sig sig;

        public Builder(Sig sig) {
            this.sig = sig;
        }

        public Builder goGlobal(GoGlobal goGlobal) {
            this.goGlobal = Optional.of(goGlobal);
            return this;
        }

        public DesktopSigerCommandLines build() {
            return new DesktopSigerCommandLines(goGlobal, sig);
        }
    }
}
