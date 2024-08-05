package com.ladakh.databanking.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "s_group")
public class Group {
    private long groupID;
    private String groupName;
    private Set<Permission> permissions;
    private Set<User> users;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id", nullable = false)
    public long getGroupID() {
        return groupID;
    }
    public void setGroupID(long groupID) {
        this.groupID = groupID;
    }

    @Column(name = "group_name")
    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "s_group_permission", joinColumns = {@JoinColumn(name="group_id", referencedColumnName = "group_id")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id" ,referencedColumnName = "permission_id")})
    public Set<Permission> getPermissions() {
        return permissions;
    }
    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "s_user_group", joinColumns = {@JoinColumn(name="group_id", referencedColumnName = "group_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id" ,referencedColumnName = "user_id")})
    public Set<User> getUsers() {
        return users;
    }
    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
