package com.ladakh.databanking.dao;

import com.ladakh.databanking.domain.UserPermission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserPermissionDAO {
    @Query("select u from UserPermission u where userID =:userID and permissionID =:permissionID")
    UserPermission findByUserIDAndPermissionID (@Param("userID")long user, @Param("permissionID")long permission);
}
