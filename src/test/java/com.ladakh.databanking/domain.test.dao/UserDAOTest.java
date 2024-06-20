package com.ladakh.databanking.domain.test.dao;

import com.ladakh.databanking.dao.UserDAO;
import com.ladakh.databanking.domain.User;
import com.ladakh.databanking.test.BaseSpringTest;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserDAOTest extends BaseSpringTest {

    @Resource
    private UserDAO userDAO;

    @Test
    public void testUserFunctions() {
        User user = new User();
        user.setUserID(1);
        user.setUsername("John123");

        User user1 = userDAO.save(user);
        User userTest = userDAO.findByUserID(user1.getUserID());
        Assertions.assertEquals(userTest.getUsername(), "John123");

        user1.setUsername("Sam123");
        user1 =userDAO.save(user1);
        userTest = userDAO.findByUserID(user1.getUserID());
        Assertions.assertEquals(userTest.getUsername(), "Sam123");

        userDAO.delete(user1);
        userTest = userDAO.findByUserID(user1.getUserID());
        Assertions.assertNull(userTest);

    }

}
