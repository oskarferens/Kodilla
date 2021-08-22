package com.kodilla.patterns2.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {
    private final List<ForumUser> userList = new ArrayList<>();

    public Forum() {
        userList.add(new ForumUser(0001,"Ronnie Coleman", 'M', LocalDate.of(1970,04,15),117));
        userList.add(new ForumUser(0002,"Kai Greene", 'M', LocalDate.of(1979,11,25),215));
        userList.add(new ForumUser(0003,"Andrea Shaw",'W', LocalDate.of(1983,12,12), 98));
        userList.add(new ForumUser(0004, "Jay Cutler", 'M', LocalDate.of(1971,06,30), 57));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(userList);
    }
}
