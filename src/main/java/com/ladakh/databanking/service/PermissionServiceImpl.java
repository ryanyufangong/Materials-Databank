package com.ladakh.databanking.service;

import com.ladakh.databanking.dao.PermissionDAO;
import com.ladakh.databanking.domain.Permission;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService{
    @Resource
    private PermissionDAO permissionDAO;

    public String getPermissionName(long permissionID) {
        Permission permission = permissionDAO.findByPermissionID(permissionID);
        return permission.getName();
    }

    public String changePermissionName(long permissionID, String newPermissionName) {
        Permission permission = permissionDAO.findByPermissionID(permissionID);
        permission.setName(newPermissionName);
        permission = permissionDAO.save(permission);
        return permission.getName();
    }

    public String getPermissionDescription(long permissionID) {
        Permission permission = permissionDAO.findByPermissionID(permissionID);
        return permission.getDescription();
    }

    public String changePermissionDescription(long permissionID, String newPermissionDescription) {
        Permission permission = permissionDAO.findByPermissionID(permissionID);
        permission.setDescription(newPermissionDescription);
        permission = permissionDAO.save(permission);
        return permission.getDescription();
    }
}
