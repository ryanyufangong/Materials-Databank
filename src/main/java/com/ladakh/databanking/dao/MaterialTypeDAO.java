package com.ladakh.databanking.dao;

import com.ladakh.databanking.domain.Material;
import com.ladakh.databanking.domain.MaterialType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MaterialTypeDAO extends JpaRepository<MaterialType, Long> {
    @Query("select t from MaterialType t where t.materialTypeID =:materialTypeID")
    MaterialType findByMaterialTypeID(@Param("materialTypeID")long MaterialType);
}

