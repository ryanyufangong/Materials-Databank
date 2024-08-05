package com.ladakh.databanking.domain.test.dao;

import com.ladakh.databanking.dao.PermissionDAO;
import com.ladakh.databanking.domain.Permission;
import com.ladakh.databanking.test.BaseSpringTest;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class PermissionDAOTest extends BaseSpringTest {
    @Resource
    private PermissionDAO permissionDAO;
    @Test
    public void permissionTest() {
        Permission permission = new Permission();
        permission.setName("editor");
        permission.setDescription("Allows for the user to edit the contents of the database");
        Permission savedPermission = permissionDAO.save(permission);

        Permission permissionTest = permissionDAO.findByPermissionID(savedPermission.getPermissionID());
        Assertions.assertEquals(permissionTest.getName(), "editor");
        Assertions.assertEquals(permissionTest.getDescription(), "Allows for the user to edit the contents of the database");

        savedPermission.setName("reader");
        savedPermission.setDescription("Allows for the user to view the contents of the database");
        savedPermission = permissionDAO.save(savedPermission);

        permissionTest = permissionDAO.findByPermissionID(savedPermission.getPermissionID());
        Assertions.assertEquals(permissionTest.getName(), "reader");
        Assertions.assertEquals(permissionTest.getDescription(), "Allows for the user to view the contents of the database");

        permissionDAO.delete(savedPermission);
        permissionTest = permissionDAO.findByPermissionID(savedPermission.getPermissionID());
        Assertions.assertNull(permissionTest);
    }
}
