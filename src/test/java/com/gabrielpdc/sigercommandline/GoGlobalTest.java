package com.gabrielpdc.sigercommandline;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

public class GoGlobalTest {

    @Test
    public void goGlobalTest() {
        try {
            ArrayList<String> expectedArrayList = new ArrayList<>();
            expectedArrayList.add("GoGlobal.bat");
            ArrayList<String> actualArrayList = new GoGlobal().generateCommandLine();
            assertArrayEquals(expectedArrayList.toArray(), actualArrayList.toArray());
        } catch (SigerCommandLineException e) {
            fail("Não conseguiu gerar a linha de comando 'GoGlobal.bat'");
        }

    }

}
