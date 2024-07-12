package com.ladakh.databanking.dao;

import com.ladakh.databanking.domain.MaterialPropertyValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MaterialPropertyValueDAO extends JpaRepository<MaterialPropertyValue, Long> {
    @Query("select m from MaterialPropertyValue m where propertyID =:propertyID and materialID =:materialID")
    MaterialPropertyValue findByMaterialIDAndPropertyID (@Param("materialID")long material, @Param("propertyID")long property);
}
