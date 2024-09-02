package com.ladakh.databanking.service;

public interface GroupService {
    String getGroupName(long groupID);

    String changeGroupName(long groupID, String newGroupName);
}
