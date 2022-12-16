package com.gabrielpdc.sigercommandline.models;

import static org.junit.Assert.assertArrayEquals;
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
    public void itcTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("ITC.bat");
        actualsCommandLine = Itc.builder()
                .build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void itcPanelTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("ITC.bat");
        expectedCommandLine.add("PANEL");
        actualsCommandLine = Itc.builder()
                .withPanel(true)
                .build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void itcPortTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("ITC.bat");
        expectedCommandLine.add("PORT:6000");
        actualsCommandLine = Itc.builder()
                .port(6000)
                .build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void itcDebugTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("ITC.bat");
        expectedCommandLine.add("D");
        actualsCommandLine = Itc.builder()
                .withDebug(true)
                .build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void itc64BitsTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("ITC.bat");
        expectedCommandLine.add("64");
        actualsCommandLine = Itc.builder()
                .with64bits(true)
                .build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

    @Test
    public void itcShowInfoTest() throws SigerCommandLineException {
        // Teste de execução normal
        expectedCommandLine.add("ITC.bat");
        expectedCommandLine.add("EX");
        actualsCommandLine = Itc.builder()
                .withJavaOutput(true)
                .build()
                .generateCommandLine();
        assertArrayEquals(expectedCommandLine.toArray(), actualsCommandLine.toArray());
    }

}
