package com.gabrielpdc.sigercommandline;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ItcTest {

    private ArrayList<String> expectedCommandLine;
    private ArrayList<String> actualsCommandLine;

    @Before
    public void init() {
        expectedCommandLine = new ArrayList<>();
    }

    @Test
    public void itcTest() {
        // Teste de execução normal
        expectedCommandLine.add("ITC.bat");
        try {
            actualsCommandLine = Itc.builder()
                    .build()
                    .generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void itcPanelTest() {
        // Teste de execução normal
        expectedCommandLine.add("ITC.bat");
        expectedCommandLine.add("PANEL");
        try {
            actualsCommandLine = Itc.builder()
                    .isPanel(true)
                    .build()
                    .generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void itcPortTest() {
        // Teste de execução normal
        expectedCommandLine.add("ITC.bat");
        expectedCommandLine.add("PORT:6000");
        try {
            actualsCommandLine = Itc.builder()
                    .port(6000)
                    .build()
                    .generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void itcDebugTest() {
        // Teste de execução normal
        expectedCommandLine.add("ITC.bat");
        expectedCommandLine.add("D");
        try {
            actualsCommandLine = Itc.builder()
                    .isDebug(true)
                    .build()
                    .generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void itc64BitsTest() {
        // Teste de execução normal
        expectedCommandLine.add("ITC.bat");
        expectedCommandLine.add("64");
        try {
            actualsCommandLine = Itc.builder()
                    .is64(true)
                    .build()
                    .generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void itcShowInfoTest() {
        // Teste de execução normal
        expectedCommandLine.add("ITC.bat");
        expectedCommandLine.add("EX");
        try {
            actualsCommandLine = Itc.builder()
                    .isShowInfo(true)
                    .build()
                    .generateCommandLine();
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu criar linha de comando 'Sig.bat'.");
        }
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

}
