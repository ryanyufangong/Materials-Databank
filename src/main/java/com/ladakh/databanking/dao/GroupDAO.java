package com.ladakh.databanking.dao;

import com.ladakh.databanking.domain.Group;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GroupDAO {
    @Query("select g from Group g where groupID =:groupID")
    Group findByGroupID(@Param("groupID")long group);
}
