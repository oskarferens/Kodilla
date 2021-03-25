package com.kodilla.testing.library;

import java.util.List;

public interface LibraryDatabase {
    List<Book> listBooksInHandsOf(LibraryUser libraryUser);

    boolean rentABook(LibraryUser libraryUser, Book book);

    int returnBooks(LibraryUser libraryUser);

    List<Book> listBooksWithCondition(String titleFragment);
}
