package com.kodilla.patterns2.hibernate.manytomany.facade;

public class CompanyException extends Exception {
    public static String ERR_NOT_EXIST = "Such company doesn't exist";

    public CompanyException(String message) {
        super(message);
    }
}