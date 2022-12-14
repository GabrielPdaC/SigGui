package com.gabrielpdc.sigercommandline;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.gabrielpdc.sigercommandline.SigerCommandLines.ClientExecutionType;
import com.gabrielpdc.sigercommandline.bkp.SigerCommandLineBuilder;
import com.gabrielpdc.sigercommandline.bkp.ThinClientSigerCommandLine;
import com.gabrielpdc.sigercommandline.bkp.SigerCommandLineBuilder.Architecture;

/**
 * Unit test for simple App.
 */
public class CommandLineBuilderTest {
    private SigerCommandLineBuilder sigerCommandLineBuilder;
    private ArrayList<String> expectedCommandLine;
    private ArrayList<String> actualsCommandLine;

    @Before
    public void initDesktop() {
        sigerCommandLineBuilder = new SigerCommandLineBuilder(Architecture.DESKTOP);
        expectedCommandLine = new ArrayList<>();
    }

    @Test
    public void desktopGetCommandLineTest() {
        /* Teste execução Desktop normal */
        try {
            initDesktop();
            expectedCommandLine.add(SigerCommandLines.SIGER_RUNNER);
            actualsCommandLine = sigerCommandLineBuilder.getCommandLine();
            assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
        } catch (SigerCommandLineException e) {
            fail("Linha de comando esperada para execução em desktop diferente do resultado obtido.");
        }
        /* Teste execução Desktop com Go-Global */
        try {
            initDesktop();
            expectedCommandLine.add(SigerCommandLines.GO_GLOBAL_RUNNER);
            actualsCommandLine = sigerCommandLineBuilder.setClientExecutionType(ClientExecutionType.GO_GLOBAL)
                    .getCommandLine();
            assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
        } catch (SigerCommandLineException e) {
            fail("Linha de comando esperada para execução em desktop diferente do resultado obtido.");
        }
    }

    @Before
    public void initThinClient() {
        sigerCommandLineBuilder = new SigerCommandLineBuilder(Architecture.THIN_CLIENT);
        expectedCommandLine = new ArrayList<>();
    }

    @Test
    public void thinClientGetCommandLineTest() {
        /* Teste de execução Thin Client */
        try {
            initThinClient();
            expectedCommandLine.add(ThinClientSigerCommandLine.SIGER_SERVER_RUNNER);
            expectedCommandLine.add(SigerCommandLines.SIGER_RUNNER + " " + ThinClientSigerCommandLine.SIGER_THIN_CLIENT_RUNNER);
            actualsCommandLine = sigerCommandLineBuilder.getCommandLine();
            assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
        } catch (SigerCommandLineException e) {
            fail("Linha de comando esperada para execução em desktop diferente do resultado obtido.");
        }
        /* Teste de execução Thin Client com Web Client */
        try {
            initThinClient();
            expectedCommandLine.add(ThinClientSigerCommandLine.SIGER_SERVER_RUNNER);
            expectedCommandLine.add(SigerCommandLines.SIGER_RUNNER + " " + ThinClientSigerCommandLine.SIGER_WEB_CLIENT_RUNNER);
            actualsCommandLine = sigerCommandLineBuilder.setClientExecutionType(ClientExecutionType.WEB_CLIENT).getCommandLine();
            assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
        } catch (SigerCommandLineException e) {
            fail("Linha de comando esperada para execução em desktop diferente do resultado obtido.");
        }
        /* Teste de execução Thin Client com Go-Global */
        try {
            initThinClient();
            expectedCommandLine.add(ThinClientSigerCommandLine.SIGER_SERVER_RUNNER);
            expectedCommandLine.add(SigerCommandLines.SIGER_RUNNER + " " + ThinClientSigerCommandLine.SIGER_WEB_CLIENT_RUNNER);
            actualsCommandLine = sigerCommandLineBuilder.setClientExecutionType(ClientExecutionType.WEB_CLIENT).getCommandLine();
            assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
        } catch (SigerCommandLineException e) {
            fail("Linha de comando esperada para execução em desktop diferente do resultado obtido.");
        }
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
 *
 * GoGlobal?
 *
 * WebClient?
 *
 */
