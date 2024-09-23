package com.ladakh.databanking.dao;

import com.ladakh.databanking.domain.UnitClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UnitClassDAO extends JpaRepository<UnitClass, Long> {
    @Query("select u from UnitClass u where u.classID =:classID")
    UnitClass findByUnitClassID(@Param("classID")long unitClass);
}
