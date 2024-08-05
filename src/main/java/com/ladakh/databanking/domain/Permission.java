package com.ladakh.databanking.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "s_permission")
public class Permission {
    private long permissionID;
    private String name;
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_id", nullable = false)
    public long getPermissionID() {
        return permissionID;
    }
    public void setPermissionID(long permissionID) {
        this.permissionID = permissionID;
    }

    @Column(name = "permission_name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "permission_description")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
