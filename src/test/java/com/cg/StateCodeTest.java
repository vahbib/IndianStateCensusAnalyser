package com.cg;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StateCodeTest {
    @Test
    public void GivenStateCodesCsvFile_IfCorrectNumOfRecords_Should_ReturnTrue() throws IOException {
        final String STATECODE_CSVFILE = "F:\\Java_Workspace\\StateCode.csv";
        final String WRONGFILE = "/wrong.csv";
        try {
            int count = StateCode.openCsvBuilder(STATECODE_CSVFILE, StateCodeAnalyser.class);
            System.out.println(count);
            Assert.assertEquals(27, count);
        } catch (StateException e) {
            e.printStackTrace();
        }
    }
}
