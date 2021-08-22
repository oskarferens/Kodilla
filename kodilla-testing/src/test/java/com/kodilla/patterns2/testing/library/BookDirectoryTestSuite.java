package com.kodilla.patterns2.testing.library;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuite {

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    void testListBookWithConditionsReturnList() {
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("first title","first author", 1);
        Book book2 = new Book("second title","second author", 2);
        Book book3 = new Book("third title","third author", 3);
        Book book4 = new Book("fourth title","fourth author", 4);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("first")).thenReturn(resultListOfBooks);
        //when
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("first");
        //Then
        assertEquals(4,theListOfBooks.size());
    }

    @Test
    void testListBookWithConditionMoreThan20 () {
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<Book>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(resultListOf40Books);
        //When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("AnyTitle");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");
        //Then
        assertEquals(0,theListOfBooks0.size());
        assertEquals(15,theListOfBooks15.size());
        assertEquals(0,theListOfBooks40.size());
    }

    @Test
    void testListBooksWithConditionFragmentShorterThan3() {
        //Given
        LibraryDatabase libraryDataBaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        //When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");
        //Then
        assertEquals(0,theListOfBooks10.size());
        verify(libraryDataBaseMock,times(0)).listBooksWithCondition(anyString());
    }

    @Test
    void testListBooksInHandsOf0() {
        // Given
        LibraryUser libraryUser  = new LibraryUser("Jan", "Kowalski", "0123456789");
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultBookList = new ArrayList<>();
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultBookList);
        // When
        List<Book> TheListOfBooks = bookLibrary.listBooksInHandsOf(libraryUser);
        // Then
        assertEquals(0,TheListOfBooks.size());
    }

    @Test
    void testListBookInHandsOf1() {
        // Given
        LibraryUser libraryUser = new LibraryUser("Jan","Kowalski","0123456789");
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultBookList1 = generateListOfNBooks(1);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultBookList1);
        // When
        List<Book> bookList = bookLibrary.listBooksInHandsOf(libraryUser);
        // Then
        assertEquals(1,bookList.size());
    }

    @Test
    void testListBooksInHandOf5() {
        // Given
        LibraryUser libraryUser = new LibraryUser("Jan","Kowalski","0123456789");
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultBookList5 = generateListOfNBooks(5);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultBookList5);
        // When
        List<Book> theListOfBooks = bookLibrary.listBooksInHandsOf(libraryUser);
        // Then
        assertEquals(5,theListOfBooks.size());
    }
}