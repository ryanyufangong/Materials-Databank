package com.ladakh.databanking.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MultiplierDAO {

    @Query("select m from Multiplier m where multiplierID =: multiplierID")
    MultiplierDAO findByMultiplierID(@Param("multiplierID")long multiplier);
}
