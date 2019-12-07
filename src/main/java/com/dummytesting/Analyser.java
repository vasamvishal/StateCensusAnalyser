//Welcome to StateCensusAnalyser
package com.dummytesting;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Analyser {

    List<StateCensusData> recordList = new ArrayList();
    List<StateCensusData> censusList = new ArrayList();
    public int csvFileLoading(String pathName, String pojoFileName) throws  StateCensusAnalyserException {
        int noOfRecord = 0;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(pathName));
            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Class.forName(pojoFileName))
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator csvUserIterator = csvToBean.iterator();
            while (csvUserIterator.hasNext()) {
                StateCensusData data = (StateCensusData) csvUserIterator.next();
                recordList.add(data);
                noOfRecord++;
            }
        } catch (NoSuchFileException e) {
            throw new StateCensusAnalyserException("please enter proper file name", StateCensusAnalyserException.ExceptionType.INPUT_FILE_EXCEPTION);
        } catch (IOException e) {
            throw new StateCensusAnalyserException("Please enter proper input/output file", StateCensusAnalyserException.ExceptionType.INPUT_FILE_EXCEPTION);
        } catch (ClassNotFoundException e) {
            throw new StateCensusAnalyserException("Please Enter Proper Class Name", StateCensusAnalyserException.ExceptionType.INPUT_FILE_EXCEPTION);
        }
        return noOfRecord;
    }
}
