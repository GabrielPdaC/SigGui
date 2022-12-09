package com.gabrielpdc.app;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class CommandLIneBuilderTest 
{
    private CommandLineBuilder commandLineBuilder;
    private ArrayList<String> expectedCommandLine;
    
    @Before
    public void init() {
        commandLineBuilder = new CommandLineBuilder();
        expectedCommandLine = new ArrayList<>();
    }  

    @Test
    public void getCommandLineTest() {
        commandLineBuilder.setDesktop();
        expectedCommandLine.add(CommandLineBuilder.SIGER_RUNNER);
        assertArrayEquals(expectedCommandLine.toArray(), commandLineBuilder.getCommandLine().toArray());

        init();
        commandLineBuilder.setThinClient();
        expectedCommandLine.add(CommandLineBuilder.SIGER_SERVER_RUNNER);
        expectedCommandLine.add(CommandLineBuilder.SIGER_RUNNER);
        assertArrayEquals(expectedCommandLine.toArray(), commandLineBuilder.getCommandLine().toArray());

        init();
        commandLineBuilder.setMultiTenant();
        expectedCommandLine.add(CommandLineBuilder.SIGER_MULTI_TENANT_RUNNER + " " + CommandLineBuilder.SIGER_SERVER_RUNNER + " " + CommandLineBuilder.SIGER_RUNNER);
        assertArrayEquals(expectedCommandLine.toArray(), commandLineBuilder.getCommandLine().toArray());

        init();
        commandLineBuilder.setThinClient();
        expectedCommandLine.add(CommandLineBuilder.SIGER_SERVER_RUNNER);
        expectedCommandLine.add(CommandLineBuilder.SIGER_RUNNER);
        assertArrayEquals(expectedCommandLine.toArray(), commandLineBuilder.getCommandLine().toArray());

        init();
        commandLineBuilder.setMultiTenant();
        expectedCommandLine.add(CommandLineBuilder.SIGER_MULTI_TENANT_RUNNER + " " + CommandLineBuilder.SIGER_SERVER_RUNNER + " " + CommandLineBuilder.SIGER_RUNNER);
        assertArrayEquals(expectedCommandLine.toArray(), commandLineBuilder.getCommandLine().toArray());
    }

    @Test
    public void getDesktopCommandLineTest() {

    }

    @Test
    public void getThinClientCommandLineTest() {

    }

    @Test
    public void getServerRunnerOperatingSystemTest() {

    }
}

/**
 * 
 * sig << Run desktop only
 * 
 * sig tc << Run Thin Client
 * >> itc 
 * >> sig tc
 *
 * sig tc << Run Thin Client (Linux)
 * >> itc linux
 * >> sig tc
 * 
 * sig tc << Run Thin Client (Multi Tenant)
 * >> mt itc sig
 * 
 * sig tc << Run Thin Client (Multi Tenant/Linux)
 * >> mt itc linux sig
*/