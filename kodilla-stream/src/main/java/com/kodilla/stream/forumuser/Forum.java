package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> forumUsersList = new ArrayList<>();

    public Forum(){
        forumUsersList.add(new ForumUser(723649, "JilBoy", 'M', LocalDate.of(1999, 12, 3), 88 ));
        forumUsersList.add(new ForumUser(49012, "GameBoss", 'M', LocalDate.of(2003, 4, 17), 63));
        forumUsersList.add(new ForumUser(645093, "Queen_13", 'K', LocalDate.of(2000, 1, 1), 91));
        forumUsersList.add(new ForumUser(230900, "DaisyStar", 'K', LocalDate.of(1995, 6, 11), 32));
        forumUsersList.add(new ForumUser(745923, "KingMario", 'M', LocalDate.of(2002, 6, 3), 54));
        forumUsersList.add(new ForumUser(436274, "ManyMore", 'K', LocalDate.of(1998, 2, 2), 73));
    }


    public List<ForumUser> getForumUsersList() {
        return new ArrayList<>(forumUsersList);
    }
}
