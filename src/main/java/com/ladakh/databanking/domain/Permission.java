package com.ladakh.databanking.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Permission {
    private int permissionID;
    private String name;
    private String description;

    @Id
    @Column(name = "permission_id", nullable = false)
    public int getPermissionID() {
        return permissionID;
    }
    public void setPermissionID(int permissionID) {
        this.permissionID = permissionID;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
