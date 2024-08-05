package com.ladakh.databanking.domain.test.dao;

import com.ladakh.databanking.dao.GroupDAO;
import com.ladakh.databanking.dao.PermissionDAO;
import com.ladakh.databanking.dao.UserDAO;
import com.ladakh.databanking.domain.Group;
import com.ladakh.databanking.domain.User;
import com.ladakh.databanking.test.BaseSpringTest;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Transactional
public class GroupDAOTest extends BaseSpringTest {

    @Resource
    private GroupDAO groupDAO;
    @Resource
    private UserDAO userDAO;
    @Resource
    private PermissionDAO permissionDAO;


    @Test
    public void groupTest() {
        Group group = new Group();
        group.setGroupName("Company A");
        Group savedGroup = groupDAO.save(group);

        Group groupTest = groupDAO.findByGroupID(savedGroup.getGroupID());
        Assertions.assertEquals(groupTest.getGroupName(), "Company A");

        savedGroup.setGroupName("Company B");
        savedGroup = groupDAO.save(savedGroup);

        groupTest = groupDAO.findByGroupID(savedGroup.getGroupID());
        Assertions.assertEquals(groupTest.getGroupName(), "Company B");

        groupDAO.delete(savedGroup);
        groupTest = groupDAO.findByGroupID(savedGroup.getGroupID());
        Assertions.assertNull(groupTest);
    }

    @Test
    public void groupTestUsers() {
        User user = new User();
        user.setUserID(1);
        user.setUsername("User");
        User savedUser = userDAO.save(user);
        Set<User> userSet = new HashSet<>();
        userSet.add(savedUser);

        Group group = new Group();
        group.setGroupName("Company A");
        group.setUsers(userSet);
        Group savedGroup = groupDAO.save(group);

        Group groupTest = groupDAO.findByGroupID(savedGroup.getGroupID());

        for(User u : groupTest.getUsers()) {
            Assertions.assertEquals(u.getUserID(), 1);
            Assertions.assertEquals(u.getUsername(), "User");
        }
        Assertions.assertEquals(groupTest.getUsers().size(), 1);
    }
}
