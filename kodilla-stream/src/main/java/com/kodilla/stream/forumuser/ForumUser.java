package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int personalNumber;
    private final String userName;
    private final char sex;
    private final LocalDate birthDate;
    private final int publicatedPosts;

    public ForumUser(final int personalNumber, final String userName, final char sex, final LocalDate birthDate, final int publicatedPosts) {
        this.personalNumber = personalNumber;
        this.userName = userName;
        this.sex = sex;
        this.birthDate = birthDate;
        this.publicatedPosts = publicatedPosts;
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

    public int getPublicatedPosts() {
        return publicatedPosts;
    }
}
