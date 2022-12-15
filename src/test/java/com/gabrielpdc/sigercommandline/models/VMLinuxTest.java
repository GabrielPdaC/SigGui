package com.gabrielpdc.sigercommandline.models;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;

import org.junit.Test;

public class VMLinuxTest {

    @Test
    public void vmLinuxTest() throws SigerCommandLineException {
        ArrayList<String> expectedArrayList = new ArrayList<>();
        expectedArrayList.add("VMLinux.bat");
        ArrayList<String> actualArrayList = new VMLinux().generateCommandLine();
        assertArrayEquals(expectedArrayList.toArray(), actualArrayList.toArray());
    }

}
