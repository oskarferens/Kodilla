package com.kodilla.patterns2.testing.library;

import java.util.List;


public interface LibraryDatabase {
    List<Book> listBooksWithCondition(String titleFragment);

    List<Book> listBooksInHandsOf(LibraryUser libraryUser);

    boolean rentABook(LibraryUser libraryUser, Book book);

    int returnBooks(LibraryUser libraryUser);
}