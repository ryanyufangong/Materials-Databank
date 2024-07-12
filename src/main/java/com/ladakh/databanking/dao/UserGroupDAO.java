package com.ladakh.databanking.dao;

import com.ladakh.databanking.domain.UserGroup;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserGroupDAO {
    @Query("select u from UserGroup u where userID =:userID and groupID =:groupID")
    UserGroup findByUserIDAndGroupID (@Param("userID")long user, @Param("groupID")long group);
}
