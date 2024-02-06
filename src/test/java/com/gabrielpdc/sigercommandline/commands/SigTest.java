package com.gabrielpdc.sigercommandline.commands;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.gabrielpdc.sigercommandline.commands.Sig;
import com.gabrielpdc.sigercommandline.commons.CommonsTest;
import com.gabrielpdc.sigercommandline.exceptions.SigerCommandLineException;
import com.gabrielpdc.sigercommandline.models.Term;

public class SigTest {

    private ArrayList<String> expectedCommandLine;
    private ArrayList<Term> actualsCommandLine;

    @Before
    public void init() {
        expectedCommandLine = new ArrayList<>();
    }

    @Test
    public void sigTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("Sig.bat");
        actualsCommandLine = Sig.builder().build().generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

    @Test
    public void sigUserPasswordTest() throws SigerCommandLineException {
        // Teste de execução passando usuário e senha
        expectedCommandLine.add("Sig.bat VS-USUARI:RECH VS-SENUSU:RECH12345");

        actualsCommandLine = Sig.builder()
                .user("RECH")
                .password("RECH12345")
                .build()
                .generateCommandLine();

        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

    @Test
    public void sigCompanyTest() throws SigerCommandLineException {
        // Teste de execução passando sigla de empresa
        expectedCommandLine.add("Sig.bat VS-SIGEMP:GCO");

        actualsCommandLine = Sig.builder()
                .company("GCO")
                .build()
                .generateCommandLine();

        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

    @Test
    public void sigMenuTest() throws SigerCommandLineException {
        // Teste de execução passando opção de menu
        expectedCommandLine.add("Sig.bat VS-OPCMEN:512A");

        actualsCommandLine = Sig.builder()
                .menu("512A")
                .build()
                .generateCommandLine();

        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

    @Test
    public void sigThinClientTest() throws SigerCommandLineException {
        // Teste de execução com Thin Client
        expectedCommandLine.add("Sig.bat TC");

        actualsCommandLine = Sig.builder()
                .withThinClient(true)
                .build()
                .generateCommandLine();

        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

    @Test
    public void sigThinClientPortTest() throws SigerCommandLineException {
        // Teste de execução com Thin Client com porta
        expectedCommandLine.add("Sig.bat TC TCPORT:6000");

        actualsCommandLine = Sig.builder()
                .withThinClient(true)
                .thinClientPort(6000)
                .build()
                .generateCommandLine();

        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

    @Test
    public void sigDebugJavaTest() throws SigerCommandLineException {
        // Teste de execução com Web Client
        expectedCommandLine.add("Sig.bat DJ");

        actualsCommandLine = Sig.builder()
                .withDebugJava(true)
                .build()
                .generateCommandLine();

        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

    @Test
    public void sigProfilerTest() throws SigerCommandLineException {
        // Teste de execução com Web Client
        expectedCommandLine.add("Sig.bat PJ");
        actualsCommandLine = Sig.builder()
                .withProfiler(true)
                .build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

    @Test
    public void sigDebugTest() throws SigerCommandLineException {
        // Teste de execução com Web Client
        expectedCommandLine.add("Sig.bat D");

        actualsCommandLine = Sig.builder()
                .withDebug(true)
                .build()
                .generateCommandLine();

        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

    @Test
    public void sigWebClientTest() throws SigerCommandLineException {
        // Teste de execução com Web Client
        expectedCommandLine.add("Sig.bat WEBCLI");

        actualsCommandLine = Sig.builder()
                .withWebClient(true)
                .build()
                .generateCommandLine();

        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

}
