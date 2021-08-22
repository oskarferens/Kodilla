package com.kodilla.patterns2.exception.main;
import com.kodilla.patterns2.exception.io.FileReader;
import com.kodilla.patterns2.exception.io.FileReaderException;

public class ExceptionModuleRunner {

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        try {
            fileReader.readFile();
        } catch (FileReaderException e) {
            System.out.println("Problem while reading a file!");
        }
    }
}