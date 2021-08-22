package com.kodilla.patterns2.hibernate.manytomany.facade;

public class EmployeeException extends Exception {
    public static String ERR_NOT_EXIST = "Employee doesn't exist";

    public EmployeeException(String message) {
        super(message);
    }
}
