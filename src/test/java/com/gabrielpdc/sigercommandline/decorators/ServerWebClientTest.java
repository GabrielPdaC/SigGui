package com.gabrielpdc.sigercommandline.decorators;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.gabrielpdc.sigercommandline.Commons.CommonsTest;
import com.gabrielpdc.sigercommandline.Execptions.SigerCommandLineException;
import com.gabrielpdc.sigercommandline.models.Term;

public class ServerWebClientTest {

    private ArrayList<String> expectedCommandLine;
    private ArrayList<Term> actualsCommandLine;

    @Before
    public void init() {
        expectedCommandLine = new ArrayList<>();
    }

    @Test
    public void serverWebClientTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("SRVWC.bat");
        actualsCommandLine = ServerWebClient.builder().build().generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

    @Test
    public void isShowInfoTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("SRVWC.bat INF");
        actualsCommandLine = ServerWebClient.builder().withShowInfo(true).build().generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

    @Test
    public void isJavaOutputTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("SRVWC.bat EX");
        actualsCommandLine = ServerWebClient.builder().withJavaOutput(true).build().generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

    @Test
    public void isDebugJavaTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("SRVWC.bat DJ");
        actualsCommandLine = ServerWebClient.builder().withDebugJava(true).build().generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

    @Test
    public void isTrunkTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("SRVWC.bat /F");
        actualsCommandLine = ServerWebClient.builder().withTrunk(true).build().generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

}
