package com.kodilla.patterns2.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    int personalNumber;
    String userName;
    char sex;
    LocalDate birthDate;
    int publishedPosts;

    public ForumUser(final int personalNumber,final String userName,final char sex,final LocalDate birthDate,
                     final int publishedPosts) {
        this.personalNumber = personalNumber;
        this.userName = userName;
        this.sex = sex;
        this.birthDate = birthDate;
        this.publishedPosts = publishedPosts;
    }

    public int getPersonalNumber() {
        return personalNumber;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPublishedPosts() {
        return publishedPosts;
    }
    @Override
    public String toString() {
        return "UserInfo" + "ID=" + personalNumber + ", userName='" + userName +
                ", sex=" + sex + ", dateOfBirth=" + birthDate + ", numberOfPosts=" + publishedPosts;
    }
}
