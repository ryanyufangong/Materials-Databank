package com.ladakh.databanking.controller;

import com.ladakh.databanking.service.GroupService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class GroupController {

    @Resource
    private GroupService groupService;

    @RequestMapping(value = "group/getGroupName", method = RequestMethod.GET)
    @ResponseBody
    public String getGroupName(@RequestParam("groupID")long groupID) {
        return groupService.getGroupName(groupID);
    }

    @RequestMapping(value = "group/changeGroupName", method = RequestMethod.GET)
    @ResponseBody
    public String changeGroupName(@RequestParam("groupID")long groupID, @RequestParam("groupName")String groupName) {
        return groupService.changeGroupName(groupID, groupName);
    }
}
