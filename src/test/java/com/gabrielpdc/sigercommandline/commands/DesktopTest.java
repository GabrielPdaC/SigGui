package com.gabrielpdc.sigercommandline.commands;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.gabrielpdc.sigercommandline.commands.Desktop;
import com.gabrielpdc.sigercommandline.commands.GoGlobal;
import com.gabrielpdc.sigercommandline.commands.Sig;
import com.gabrielpdc.sigercommandline.commons.CommonsTest;
import com.gabrielpdc.sigercommandline.exceptions.SigerCommandLineException;
import com.gabrielpdc.sigercommandline.models.Term;

public class DesktopTest {

    private ArrayList<String> expectedCommandLine;
    private ArrayList<Term> actualsCommandLine;
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
        actualsCommandLine = Desktop.builder(sigBuilder.build()).build().generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

    @Test
    public void sigUserPasswordTest() throws SigerCommandLineException {
        // Teste de execução passando usuário e senha
        expectedCommandLine.add("Sig.bat VS-USUARI:RECH VS-SENUSU:RECH12345");

        sigBuilder.user("RECH").password("RECH12345");
        actualsCommandLine = Desktop.builder(sigBuilder.build())
                .build()
                .generateCommandLine();

        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

    @Test
    public void sigCompanyTest() throws SigerCommandLineException {
        // Teste de execução passando sigla de empresa
        expectedCommandLine.add("Sig.bat VS-SIGEMP:GCO");

        sigBuilder.company("GCO");
        actualsCommandLine = Desktop.builder(sigBuilder.build())
                .build()
                .generateCommandLine();

        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

    @Test
    public void sigMenuTest() throws SigerCommandLineException {
        // Teste de execução passando opção de menu
        expectedCommandLine.add("Sig.bat VS-OPCMEN:512A");

        sigBuilder.menu("512A");
        actualsCommandLine = Desktop.builder(sigBuilder.build())
                .build()
                .generateCommandLine();

        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

    @Test
    public void sigDebugJavaTest() throws SigerCommandLineException {
        // Teste de execução com Web Client
        expectedCommandLine.add("Sig.bat DJ");

        sigBuilder.withDebugJava(true);
        actualsCommandLine = Desktop.builder(sigBuilder.build())
                .build()
                .generateCommandLine();

        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

    @Test
    public void sigProfilerTest() throws SigerCommandLineException {
        // Teste de execução com Web Client
        expectedCommandLine.add("Sig.bat PJ");

        sigBuilder.withProfiler(true);
        actualsCommandLine = Desktop.builder(sigBuilder.build())
                .build()
                .generateCommandLine();

        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

    @Test
    public void sigDebugTest() throws SigerCommandLineException {
        // Teste de execução com Web Client
        expectedCommandLine.add("Sig.bat D");

        sigBuilder.withDebug(true);
        actualsCommandLine = Desktop.builder(sigBuilder.build())
                .build()
                .generateCommandLine();

        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

    @Test
    public void goGlobalSigTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("GoGlobal.bat");
        expectedCommandLine.add("Sig.bat");
        actualsCommandLine = Desktop.builder(sigBuilder.build())
                .goGlobal(goGlobal)
                .build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

    @Test
    public void goGlobalSigUserPasswordTest() throws SigerCommandLineException {
        // Teste de execução passando usuário e senha
        expectedCommandLine.add("GoGlobal.bat");
        expectedCommandLine.add("Sig.bat VS-USUARI:RECH VS-SENUSU:RECH12345");

        sigBuilder.user("RECH").password("RECH12345");
        actualsCommandLine = Desktop.builder(sigBuilder.build())
                .goGlobal(goGlobal)
                .build()
                .generateCommandLine();

        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

    @Test
    public void goGlobalSigCompanyTest() throws SigerCommandLineException {
        // Teste de execução passando sigla de empresa
        expectedCommandLine.add("GoGlobal.bat");
        expectedCommandLine.add("Sig.bat VS-SIGEMP:GCO");

        sigBuilder.company("GCO");
        actualsCommandLine = Desktop.builder(sigBuilder.build())
                .goGlobal(goGlobal)
                .build()
                .generateCommandLine();

        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

    @Test
    public void goGlobalSigMenuTest() throws SigerCommandLineException {
        // Teste de execução passando opção de menu
        expectedCommandLine.add("GoGlobal.bat");
        expectedCommandLine.add("Sig.bat VS-OPCMEN:512A");

        sigBuilder.menu("512A");
        actualsCommandLine = Desktop.builder(sigBuilder.build())
                .goGlobal(goGlobal)
                .build()
                .generateCommandLine();

        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

    @Test
    public void goGlobalSigDebugJavaTest() throws SigerCommandLineException {
        // Teste de execução com Web Client
        expectedCommandLine.add("GoGlobal.bat");
        expectedCommandLine.add("Sig.bat DJ");

        sigBuilder.withDebugJava(true);
        actualsCommandLine = Desktop.builder(sigBuilder.build())
                .goGlobal(goGlobal)
                .build()
                .generateCommandLine();

        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

    @Test
    public void goGlobalSigProfilerTest() throws SigerCommandLineException {
        // Teste de execução com Web Client
        expectedCommandLine.add("GoGlobal.bat");
        expectedCommandLine.add("Sig.bat PJ");

        sigBuilder.withProfiler(true);
        actualsCommandLine = Desktop.builder(sigBuilder.build())
                .goGlobal(goGlobal)
                .build()
                .generateCommandLine();

        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

    @Test
    public void goGlobalSigDebugTest() throws SigerCommandLineException {
        // Teste de execução com Web Client
        expectedCommandLine.add("GoGlobal.bat");
        expectedCommandLine.add("Sig.bat D");

        sigBuilder.withDebug(true);
        actualsCommandLine = Desktop.builder(sigBuilder.build())
                .goGlobal(goGlobal)
                .build()
                .generateCommandLine();

        assertArrayEquals(expectedCommandLine.toArray(), CommonsTest.toArrayListString(actualsCommandLine).toArray());
    }

}
