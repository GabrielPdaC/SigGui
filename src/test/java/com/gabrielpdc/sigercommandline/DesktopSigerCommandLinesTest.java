package com.gabrielpdc.sigercommandline;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

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
    public void sigTest() {
        // Teste de execução normal
        expectedCommandLine.add("Sig.bat");
        try {
            actualsCommandLine = DesktopSigerCommandLines.builder(sigBuilder.build()).build().generateCommandLine();
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
            sigBuilder.user("RECH").password("RECH12345");
            actualsCommandLine = DesktopSigerCommandLines.builder(sigBuilder.build())
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
            sigBuilder.company("GCO");
            actualsCommandLine = DesktopSigerCommandLines.builder(sigBuilder.build())
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
            sigBuilder.menu("512A");
            actualsCommandLine = DesktopSigerCommandLines.builder(sigBuilder.build())
                    .build()
                    .generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void sigDebugJavaTest() {
        // Teste de execução com Web Client
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("DJ");
        try {
            sigBuilder.isDebugJava(true);
            actualsCommandLine = DesktopSigerCommandLines.builder(sigBuilder.build())
                    .build()
                    .generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void sigProfilerTest() {
        // Teste de execução com Web Client
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("PJ");
        try {
            sigBuilder.isProfiler(true);
            actualsCommandLine = DesktopSigerCommandLines.builder(sigBuilder.build())
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
            sigBuilder.isDebug(true);
            actualsCommandLine = DesktopSigerCommandLines.builder(sigBuilder.build())
                    .build()
                    .generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void goGlobalSigTest() {
        // Teste de execução normal
        expectedCommandLine.add("GoGlobal.bat");
        expectedCommandLine.add("Sig.bat");
        try {
            actualsCommandLine = DesktopSigerCommandLines.builder(sigBuilder.build())
                    .goGlobal(goGlobal)
                    .build()
                    .generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void goGlobalSigUserPasswordTest() {
        // Teste de execução passando usuário e senha
        expectedCommandLine.add("GoGlobal.bat");
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("VS-USUARI:RECH");
        expectedCommandLine.add("VS-SENUSU:RECH12345");
        try {
            sigBuilder.user("RECH").password("RECH12345");
            actualsCommandLine = DesktopSigerCommandLines.builder(sigBuilder.build())
                    .goGlobal(goGlobal)
                    .build()
                    .generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void goGlobalSigCompanyTest() {
        // Teste de execução passando sigla de empresa
        expectedCommandLine.add("GoGlobal.bat");
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("VS-SIGEMP:GCO");
        try {
            sigBuilder.company("GCO");
            actualsCommandLine = DesktopSigerCommandLines.builder(sigBuilder.build())
                    .goGlobal(goGlobal)
                    .build()
                    .generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void goGlobalSigMenuTest() {
        // Teste de execução passando opção de menu
        expectedCommandLine.add("GoGlobal.bat");
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("VS-OPCMEN:512A");
        try {
            sigBuilder.menu("512A");
            actualsCommandLine = DesktopSigerCommandLines.builder(sigBuilder.build())
                    .goGlobal(goGlobal)
                    .build()
                    .generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void goGlobalSigDebugJavaTest() {
        // Teste de execução com Web Client
        expectedCommandLine.add("GoGlobal.bat");
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("DJ");
        try {
            sigBuilder.isDebugJava(true);
            actualsCommandLine = DesktopSigerCommandLines.builder(sigBuilder.build())
                    .goGlobal(goGlobal)
                    .build()
                    .generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void goGlobalSigProfilerTest() {
        // Teste de execução com Web Client
        expectedCommandLine.add("GoGlobal.bat");
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("PJ");
        try {
            sigBuilder.isProfiler(true);
            actualsCommandLine = DesktopSigerCommandLines.builder(sigBuilder.build())
                    .goGlobal(goGlobal)
                    .build()
                    .generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void goGlobalSigDebugTest() {
        // Teste de execução com Web Client
        expectedCommandLine.add("GoGlobal.bat");
        expectedCommandLine.add("Sig.bat");
        expectedCommandLine.add("D");
        try {
            sigBuilder.isDebug(true);
            actualsCommandLine = DesktopSigerCommandLines.builder(sigBuilder.build())
                    .goGlobal(goGlobal)
                    .build()
                    .generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

}
