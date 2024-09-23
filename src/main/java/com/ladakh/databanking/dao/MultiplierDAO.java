package com.ladakh.databanking.dao;

import com.ladakh.databanking.domain.Multiplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MultiplierDAO extends JpaRepository<Multiplier, Long> {
    @Query("select m from Multiplier m where m.multiplierID =:multiplierID")
    Multiplier findByMultiplierID(@Param("multiplierID")long multiplier);
}
