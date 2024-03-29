package com.dummytesting;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

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
    public void shoulReturnException_ForImproperFile()  {
        try {
            Analyser stateCensusAnalyser = new Analyser();
            stateCensusAnalyser.csvFileLoading("/home/user/VideosStateCode.csv", "com.dummytesting.StateCensusData");
        } catch (StateCensusAnalyserException e) {
            Assert.assertEquals(StateCensusAnalyserException.ExceptionType.NO_SUCHFILE, e.type);
        }
    }
    @Test
    public void shoulReturnException_ForInCorrectType() {
        try {
            Analyser stateCensusAnalyser = new Analyser();
            stateCensusAnalyser.csvFileLoading("/home/user/Videos/StateCode.pdf", "com.dummytesting.StateCensusData");
        } catch (StateCensusAnalyserException e) {
            Assert.assertEquals(StateCensusAnalyserException.ExceptionType.RUNTIME_ERROR, e.type);
        }
    }
    @Test
    public void shouldCatchException_ForImproperDelimiter()  {
        try {
            Analyser analyser = new Analyser();
            analyser.csvFileLoading("/home/user/Videos/StateCensusDataDuplicate.csv", "com.dummyTesting.StateCensusData");
        } catch (StateCensusAnalyserException e) {
            Assert.assertEquals(StateCensusAnalyserException.ExceptionType.RUNTIME_ERROR, e.type);
        }
    }
    @Test
    public void shouldCatchException_ForHavingNoHeaders() {
        try {
            Analyser analyser = new Analyser();
            analyser.csvFileLoading("/home/user/snap/StateCensusDataDuplicate.csv", "com.dummyTesting.StateCensusData");
        } catch (StateCensusAnalyserException e) {
            Assert.assertEquals(StateCensusAnalyserException.ExceptionType.RUNTIME_ERROR, e.type);
        }
    }
    @Test
    public void shouldWriteFile_InToJsonfile() throws StateCensusAnalyserException {
            Analyser analyser = new Analyser();
            analyser.csvFileLoading("/home/user/snap/StateCensusData.csv","com.dummyTesting.StateCensusData");
            List<StateCensusData> stateCensusData = analyser.writeToJson("/home/user/Videos/AreaInSqKm.json");
            Assert.assertEquals("Uttar Pradesh",stateCensusData.get(0).getState());
    }
    @Test
    public void shouldCatchException_ForImProperJsonfile()  {
        try {
            Analyser analyser = new Analyser();
            analyser.csvFileLoading("/home/user/snapStateCensusData.csv","com.dummyTesting.StateCensusData");
            List<StateCensusData> stateCensusData = analyser.writeToJson("/home/user/Videos/StateCensusAnalyser.json");
        } catch (StateCensusAnalyserException e) {
            Assert.assertEquals(StateCensusAnalyserException.ExceptionType.NO_SUCHFILE,e.type);
        }
    }
    @Test
    public void shouldCatchIOException_ForImProperJsonfile()  {
        try {
            Analyser analyser = new Analyser();
            analyser.csvFileLoading("/home/user/snap/StateCensusData/.csv","com.dummyTesting.StateCensusData");
            List<StateCensusData> stateCensusData = analyser.writeToJson("/home/user/Videos/StateCensusAnalyser.json");
        } catch (StateCensusAnalyserException e) {
            Assert.assertEquals(StateCensusAnalyserException.ExceptionType.INPUT_FILE_EXCEPTION,e.type);
        }
    }
    @Test
    public void shouldCatchException_ForImProperFileName_InJsonfile() {
        try {
            Analyser analyser = new Analyser();
            analyser.csvFileLoading("/home/user/snap/StateCensusData/.csv", "com.dummyTesting.StateCensusData");
            List<StateCensusData> stateCensusData = analyser.writeToJson("/home/user/Videos/State/CensusAnalyser.json");
            Assert.assertEquals("Uttar Pradesh", stateCensusData.get(0).getState());
        } catch (StateCensusAnalyserException e) {
            Assert.assertEquals(StateCensusAnalyserException.ExceptionType.NO_SUCHFILE, e.type);
        }
    }
    @Test
    public void shouldSortDataAlphabetically_ForStateName()  {
        try {
            Analyser analyser = new Analyser();
            List<StateCensusData> stateCensusData = analyser.writeToJson("/home/user/Videos/StateName.json");
            analyser.sortThisListBasedOnStateName(stateCensusData);
        } catch (StateCensusAnalyserException e){
            Assert.assertEquals(StateCensusAnalyserException.ExceptionType.INPUT_FILE_EXCEPTION,e.type);
        }
    }
    @Test
    public void shouldSortData_ForStateName_ForPopulation() {
        try {
            Analyser analyser = new Analyser();
            List<StateCensusData> stateCensusData = analyser.writeToJson("/home/user/Videos/StateName.json");
            analyser.sortThisListBasedOnStatePopulation(stateCensusData);
        } catch (StateCensusAnalyserException e) {
            Assert.assertEquals(StateCensusAnalyserException.ExceptionType.INPUT_FILE_EXCEPTION,e.type);
        }
    }
    @Test
    public void shouldSortData_ForStateName_ByAreaPerSqKm() {
        try {
            Analyser analyser = new Analyser();
            List<StateCensusData> stateCensusData = analyser.writeToJson("/home/user/Videos/StateName.json");
            analyser.sortThisListBasedOnAreaPerSqKm(stateCensusData);
        } catch (StateCensusAnalyserException e) {
            Assert.assertEquals(StateCensusAnalyserException.ExceptionType.INPUT_FILE_EXCEPTION,e.type);
        }
    }
}
