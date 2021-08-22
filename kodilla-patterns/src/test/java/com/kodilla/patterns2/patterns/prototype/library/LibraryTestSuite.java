package com.kodilla.patterns2.patterns.prototype.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        //Given
        Library library = new Library("books");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> library.getBooks().add(new Book("Title " + n, "Author" + n, LocalDate.of(2001,12,12))));

        //making a shallow copy of object board
        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Shallow copy");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //making a deep copy of object board
        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Deep copy");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        library.getBooks().add(new Book("Next book", "Next author", LocalDate.of(2021,4,20)));

        //Then
        Assertions.assertEquals(11, library.getBooks().size());
        Assertions.assertNotEquals(5, library.getBooks().size());
        Assertions.assertEquals(11, clonedLibrary.getBooks().size());
        Assertions.assertNotEquals(5, clonedLibrary.getBooks().size());
        Assertions.assertEquals(10, deepClonedLibrary.getBooks().size());
        Assertions.assertNotEquals(5, deepClonedLibrary.getBooks().size());
    }
}
