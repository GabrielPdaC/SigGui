package com.gabrielpdc.sigercommandline;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

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
    public void sigTest() {
        // Teste de execução normal
        expectedCommandLine.add("Sig.bat");
        try {
            actualsCommandLine = Sig.builder().build().generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void sigUserPasswordTest() {
        // Teste de execução passando usuário e senha
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("VS-USUARI:RECH");
        expectedCommandLine.add("VS-SENUSU:RECH12345");
        try {
            actualsCommandLine = Sig.builder()
                    .user("RECH")
                    .password("RECH12345")
                    .build()
                    .generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void sigCompanyTest() {
        // Teste de execução passando sigla de empresa
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("VS-SIGEMP:GCO");
        try {
            actualsCommandLine = Sig.builder()
                    .company("GCO")
                    .build()
                    .generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void sigMenuTest() {
        // Teste de execução passando opção de menu
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("VS-OPCMEN:512A");
        try {
            actualsCommandLine = Sig.builder()
                    .menu("512A")
                    .build()
                    .generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void sigThinClientTest() {
        // Teste de execução com Thin Client
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("TC");
        try {
            actualsCommandLine = Sig.builder()
                    .isThinClient(true)
                    .build()
                    .generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void sigThinClientPortTest() {
        // Teste de execução com Thin Client com porta
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("TC");
        expectedCommandLine.add("TCPORT:6000");
        try {
            actualsCommandLine = Sig.builder()
                    .isThinClient(true)
                    .thinClientPort(6000)
                    .build()
                    .generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void sigDebugTest() {
        // Teste de execução com Web Client
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("D");
        try {
            actualsCommandLine = Sig.builder()
                    .isDebug(true)
                    .build()
                    .generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void sigWebClientTest() {
        // Teste de execução com Web Client
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("WEBCLI");
        try {
            actualsCommandLine = Sig.builder()
                    .isWebClient(true)
                    .build()
                    .generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

}
