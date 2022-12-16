package com.gabrielpdc.sigercommandline.models;

import static org.junit.Assert.assertArrayEquals;

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
    public void serverWebClientTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("SRVWC.bat");
        actualsCommandLine = ServerWebClient.builder().build().generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void isShowInfoTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("SRVWC.bat");
        expectedCommandLine.add("INF");
        actualsCommandLine = ServerWebClient.builder().withShowInfo(true).build().generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void isJavaOutputTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("SRVWC.bat");
        expectedCommandLine.add("EX");
        actualsCommandLine = ServerWebClient.builder().withJavaOutput(true).build().generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void isDebugJavaTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("SRVWC.bat");
        expectedCommandLine.add("DJ");
        actualsCommandLine = ServerWebClient.builder().withDebugJava(true).build().generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void isTrunkTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("SRVWC.bat");
        expectedCommandLine.add("/F");
        actualsCommandLine = ServerWebClient.builder().withTrunk(true).build().generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

}
