package com.cg;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StateCodeTest {




        @Test
        public void GivenStateCodeCsvFile_If_DoesntExist_ShouldThrowStateException() throws IOException {
            final String STATECODE_CSVFILE= "F:\\Java_Workspace\\StateCode.csv";
            final String WRONG_FILE = "/wrong.txt";
            try {
                StateCode.openCsvBuilder(WRONG_FILE, StateCodeAnalyser.class);
            } catch (StateException e) {
                e.printStackTrace();
                Assert.assertEquals(StateException.StateExceptionType.NO_SUCH_FILE, e.type);
            }
        }
}
