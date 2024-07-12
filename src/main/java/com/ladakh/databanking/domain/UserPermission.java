package com.ladakh.databanking.domain;

import jakarta.persistence.*;


@Entity
@Table
public class UserPermission {
    private User user;
    private Permission permission;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "permission_id")
    public Permission getPermission() {
        return permission;
    }
    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
