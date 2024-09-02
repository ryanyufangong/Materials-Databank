package com.ladakh.databanking.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "s_user")
public class User {

    private long userID;
    private  String password;
    private String username;
    private Set<Permission> permissions;
    private Set<Group> groups;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    public long getUserID() {
        return userID;
    }
    public void setUserID(long userID) {
        this.userID = userID;
    }

    @Column(name = "user_password")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "s_user_permission", joinColumns = {@JoinColumn(name="user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id" ,referencedColumnName = "permission_id")})
    public Set<Permission> getPermissions() {
        return permissions;
    }
    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "s_user_group", joinColumns = {@JoinColumn(name="user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "group_id" ,referencedColumnName = "group_id")})
    public Set<Group> getGroups() {
        return groups;
    }
    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }
}
