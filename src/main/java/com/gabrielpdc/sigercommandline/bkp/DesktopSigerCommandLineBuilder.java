package com.gabrielpdc.sigercommandline.bkp;

import com.gabrielpdc.sigercommandline.DesktopSigerCommandLine;

public class DesktopSigerCommandLineBuilder {

    private DesktopSigerCommandLine desktopSigerCommandLine;
    private boolean isGoGlobal;

    public DesktopSigerCommandLineBuilder() {
        desktopSigerCommandLine = new DesktopSigerCommandLine();
    }

    public DesktopSigerCommandLineBuilder setGoGlobal(boolean isGoGlobal) {
        this.isGoGlobal = isGoGlobal;
        return this;
    }

    public DesktopSigerCommandLine build() {
        desktopSigerCommandLine = new DesktopSigerCommandLine(this.isGoGlobal);
        return this.desktopSigerCommandLine;
    }

}
