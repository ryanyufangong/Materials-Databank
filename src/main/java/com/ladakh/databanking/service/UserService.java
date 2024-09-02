package com.ladakh.databanking.service;

public interface UserService {
    String getUserName(long userID);
    String changeUserName(long userID, String newUserName);
    String getPassword(long userID);
    String changePassword(long userID, String newPassword);
    String createNewUser(String password, String username);
    Boolean checkUserExists(String username);
    Boolean checkUserAndPwd(String username, String password);


}
