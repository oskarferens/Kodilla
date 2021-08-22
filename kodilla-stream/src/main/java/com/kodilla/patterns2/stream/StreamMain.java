package com.kodilla.patterns2.stream;

import com.kodilla.patterns2.stream.forumuser.Forum;
import com.kodilla.patterns2.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {
        Forum forum = new Forum();
        Map<Integer, ForumUser> collection = forum.getUserList().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> forumUser.getBirthDate().isBefore(LocalDate.now().minusYears(20)))
                .filter(forumUser -> forumUser.getPublishedPosts() > 0)
                .collect(Collectors.toMap(ForumUser::getPersonalNumber, forumUser -> forumUser));

        System.out.println(collection);
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