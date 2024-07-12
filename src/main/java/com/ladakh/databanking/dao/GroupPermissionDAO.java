package com.ladakh.databanking.dao;

import com.ladakh.databanking.domain.GroupPermission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GroupPermissionDAO {
    @Query("select g from GroupPermission g where groupID =:groupID and permissionID =:permissionID")
    GroupPermission findByGroupIDAndPermissionID (@Param("groupID")long groupID, @Param("permissionID")long permissionID);
}
