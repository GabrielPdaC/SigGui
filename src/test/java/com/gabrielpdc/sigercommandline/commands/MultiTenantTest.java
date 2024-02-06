package com.gabrielpdc.sigercommandline.commands;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.gabrielpdc.sigercommandline.commands.Itc;
import com.gabrielpdc.sigercommandline.commands.MultiTenant;
import com.gabrielpdc.sigercommandline.commands.Sig;
import com.gabrielpdc.sigercommandline.commons.CommonsTest;
import com.gabrielpdc.sigercommandline.exceptions.SigerCommandLineException;
import com.gabrielpdc.sigercommandline.models.Term;

public class MultiTenantTest {

    private ArrayList<String> expectedCommandLine;
    private ArrayList<Term> actualsCommandLine;
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

        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

    @Test
    public void multiTenantItcTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("MT.bat");
        expectedCommandLine.add("ITC.bat");

        actualsCommandLine = MultiTenant.builder().itc(itcBuilder.build()).build().generateCommandLine();

        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

    @Test
    public void multiTenantSigItcTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("MT.bat");
        expectedCommandLine.add("ITC.bat");
        expectedCommandLine.add("Sig.bat");

        actualsCommandLine = MultiTenant.builder().sig(sigBuilder.build()).itc(itcBuilder.build()).build()
                .generateCommandLine();

        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

    @Test
    public void multiTenantSigItcParamsTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("MT.bat");
        expectedCommandLine.add("ITC.bat D EX");
        expectedCommandLine.add("Sig.bat VS-OPCMEN:512A D");

        sigBuilder.withDebug(true).menu("512A");
        itcBuilder.withDebug(true).withJavaOutput(true);
        actualsCommandLine = MultiTenant.builder().sig(sigBuilder.build()).itc(itcBuilder.build()).build()
                .generateCommandLine();

        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

}
