package com.gabrielpdc.sigercommandline.models;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class DesktopSigerCommandLinesTest {

    private ArrayList<String> expectedCommandLine;
    private ArrayList<String> actualsCommandLine;
    private GoGlobal goGlobal;
    private Sig.Builder sigBuilder;

    @Before
    public void init() {
        expectedCommandLine = new ArrayList<>();
        goGlobal = new GoGlobal();
        sigBuilder = Sig.builder();
    }

    @Test
    public void sigTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("Sig.bat");
        actualsCommandLine = DesktopSigerCommandLines.builder(sigBuilder.build()).build().generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void sigUserPasswordTest() throws SigerCommandLineException {
        // Teste de execução passando usuário e senha
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("VS-USUARI:RECH");
        expectedCommandLine.add("VS-SENUSU:RECH12345");
        sigBuilder.user("RECH").password("RECH12345");
        actualsCommandLine = DesktopSigerCommandLines.builder(sigBuilder.build())
                .build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void sigCompanyTest() throws SigerCommandLineException {
        // Teste de execução passando sigla de empresa
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("VS-SIGEMP:GCO");
        sigBuilder.company("GCO");
        actualsCommandLine = DesktopSigerCommandLines.builder(sigBuilder.build())
                .build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void sigMenuTest() throws SigerCommandLineException {
        // Teste de execução passando opção de menu
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("VS-OPCMEN:512A");
        sigBuilder.menu("512A");
        actualsCommandLine = DesktopSigerCommandLines.builder(sigBuilder.build())
                .build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void sigDebugJavaTest() throws SigerCommandLineException {
        // Teste de execução com Web Client
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("DJ");
        sigBuilder.withDebugJava(true);
        actualsCommandLine = DesktopSigerCommandLines.builder(sigBuilder.build())
                .build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void sigProfilerTest() throws SigerCommandLineException {
        // Teste de execução com Web Client
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("PJ");
        sigBuilder.withProfiler(true);
        actualsCommandLine = DesktopSigerCommandLines.builder(sigBuilder.build())
                .build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void sigDebugTest() throws SigerCommandLineException {
        // Teste de execução com Web Client
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("D");
        sigBuilder.withDebug(true);
        actualsCommandLine = DesktopSigerCommandLines.builder(sigBuilder.build())
                .build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void goGlobalSigTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("GoGlobal.bat");
        expectedCommandLine.add("Sig.bat");
        actualsCommandLine = DesktopSigerCommandLines.builder(sigBuilder.build())
                .goGlobal(goGlobal)
                .build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void goGlobalSigUserPasswordTest() throws SigerCommandLineException {
        // Teste de execução passando usuário e senha
        expectedCommandLine.add("GoGlobal.bat");
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("VS-USUARI:RECH");
        expectedCommandLine.add("VS-SENUSU:RECH12345");
        sigBuilder.user("RECH").password("RECH12345");
        actualsCommandLine = DesktopSigerCommandLines.builder(sigBuilder.build())
                .goGlobal(goGlobal)
                .build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void goGlobalSigCompanyTest() throws SigerCommandLineException {
        // Teste de execução passando sigla de empresa
        expectedCommandLine.add("GoGlobal.bat");
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("VS-SIGEMP:GCO");
        sigBuilder.company("GCO");
        actualsCommandLine = DesktopSigerCommandLines.builder(sigBuilder.build())
                .goGlobal(goGlobal)
                .build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void goGlobalSigMenuTest() throws SigerCommandLineException {
        // Teste de execução passando opção de menu
        expectedCommandLine.add("GoGlobal.bat");
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("VS-OPCMEN:512A");
        sigBuilder.menu("512A");
        actualsCommandLine = DesktopSigerCommandLines.builder(sigBuilder.build())
                .goGlobal(goGlobal)
                .build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void goGlobalSigDebugJavaTest() throws SigerCommandLineException {
        // Teste de execução com Web Client
        expectedCommandLine.add("GoGlobal.bat");
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("DJ");
        sigBuilder.withDebugJava(true);
        actualsCommandLine = DesktopSigerCommandLines.builder(sigBuilder.build())
                .goGlobal(goGlobal)
                .build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void goGlobalSigProfilerTest() throws SigerCommandLineException {
        // Teste de execução com Web Client
        expectedCommandLine.add("GoGlobal.bat");
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("PJ");
        sigBuilder.withProfiler(true);
        actualsCommandLine = DesktopSigerCommandLines.builder(sigBuilder.build())
                .goGlobal(goGlobal)
                .build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void goGlobalSigDebugTest() throws SigerCommandLineException {
        // Teste de execução com Web Client
        expectedCommandLine.add("GoGlobal.bat");
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("D");
        sigBuilder.withDebug(true);
        actualsCommandLine = DesktopSigerCommandLines.builder(sigBuilder.build())
                .goGlobal(goGlobal)
                .build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

}
