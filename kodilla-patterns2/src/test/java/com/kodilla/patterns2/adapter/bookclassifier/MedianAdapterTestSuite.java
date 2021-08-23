package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    void publicationYearMedianTest(){
        //Given
        Book book0 = new Book("Title0", "Author0",1995,"123");
        Book book1 = new Book("Title1", "Author1",2005,"456");
        Book book2 = new Book("Title2", "Author2",2015,"789");

        Set<Book> bookSet = new HashSet<>();
        bookSet.add(book0);
        bookSet.add(book1);
        bookSet.add(book2);
        MedianAdapter medianAdapter = new MedianAdapter();

        //When
        int expectedMedian = medianAdapter.publicationYearMedian(bookSet);

        //Then
        System.out.println(expectedMedian);
        assertEquals(expectedMedian, 2005);
    }
}
