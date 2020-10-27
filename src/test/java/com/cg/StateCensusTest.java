package com.cg;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StateCensusTest {
    public static final String STATECENSUS_CSVFILE= "F:\\Java_Workspace\\StateCensusData.csv";
    public static final String WRONG_FILE = "/wrong.txt";
    @Test
    public void GivenTheStateCodesCsvFile_IfHasCorrectNumberOfRecords_ShouldReturnTrue() throws IOException {
        try {
            int count = StateCensus.openCsvBuilder(STATECENSUS_CSVFILE, StateCensus.class);
            System.out.println(count);
            Assert.assertEquals(29, count);
        } catch (StateException e) {
            e.printStackTrace();
        }
    }

}
