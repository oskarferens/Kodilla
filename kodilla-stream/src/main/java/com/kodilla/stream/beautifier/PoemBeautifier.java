package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public String doBeautify(String textToBeautify, PoemDecorator poemDecorator) {
        String result = poemDecorator.beautify(textToBeautify);
        return result;
    }
}