package com.gabrielpdc.sigercommandline.models;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;

import org.junit.Test;

public class GoGlobalTest {

    @Test
    public void goGlobalTest() throws SigerCommandLineException {
        ArrayList<String> expectedArrayList = new ArrayList<>();
        expectedArrayList.add("GoGlobal.bat");
        ArrayList<String> actualArrayList = new GoGlobal().generateCommandLine();
        assertArrayEquals(expectedArrayList.toArray(), actualArrayList.toArray());
    }

}
