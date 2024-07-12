package com.ladakh.databanking.service;

public interface UserService {
    String getUserName(long userID);
    String changeUserName(long userID, String newUserName);

}
