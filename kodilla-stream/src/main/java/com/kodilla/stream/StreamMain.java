package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;

class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.doBeautify("first text",(textToBeautify -> "ಠ_ಠ " +textToBeautify+" ಠ_ಠ"));
        poemBeautifier.doBeautify("second text",(textToBeautify -> "◔̯ ◔ " +textToBeautify+" ◔̯ ◔"));
        poemBeautifier.doBeautify("third text",(textToBeautify -> "(͡°͜ʖ͡°) " +textToBeautify+" (͡°͜ʖ͡°)"));

        System.out.println(poemBeautifier.doBeautify("first text",(textToBeautify -> "ಠ_ಠ " +textToBeautify+" ಠ_ಠ")));
        System.out.println(poemBeautifier.doBeautify("second text",(textToBeautify -> "◔̯ ◔ " +textToBeautify+" ◔̯ ◔")));
        System.out.println(poemBeautifier.doBeautify("third text",(textToBeautify -> "(͡°͜ʖ͡°) " +textToBeautify+" (͡°͜ʖ͡°)")));

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}