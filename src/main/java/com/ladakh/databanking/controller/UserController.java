package com.ladakh.databanking.controller;

import com.ladakh.databanking.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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
}
