package com.ladakh.databanking.controller;

import com.ladakh.databanking.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "user/getUserName", method = RequestMethod.GET)
    @ResponseBody
    public String getUserName(@RequestParam("userID")long userID) {
        return userService.getUserName(userID);
    }

    @RequestMapping(value = "user/changeUserName", method = RequestMethod.GET)
    @ResponseBody
    public String changeUserName(@RequestParam("userID")long userID, @RequestParam("username")String username) {
        return userService.changeUserName(userID, username);
    }

    @RequestMapping(value = "user/getPassword", method = RequestMethod.GET)
    @ResponseBody
    public String getPassword(@RequestParam("userId")long userID) {
        return userService.getPassword(userID);
    }

    @RequestMapping(value = "user/changePassword", method = RequestMethod.GET)
    @ResponseBody
    public String changePassword(@RequestParam("userId")long userId, @RequestParam("password")String password) {
        return userService.changePassword(userId, password);
    }

    @CrossOrigin
    @RequestMapping(value = "user/createNewUser", method = RequestMethod.POST)
    @ResponseBody
    public String createNewUser(@RequestBody Map<String, String> requestParams) {
        return userService.createNewUser(requestParams.get("password"), requestParams.get("username"));
    }

    @CrossOrigin
    @RequestMapping(value = "user/checkUserExists", method = RequestMethod.POST)
    @ResponseBody
    public Boolean checkUserExists(@RequestBody Map<String, String> requestParams) {
        return userService.checkUserExists(requestParams.get("username"));
    }

    @CrossOrigin
    @RequestMapping(value = "user/checkUserAndPwd", method = RequestMethod.POST)
    @ResponseBody
    public Boolean checkUserAndPwd(@RequestBody Map<String, String> requestParams) {
        return userService.checkUserAndPwd(requestParams.get("username"), requestParams.get("password"));
    }
}
