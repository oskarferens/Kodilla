package com.kodilla.patterns2.testing.forum.statistics;

import java.util.List;

interface Statistics {
    List<String> usersNames();
    int postsCount();
    int commentsCount();
}
