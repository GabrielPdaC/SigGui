package com.gabrielpdc.sigercommandline.commands;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.gabrielpdc.sigercommandline.commands.GoGlobal;
import com.gabrielpdc.sigercommandline.commands.Itc;
import com.gabrielpdc.sigercommandline.commands.MultiTenant;
import com.gabrielpdc.sigercommandline.commands.ServerWebClient;
import com.gabrielpdc.sigercommandline.commands.Sig;
import com.gabrielpdc.sigercommandline.commands.ThinClient;
import com.gabrielpdc.sigercommandline.commands.VMLinux;
import com.gabrielpdc.sigercommandline.commands.Itc.OperatingSystem;
import com.gabrielpdc.sigercommandline.commons.CommonsTest;
import com.gabrielpdc.sigercommandline.exceptions.SigerCommandLineException;
import com.gabrielpdc.sigercommandline.models.Term;

public class ThinClientTest {

    private ArrayList<String> expectedCommandLine;
    private ArrayList<Term> actualsCommandLine;
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

        actualsCommandLine = ThinClient.builder()
                .itc(itcBuilder.build())
                .sig(sigBuilder.build())
                .build()
                .generateCommandLine();

        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

    @Test
    public void vmLinuxSigTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("VMLinux.bat");
        expectedCommandLine.add("ITC.bat LINUX");
        expectedCommandLine.add("Sig.bat TC");

        actualsCommandLine = ThinClient.builder()
                .vmLinux(vmLinux)
                .itc(itcBuilder.serverOperatingSystem(OperatingSystem.LINUX).build())
                .sig(sigBuilder.withThinClient(true).build())
                .build()
                .generateCommandLine();

        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

    @Test
    public void multiTenantTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("MT.bat");
        expectedCommandLine.add("ITC.bat");
        expectedCommandLine.add("Sig.bat");

        multiTenantBuilder.itc(itcBuilder.build()).sig(sigBuilder.build());
        actualsCommandLine = ThinClient.builder()
                .multiTenant(multiTenantBuilder.build())
                .build()
                .generateCommandLine();

        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

    @Test
    public void goGlobalTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("GoGlobal.bat");
        expectedCommandLine.add("ITC.bat");
        expectedCommandLine.add("Sig.bat");

        actualsCommandLine = ThinClient.builder()
                .goGlobal(goGlobal)
                .itc(itcBuilder.build())
                .sig(sigBuilder.build())
                .build()
                .generateCommandLine();

        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

    @Test
    public void serverWebClientBuilderTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("ITC.bat");
        expectedCommandLine.add("SRVWC.bat");
        expectedCommandLine.add("Sig.bat WEBCLI");

        sigBuilder.withWebClient(true);
        actualsCommandLine = ThinClient.builder()
                .itc(itcBuilder.build())
                .serverWebClient(serverWebClientBuilder.build())
                .sig(sigBuilder.build())
                .build()
                .generateCommandLine();

        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

}
