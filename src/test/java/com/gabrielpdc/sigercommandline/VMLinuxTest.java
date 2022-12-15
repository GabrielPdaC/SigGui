package com.gabrielpdc.sigercommandline;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

public class VMLinuxTest {

    @Test
    public void vmLinuxTest() {
        try {
            ArrayList<String> expectedArrayList = new ArrayList<>();
            expectedArrayList.add("VMLinux.bat");
            ArrayList<String> actualArrayList = new VMLinux().generateCommandLine();
            assertArrayEquals(expectedArrayList.toArray(), actualArrayList.toArray());
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu gerar a linha de comando 'GoGlobal.bat'");
        }

    }

}
