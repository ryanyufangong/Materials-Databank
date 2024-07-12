package com.ladakh.databanking.dao;

import com.ladakh.databanking.domain.UnitClass;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UnitClassDAO {
    @Query("select u from UnitClass u where classID =:classID")
    UnitClass findByUnitClassID(@Param("classID")long unitClass);
}
