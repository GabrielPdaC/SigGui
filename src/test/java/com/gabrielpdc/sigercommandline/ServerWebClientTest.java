package com.gabrielpdc.sigercommandline;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ServerWebClientTest {

    private ArrayList<String> expectedCommandLine;
    private ArrayList<String> actualsCommandLine;

    @Before
    public void init() {
        expectedCommandLine = new ArrayList<>();
    }

    @Test
    public void serverWebClientTest() {
        // Teste de execução normal
        expectedCommandLine.add("SRVWC.bat");
        try {
            actualsCommandLine = ServerWebClient.builder().build().generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }
    @Test
    public void isShowInfoTest() {
        // Teste de execução normal
        expectedCommandLine.add("SRVWC.bat");
        expectedCommandLine.add("INF");
        try {
            actualsCommandLine = ServerWebClient.builder().isShowInfo(true).build().generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }
    @Test
    public void isJavaOutputTest() {
        // Teste de execução normal
        expectedCommandLine.add("SRVWC.bat");
        expectedCommandLine.add("EX");
        try {
            actualsCommandLine = ServerWebClient.builder().isJavaOutput(true).build().generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }
    @Test
    public void isDebugJavaTest() {
        // Teste de execução normal
        expectedCommandLine.add("SRVWC.bat");
        expectedCommandLine.add("DJ");
        try {
            actualsCommandLine = ServerWebClient.builder().isDebugJava(true).build().generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }
    @Test
    public void isTrunkTest() {
        // Teste de execução normal
        expectedCommandLine.add("SRVWC.bat");
        expectedCommandLine.add("/F");
        try {
            actualsCommandLine = ServerWebClient.builder().isTrunk(true).build().generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

}
