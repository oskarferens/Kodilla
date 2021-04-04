package com.kodilla.stream;

public class StreamMain {

    public static void main(String[] args) {
        // Zainicjuj strumien stream kolekcji
        //odfiltruj meszczyzn

    }
}

//        BookDirectory theBookDirectory = new BookDirectory();
//
//        Map<String, Book> theResultMapOfBooks = theBookDirectory.getList().stream()
//                .filter(book -> book.getYearOfPublication() > 2005)
//                .collect(Collectors.toMap(Book::getSignature, book -> book));             // [1]
//
//        System.out.println("# elements: " + theResultMapOfBooks.size());             // [2]
//        theResultMapOfBooks.entrySet().stream()
//                .map(entry -> entry.getKey() + ": " + entry.getValue())                   // [3]
//                .forEach(System.out::println);                                            // [4]
//    }