package com.gabrielpdc.sigercommandline;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

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
    public void multiTenantSigTest() {
        // Teste de execução normal
        expectedCommandLine.add("MT.bat");
        expectedCommandLine.add("Sig.bat");
        try {
            actualsCommandLine = MultiTenant.builder().sig(sigBuilder.build()).build().generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void multiTenantItcTest() {
        // Teste de execução normal
        expectedCommandLine.add("MT.bat");
        expectedCommandLine.add("ITC.bat");
        try {
            actualsCommandLine = MultiTenant.builder().itc(itcBuilder.build()).build().generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void multiTenantSigItcTest() {
        // Teste de execução normal
        expectedCommandLine.add("MT.bat");
        expectedCommandLine.add("ITC.bat");
        expectedCommandLine.add("Sig.bat");
        try {
            actualsCommandLine = MultiTenant.builder().sig(sigBuilder.build()).itc(itcBuilder.build()).build().generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void multiTenantSigItcParamsTest() {
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
        try {
            actualsCommandLine = MultiTenant.builder().sig(sigBuilder.build()).itc(itcBuilder.build()).build().generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

}
