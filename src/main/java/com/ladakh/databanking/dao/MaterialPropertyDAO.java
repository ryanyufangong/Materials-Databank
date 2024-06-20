package com.ladakh.databanking.dao;

import com.ladakh.databanking.domain.Material;
import com.ladakh.databanking.domain.MaterialProperty;
import com.ladakh.databanking.domain.MaterialType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mapping.model.Property;
import org.springframework.data.repository.query.Param;

public interface MaterialPropertyDAO extends JpaRepository<MaterialProperty, Long> {
    @Query("select p from MaterialProperty p where propertyId =:propertyId")
    MaterialProperty findByPropertyID(@Param("propertyId")long MaterialProperty);
}
