package com.ladakh.databanking.domain.test.dao;

import com.ladakh.databanking.dao.GroupDAO;
import com.ladakh.databanking.dao.PermissionDAO;
import com.ladakh.databanking.dao.UserDAO;
import com.ladakh.databanking.domain.Group;
import com.ladakh.databanking.domain.Permission;
import com.ladakh.databanking.domain.User;
import com.ladakh.databanking.test.BaseSpringTest;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Transactional
public class UserDAOTest extends BaseSpringTest {

    @Resource
    private UserDAO userDAO;
    @Resource
    private PermissionDAO permissionDAO;
    @Resource
    private GroupDAO groupDAO;

    @Test
    @Transactional
    public void testUser() {
        User user = new User();
        user.setUserID(1);
        user.setUsername("John123");

        User savedUser = userDAO.save(user);
        User userTest = userDAO.findByUserID(savedUser.getUserID());
        Assertions.assertEquals(userTest.getUsername(), "John123");

        userDAO.delete(savedUser);
        userTest = userDAO.findByUserID(savedUser.getUserID());
        Assertions.assertNull(userTest);
    }

    @Test
    @Transactional
    public void testUserPermission() {
        Permission permission = new Permission();
        permission.setPermissionID(1);
        permission.setName("Reader");
        permission.setDescription("User can only view content");
        permission = permissionDAO.save(permission);
        Set<Permission> permissionSet = new HashSet<>();
        permissionSet.add(permission);

        User user = new User();
        user.setUserID(1);
        user.setUsername("John123");
        user.setPermissions(permissionSet);
        User savedUser = userDAO.save(user);
        User userTest = userDAO.findByUserID(savedUser.getUserID());

        for(Permission p : userTest.getPermissions()) {
            Assertions.assertEquals(p.getPermissionID(), 1);
            Assertions.assertEquals(p.getName(), "Reader");
            Assertions.assertEquals(p.getDescription(), "User can only view content");
        }
        Assertions.assertEquals(userTest.getPermissions().size(), 1);
    }

    @Test
    public void testUserGroups() {
        Group group = new Group();
        group.setGroupID(1);
        group.setGroupName("Company A");
        group = groupDAO.save(group);
        Set<Group> groupSet = new HashSet<>();
        groupSet.add(group);

        User user = new User();
        user.setUserID(1);
        user.setUsername("john123");
        user.setGroups(groupSet);
        User savedUser = userDAO.save(user);
        User userTest = userDAO.findByUserID(savedUser.getUserID());

        for(Group g : userTest.getGroups()) {
            Assertions.assertEquals(g.getGroupID(), 1);
            Assertions.assertEquals(g.getGroupName(), "Company A");
        }
        Assertions.assertEquals(userTest.getGroups().size(), 1);
    }
}
