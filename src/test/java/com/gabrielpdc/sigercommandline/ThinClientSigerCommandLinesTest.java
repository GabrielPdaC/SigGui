package com.gabrielpdc.sigercommandline;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.gabrielpdc.sigercommandline.Itc.OperatingSystem;

public class ThinClientSigerCommandLinesTest {

    private ArrayList<String> expectedCommandLine;
    private ArrayList<String> actualsCommandLine;
    private GoGlobal goGlobal;
    private VMLinux vmLinux;
    private MultiTenant.Builder multiTenantBuilder;
    private ServerWebClient.Builder serverWebClientBuilder;
    private Itc.Builder itcBuilder;
    private Sig.Builder sigBuilder;

    @Before
    public void init() {
        expectedCommandLine = new ArrayList<>();
        goGlobal = new GoGlobal();
        vmLinux = new VMLinux();
        multiTenantBuilder = MultiTenant.builder();
        serverWebClientBuilder = ServerWebClient.builder();
        itcBuilder = Itc.builder();
        sigBuilder = Sig.builder();
    }

    @Test
    public void itcSigTest() {
        // Teste de execução normal
        expectedCommandLine.add("ITC.bat");
        expectedCommandLine.add("Sig.bat");
        try {
            actualsCommandLine = ThinClientSigerCommandLines.builder()
                    .itc(itcBuilder.build())
                    .sig(sigBuilder.build())
                    .build()
                    .generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void vmLinuxSigTest() {
        // Teste de execução normal
        expectedCommandLine.add("VMLinux.bat");
        expectedCommandLine.add("ITC.bat");
        expectedCommandLine.add("LINUX");
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("TC");
        try {
            actualsCommandLine = ThinClientSigerCommandLines.builder()
                    .vmLinux(vmLinux)
                    .itc(itcBuilder.serverOperatingSystem(OperatingSystem.LINUX).build())
                    .sig(sigBuilder.isThinClient(true).build())
                    .build()
                    .generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void multiTenantTest() {
        // Teste de execução normal
        expectedCommandLine.add("MT.bat");
        expectedCommandLine.add("ITC.bat");
        expectedCommandLine.add("Sig.bat");
        try {
            multiTenantBuilder.itc(itcBuilder.build()).sig(sigBuilder.build());
            actualsCommandLine = ThinClientSigerCommandLines.builder()
                    .multiTenant(multiTenantBuilder.build())
                    .build()
                    .generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void goGlobalTest() {
        // Teste de execução normal
        expectedCommandLine.add("GoGlobal.bat");
        expectedCommandLine.add("ITC.bat");
        expectedCommandLine.add("Sig.bat");
        try {
            actualsCommandLine = ThinClientSigerCommandLines.builder()
                    .goGlobal(goGlobal)
                    .itc(itcBuilder.build())
                    .sig(sigBuilder.build())
                    .build()
                    .generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void serverWebClientBuilderTest() {
        // Teste de execução normal
        expectedCommandLine.add("ITC.bat");
        expectedCommandLine.add("SRVWC.bat");
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("WEBCLI");
        try {
            sigBuilder.isWebClient(true);
            actualsCommandLine = ThinClientSigerCommandLines.builder()
                    .itc(itcBuilder.build())
                    .serverWebClient(serverWebClientBuilder.build())
                    .sig(sigBuilder.build())
                    .build()
                    .generateCommandLine();
            System.out.println(actualsCommandLine.toString());
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

}
