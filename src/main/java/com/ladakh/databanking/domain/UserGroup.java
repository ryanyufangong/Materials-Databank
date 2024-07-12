package com.ladakh.databanking.domain;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class UserGroup {
    private User user;
    private Group group;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "group_id")
    public Group getGroup() {
        return group;
    }
    public void setGroup(Group group) {
        this.group = group;
    }
}
