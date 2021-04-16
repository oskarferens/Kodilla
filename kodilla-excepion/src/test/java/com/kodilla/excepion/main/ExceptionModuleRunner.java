package com.kodilla.excepion.main;

import com.kodilla.exception.io.FileReader;

public class ExceptionModuleRunner {

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        fileReader.readFile();
    }
}