package com.gabrielpdc.sigercommandline.controllers;

import org.junit.Before;
import org.junit.Test;

import com.gabrielpdc.sigercommandline.Execptions.SigerCommandLineException;
import com.gabrielpdc.sigercommandline.controllers.CommandLineController.Architecture;

public class CommandLineControllerTest {

    private CommandLineController sigerCommandLineControler;

    // @Before
    // public void initDesktop() {
    //     sigerCommandLineControler = new SigerCommandLineController(Architecture.DESKTOP);
    // }

    @Before
    public void initThinClient() {
        sigerCommandLineControler = new CommandLineController(Architecture.DESKTOP);
    }

    @Test
    public void sigerCommandLineControlerTest() throws SigerCommandLineException {
        // System.out.println(sigerCommandLineControler.build().toString());
        System.out.println(
            sigerCommandLineControler
            .setClientIsGoGlobal(true)
            .setClientIsDebug(true)
            .setClientIsDebugJava(true)
            .setClientCompany("TST")
            .generateCommandLine().toString());
    }

}
