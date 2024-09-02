package com.ladakh.databanking.controller;

import com.ladakh.databanking.service.PermissionService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class PermissionController {
    @Resource
    private PermissionService permissionService;

    @RequestMapping(value = "permission/getPermissionName", method = RequestMethod.GET)
    @ResponseBody
    public String getPermissionName(@RequestParam("permissionID")long permissionID){
        return permissionService.getPermissionName(permissionID);
    }

    @RequestMapping(value = "permission/changePermissionName", method = RequestMethod.GET)
    @ResponseBody
    public String changePermissionName(@RequestParam("permissionID")long permissionID, @RequestParam("newPermissionName")String newPermissionName){
        return permissionService.changePermissionName(permissionID, newPermissionName);
    }

    @RequestMapping(value = "permission/getPermissionDescription", method = RequestMethod.GET)
    @ResponseBody
    public String getPermissionDescription(@RequestParam("permissionID")long permissionID){
        return permissionService.getPermissionDescription(permissionID);
    }

    @RequestMapping(value = "permission/changePermissionDescription", method = RequestMethod.GET)
    @ResponseBody
    public String changePermissionDescription(@RequestParam("permissionID")long permissionID, @RequestParam("newPermissionDescription")String newPermissionDescription){
        return permissionService.changePermissionDescription(permissionID, newPermissionDescription);
    }

}
