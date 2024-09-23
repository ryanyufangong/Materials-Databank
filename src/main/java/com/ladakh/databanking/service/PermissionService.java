package com.ladakh.databanking.service;

public interface PermissionService {
    String getPermissionName(long permissionID);
    String changePermissionName(long permissionID, String newPermissionName);
    String getPermissionDescription(long permissionID);
    String changePermissionDescription(long permissionID, String newPermissionDescription);
}
