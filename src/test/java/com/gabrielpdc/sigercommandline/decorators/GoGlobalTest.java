package com.gabrielpdc.sigercommandline.decorators;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.gabrielpdc.sigercommandline.Commons.CommonsTest;
import com.gabrielpdc.sigercommandline.Execptions.SigerCommandLineException;
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
