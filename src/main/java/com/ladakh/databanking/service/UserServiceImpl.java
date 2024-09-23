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

    public String getPassword(long userID) {
        User user = new User();
        return user.getPassword();
    }

    public String changePassword(long userID, String newPassword) {
        User user = new User();
        user.setPassword(newPassword);
        user = userDAO.save(user);
        return user.getPassword();
    }

    public String createNewUser(String password, String username) {
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        user = userDAO.save(user);
        return "success";
    }

    public Boolean checkUserExists(String username) {
        User user = userDAO.findByUsername(username);
        return user != null;
    }

    public Boolean checkUserAndPwd(String username, String password) {
        User user = userDAO.findByUsername(username);
        return user != null && user.getPassword() != null && user.getPassword().equals(password);
    }

}
