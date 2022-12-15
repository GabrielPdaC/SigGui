package com.gabrielpdc.sigercommandline.models;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class MultiTenantTest {

    private ArrayList<String> expectedCommandLine;
    private ArrayList<String> actualsCommandLine;
    private Sig.Builder sigBuilder;
    private Itc.Builder itcBuilder;

    @Before
    public void init() {
        expectedCommandLine = new ArrayList<>();
        sigBuilder = Sig.builder();
        itcBuilder = Itc.builder();
    }

    @Test
    public void multiTenantSigTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("MT.bat");
        expectedCommandLine.add("Sig.bat");
        actualsCommandLine = MultiTenant.builder().sig(sigBuilder.build()).build().generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void multiTenantItcTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("MT.bat");
        expectedCommandLine.add("ITC.bat");
        actualsCommandLine = MultiTenant.builder().itc(itcBuilder.build()).build().generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void multiTenantSigItcTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("MT.bat");
        expectedCommandLine.add("ITC.bat");
        expectedCommandLine.add("Sig.bat");
        actualsCommandLine = MultiTenant.builder().sig(sigBuilder.build()).itc(itcBuilder.build()).build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void multiTenantSigItcParamsTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("MT.bat");
        expectedCommandLine.add("ITC.bat");
        expectedCommandLine.add("D");
        expectedCommandLine.add("EX");
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("VS-OPCMEN:512A");
        expectedCommandLine.add("D");
        sigBuilder.isDebug(true).menu("512A");
        itcBuilder.isDebug(true).isShowInfo(true);
        actualsCommandLine = MultiTenant.builder().sig(sigBuilder.build()).itc(itcBuilder.build()).build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

}
