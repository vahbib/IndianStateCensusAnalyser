package com.cg;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StateCensusTest {
    @Test
    public void GivenStateCensusCsvFile_If_DoesntExist_ShouldThrowCensusAnalyserException() throws IOException {
        final String STATECENSUS_CSVFILE= "F:\\Java_Workspace\\StateCensusData.csv";
        final String WRONG_FILE = "/wrong.txt";
        try {
            StateCensus.openCsvBuilder(WRONG_FILE, StateCensusAnalyser.class);
        } catch (StateException e) {
            e.printStackTrace();
            Assert.assertEquals(StateException.StateExceptionType.NO_SUCH_FILE, e.type);
        }
    }
}
