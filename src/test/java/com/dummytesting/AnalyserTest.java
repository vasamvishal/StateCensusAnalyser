package com.dummytesting;

import org.junit.Assert;
import org.junit.Test;

public class AnalyserTest {
    @Test
    public void shouldReturnRecords_ForProperFile() {
        try {
            Analyser stateCensusAnalyser = new Analyser();
            int record = stateCensusAnalyser.csvFileLoading("/home/user/Videos/StateCensusData.csv", "com.dummytesting.StateCensusData");
            Assert.assertEquals(29, record);
        } catch (StateCensusAnalyserException e) {
            Assert.assertEquals(StateCensusAnalyserException.ExceptionType.INPUT_FILE_EXCEPTION, e.type);
        }
    }
    @Test
    public void shoulReturnException_forImproperFile()  {
        try {
            Analyser stateCensusAnalyser = new Analyser();
            stateCensusAnalyser.csvFileLoading("/home/user/VideosStateCode.csv", "com.dummyTesting.StateCensusData");
        } catch (StateCensusAnalyserException e) {
            Assert.assertEquals(StateCensusAnalyserException.ExceptionType.NO_SUCHFILE, e.type);
        }
    }
    @Test
    public void shoulReturnException_forInCorrectType() {
        try {
            Analyser stateCensusAnalyser = new Analyser();
            stateCensusAnalyser.csvFileLoading("/home/user/PicturesStateCode.pdf", "com.dummyTesting.StateCensusData");
        } catch (StateCensusAnalyserException e) {
            Assert.assertEquals(StateCensusAnalyserException.ExceptionType.RUNTIME_ERROR, e.type);
        }
    }
}
