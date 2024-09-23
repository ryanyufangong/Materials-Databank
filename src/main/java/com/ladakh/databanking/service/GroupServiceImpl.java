package com.ladakh.databanking.service;

import com.ladakh.databanking.dao.GroupDAO;
import com.ladakh.databanking.domain.Group;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService{
    @Resource
    private GroupDAO groupDAO;

    @Override
    public String getGroupName(long groupID) {
        Group group = groupDAO.findByGroupID(groupID);
        return group.getGroupName();
    }

    public String changeGroupName(long groupID, String newGroupName) {
        Group group = groupDAO.findByGroupID(groupID);
        group.setGroupName(newGroupName);
        group = groupDAO.save(group);
        return group.getGroupName();
    }

}
