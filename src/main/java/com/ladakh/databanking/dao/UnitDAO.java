package com.ladakh.databanking.dao;

import com.ladakh.databanking.domain.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UnitDAO extends JpaRepository<Unit, Long> {
    @Query("select u from Unit u where u.unitID =:unitID")
    Unit findByUnitID(@Param("unitID")long unit);
}
