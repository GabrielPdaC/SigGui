package com.gabrielpdc.sigercommandline.commands;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.gabrielpdc.sigercommandline.commands.VMLinux;
import com.gabrielpdc.sigercommandline.commons.CommonsTest;
import com.gabrielpdc.sigercommandline.exceptions.SigerCommandLineException;
import com.gabrielpdc.sigercommandline.models.Term;

public class VMLinuxTest {

    @Test
    public void vmLinuxTest() throws SigerCommandLineException {
        ArrayList<String> expectedArrayList = new ArrayList<>();
        expectedArrayList.add("VMLinux.bat");
        ArrayList<Term> actualArrayList = new VMLinux().generateCommandLine();
        assertArrayEquals(expectedArrayList.toArray(), CommonsTest.toArrayListString(actualArrayList).toArray());
    }

}
