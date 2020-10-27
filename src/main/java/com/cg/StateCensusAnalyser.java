
package com.cg;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyser {


    @CsvBindByName(column = "State")
    private String stateName;

    @CsvBindByName(column = "Population",required = true)
    private String population;

    @CsvBindByName(column = "AreaInSqKm")
    private String areaInSqKm;

    @CsvBindByName(column = "DensityPerSqKm", required = true)
    private String densityPerSqKm;

    public StateCensusAnalyser() {

    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getAreaInSqKm() {
        return areaInSqKm;
    }

    public void setAreaInSqKm(String areaInSqKm) {
        this.areaInSqKm = areaInSqKm;
    }

    public String getDensityPerSqKm() {
        return densityPerSqKm;
    }

    public void setDensityPerSqKm(String densityPerSqKm) {
        this.densityPerSqKm = densityPerSqKm;
    }

    @Override
    public String toString() {
        return  "stateName='" + stateName + '\'' +
                ", population='" + population + '\'' +
                ", areaInSqKm='" + areaInSqKm + '\'' +
                ", densityPerSqKm='" + densityPerSqKm + '\''
                +"\n";
    }
}

class StateCensus {

    public StateCensus() {
    }

    public static int openCsvBuilder(String csvFilePath, Object myClass) throws StateException {
        int counter = 0;
        try {
            Iterator<Object> myIterator = getIterator(csvFilePath, myClass);
            while ( myIterator.hasNext() ) {
                counter++;
                Object myObj = myIterator.next();
            }
        } catch (StateException e){
            throw e;
        } catch (RuntimeException e){
            throw new StateException(StateException.StateExceptionType.DELIMITER_ISSUE,
                    "Error related to delimiter at record no. : " +(counter+1));
        }
        return counter;
    }

    public static Iterator<Object> getIterator(String csvFilePath, Object myClass) throws StateException {
        Reader reader = null;
        CsvToBean<Object> csvToBean;
        try {
            reader = Files.newBufferedReader(Paths.get(csvFilePath));
            csvToBean = new CsvToBeanBuilder(reader)
                    .withType((Class) myClass)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<Object> myIterator = csvToBean.iterator();
            return myIterator;
        } catch (NoSuchFileException e) {
            throw new StateException(StateException.StateExceptionType.NO_SUCH_FILE,
                    "file doesn't exists, Enter correct file");
        } catch (RuntimeException e){
            throw new StateException(StateException.StateExceptionType.INCORRECT_DATA_ISSUE,
                    "delimiter error at line 1 OR might be some error " +
                            "related to headers or incorrect extension / input file ");
        } catch (IOException e) {
            throw new StateException(StateException.StateExceptionType.SOME_OTHER_IO_EXCEPTION,
                    "Some other IO related exception");
        }
    }

}