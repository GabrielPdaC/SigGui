package com.gabrielpdc.sigercommandline.commands;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.gabrielpdc.sigercommandline.commands.GoGlobal;
import com.gabrielpdc.sigercommandline.commons.CommonsTest;
import com.gabrielpdc.sigercommandline.exceptions.SigerCommandLineException;
import com.gabrielpdc.sigercommandline.models.Term;

public class GoGlobalTest {

    @Test
    public void goGlobalTest() throws SigerCommandLineException {
        ArrayList<String> expectedArrayList = new ArrayList<>();
        expectedArrayList.add("GoGlobal.bat");
        ArrayList<Term> actualArrayList = new GoGlobal().generateCommandLine();
        assertArrayEquals(expectedArrayList.toArray(), CommonsTest.toArrayListString(actualArrayList).toArray());
    }

}
