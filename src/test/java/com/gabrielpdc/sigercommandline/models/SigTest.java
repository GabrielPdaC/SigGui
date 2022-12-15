package com.gabrielpdc.sigercommandline.models;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class SigTest {

    private ArrayList<String> expectedCommandLine;
    private ArrayList<String> actualsCommandLine;

    @Before
    public void init() {
        expectedCommandLine = new ArrayList<>();
    }

    @Test
    public void sigTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("Sig.bat");
        actualsCommandLine = Sig.builder().build().generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void sigUserPasswordTest() throws SigerCommandLineException {
        // Teste de execução passando usuário e senha
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("VS-USUARI:RECH");
        expectedCommandLine.add("VS-SENUSU:RECH12345");
        actualsCommandLine = Sig.builder()
                .user("RECH")
                .password("RECH12345")
                .build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void sigCompanyTest() throws SigerCommandLineException {
        // Teste de execução passando sigla de empresa
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("VS-SIGEMP:GCO");
        actualsCommandLine = Sig.builder()
                .company("GCO")
                .build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void sigMenuTest() throws SigerCommandLineException {
        // Teste de execução passando opção de menu
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("VS-OPCMEN:512A");
        actualsCommandLine = Sig.builder()
                .menu("512A")
                .build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void sigThinClientTest() throws SigerCommandLineException {
        // Teste de execução com Thin Client
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("TC");
        actualsCommandLine = Sig.builder()
                .isThinClient(true)
                .build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void sigThinClientPortTest() throws SigerCommandLineException {
        // Teste de execução com Thin Client com porta
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("TC");
        expectedCommandLine.add("TCPORT:6000");
        actualsCommandLine = Sig.builder()
                .isThinClient(true)
                .thinClientPort(6000)
                .build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void sigDebugJavaTest() throws SigerCommandLineException {
        // Teste de execução com Web Client
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("DJ");
        actualsCommandLine = Sig.builder()
                .isDebugJava(true)
                .build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void sigProfilerTest() throws SigerCommandLineException {
        // Teste de execução com Web Client
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("PJ");
        actualsCommandLine = Sig.builder()
                .isProfiler(true)
                .build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void sigDebugTest() throws SigerCommandLineException {
        // Teste de execução com Web Client
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("D");
        actualsCommandLine = Sig.builder()
                .isDebug(true)
                .build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void sigWebClientTest() throws SigerCommandLineException {
        // Teste de execução com Web Client
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("WEBCLI");
        actualsCommandLine = Sig.builder()
                .isWebClient(true)
                .build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

}
