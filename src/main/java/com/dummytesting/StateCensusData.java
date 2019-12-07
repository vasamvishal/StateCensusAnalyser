package com.dummytesting;

import com.opencsv.bean.CsvBindByName;

public class StateCensusData {
        @CsvBindByName(column = "State",required = true)
        private String State;

        @CsvBindByName(column = "Population",required = true)
        private String Population;

        @CsvBindByName(column = "AreaInSqKm",required =true)
        private String AreaInSqKm ;

        @CsvBindByName(column = "DensityPerSqKm",required = true)
        private String DensityPerSqKm;

        public String getState() {
            return State;
        }

        public void setState(String state) {
            State = state;
        }

        public String getPopulation() {
            return Population;
        }

        public void setPopulation(String population) {
            Population = population;
        }

        public String getAreaInSqKm() {
            return AreaInSqKm;
        }

        public void setAreaInSqKm(String areaInSqKm) {
            AreaInSqKm = areaInSqKm;
        }

        public String getDensityPerSqKm() {
            return DensityPerSqKm;
        }

        public void setDensityPerSqKm(String densityPerSqKm) {
            DensityPerSqKm = densityPerSqKm;
        }

        @Override
        public String toString() {
            return "CSVStateCensus{" +
                    ", state='" + State + '\'' +
                    ", population='" + Population + '\'' +
                    ", areaInSqMs='" + AreaInSqKm + '\'' +
                    ", densityPerSqKm='" + DensityPerSqKm + '\'' +
                    '}';
        }
    }


