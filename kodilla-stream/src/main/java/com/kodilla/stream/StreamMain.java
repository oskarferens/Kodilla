package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;

class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.doBeautify("first text",(textToBeautify -> "ಠ_ಠ " +textToBeautify+" ಠ_ಠ"));
        poemBeautifier.doBeautify("second text",(textToBeautify -> "◔̯ ◔ " +textToBeautify+" ◔̯ ◔"));
        poemBeautifier.doBeautify("third text",(textToBeautify -> "(͡°͜ʖ͡°) " +textToBeautify+" (͡°͜ʖ͡°)"));

        System.out.println(poemBeautifier.doBeautify("first text",(textToBeautify -> "ಠ_ಠ " +textToBeautify+" ಠ_ಠ")));
        System.out.println(poemBeautifier.doBeautify("second text",(textToBeautify -> "◔̯ ◔ " +textToBeautify+" ◔̯ ◔")));
        System.out.println(poemBeautifier.doBeautify("third text",(textToBeautify -> "(͡°͜ʖ͡°) " +textToBeautify+" (͡°͜ʖ͡°)")));
    }
}