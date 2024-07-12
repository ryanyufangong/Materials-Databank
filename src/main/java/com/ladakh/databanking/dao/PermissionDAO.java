package com.ladakh.databanking.dao;

import com.ladakh.databanking.domain.Permission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PermissionDAO {
    @Query("select p from Permission p where permissionID =:permissionID")
    Permission findByPermissionID (@Param("permissionID")long permission);
}
