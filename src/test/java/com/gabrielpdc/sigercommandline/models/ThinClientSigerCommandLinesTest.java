package com.gabrielpdc.sigercommandline.models;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.gabrielpdc.sigercommandline.models.Itc.OperatingSystem;

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
    public void init() throws SigerCommandLineException {
        expectedCommandLine = new ArrayList<>();
        goGlobal = new GoGlobal();
        vmLinux = new VMLinux();
        multiTenantBuilder = MultiTenant.builder();
        serverWebClientBuilder = ServerWebClient.builder();
        itcBuilder = Itc.builder();
        sigBuilder = Sig.builder();
    }

    @Test
    public void itcSigTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("ITC.bat");
        expectedCommandLine.add("Sig.bat");
        actualsCommandLine = ThinClientSigerCommandLines.builder()
                .itc(itcBuilder.build())
                .sig(sigBuilder.build())
                .build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void vmLinuxSigTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("VMLinux.bat");
        expectedCommandLine.add("ITC.bat");
        expectedCommandLine.add("LINUX");
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("TC");
        actualsCommandLine = ThinClientSigerCommandLines.builder()
                .vmLinux(vmLinux)
                .itc(itcBuilder.serverOperatingSystem(OperatingSystem.LINUX).build())
                .sig(sigBuilder.withThinClient(true).build())
                .build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void multiTenantTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("MT.bat");
        expectedCommandLine.add("ITC.bat");
        expectedCommandLine.add("Sig.bat");
        multiTenantBuilder.itc(itcBuilder.build()).sig(sigBuilder.build());
        actualsCommandLine = ThinClientSigerCommandLines.builder()
                .multiTenant(multiTenantBuilder.build())
                .build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void goGlobalTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("GoGlobal.bat");
        expectedCommandLine.add("ITC.bat");
        expectedCommandLine.add("Sig.bat");
        actualsCommandLine = ThinClientSigerCommandLines.builder()
                .goGlobal(goGlobal)
                .itc(itcBuilder.build())
                .sig(sigBuilder.build())
                .build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void serverWebClientBuilderTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("ITC.bat");
        expectedCommandLine.add("SRVWC.bat");
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("WEBCLI");
        sigBuilder.withWebClient(true);
        actualsCommandLine = ThinClientSigerCommandLines.builder()
                .itc(itcBuilder.build())
                .serverWebClient(serverWebClientBuilder.build())
                .sig(sigBuilder.build())
                .build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

}
