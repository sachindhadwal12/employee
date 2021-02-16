package com.myBatis.EmployeeCrud.exception;


public class EmployeeAlreadyExitsException extends Exception{
    private String msg;

    public EmployeeAlreadyExitsException() {
    }

    public EmployeeAlreadyExitsException(String message, String msg) {
        super(message);
        this.msg = msg;
    }
}
