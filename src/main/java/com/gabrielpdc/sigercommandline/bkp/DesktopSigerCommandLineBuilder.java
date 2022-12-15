package com.gabrielpdc.sigercommandline.bkp;

import com.gabrielpdc.sigercommandline.DesktopSigerCommandLines;

public class DesktopSigerCommandLineBuilder {

    private DesktopSigerCommandLines desktopSigerCommandLine;
    private boolean isGoGlobal;

    public DesktopSigerCommandLineBuilder() {
        desktopSigerCommandLine = new DesktopSigerCommandLines();
    }

    public DesktopSigerCommandLineBuilder setGoGlobal(boolean isGoGlobal) {
        this.isGoGlobal = isGoGlobal;
        return this;
    }

    public DesktopSigerCommandLines build() {
        desktopSigerCommandLine = new DesktopSigerCommandLines(this.isGoGlobal);
        return this.desktopSigerCommandLine;
    }

}
