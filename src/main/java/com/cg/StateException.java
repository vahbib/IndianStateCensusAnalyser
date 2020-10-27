package com.cg;

public class StateException extends Exception{
    enum StateExceptionType
    {
        NO_SUCH_FILE, INCORRECT_DATA_ISSUE, SOME_OTHER_IO_EXCEPTION, DELIMITER_ISSUE,  NO_SUCH_CLASS
    }
    StateExceptionType type;
    private String message;

    public StateException(StateExceptionType type, String message) {
        super(message);
        this.type = type;
    }

}