package com.ladakh.databanking.service;

import com.ladakh.databanking.dao.UserDAO;
import com.ladakh.databanking.domain.User;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserDAO userDAO;

    @Override
    public String getUserName(long userID) {
        User user = userDAO.findByUserID(userID);
        return user.getUsername();
    }

    public String changeUserName(long userId, String newUserName) {
        User user = userDAO.findByUserID(userId);
        user.setUsername(newUserName);
        user = userDAO.save(user);
        return user.getUsername();
    }


}
