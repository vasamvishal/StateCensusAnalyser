package com.dummytesting;

public class StateCensusAnalyserException extends Exception{
        public enum ExceptionType{
            NO_SUCHFILE, RUNTIME_ERROR,INPUT_FILE_EXCEPTION;
        }
        public ExceptionType type;

        public StateCensusAnalyserException(String message, ExceptionType type) {
            super(message);
            this.type= type;
        }
        public StateCensusAnalyserException(ExceptionType type, Throwable cause) {
            super(cause);
            this.type= type;
        }
    }

