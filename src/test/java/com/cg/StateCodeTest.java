package com.cg;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StateCodeTest {
    @Test
    public void GivenTheStateCodeCsvFile_DelimiterIncorrect_ShouldThrowStateException() throws IOException {
        final String STATECODE_CSVFILE= "F:\\Java_Workspace\\StateCode.csv";
        final String WRONG_FILE = "/wrong.txt";
        try {
            int count = StateCode.openCsvBuilder(STATECODE_CSVFILE, StateCodeAnalyser.class);
        } catch (StateException e) {
            e.printStackTrace();
            Assert.assertEquals(StateException.StateExceptionType.DELIMITER_ISSUE, e.type);
        }
    }
}
