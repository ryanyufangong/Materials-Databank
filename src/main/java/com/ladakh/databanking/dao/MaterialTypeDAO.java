package com.ladakh.databanking.dao;

import com.ladakh.databanking.domain.Material;
import com.ladakh.databanking.domain.MaterialType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MaterialTypeDAO extends JpaRepository<MaterialType, Long> {
    @Query("select t from MaterialType t where t.materialTypeID =:materialTypeID")
    MaterialType findByMaterialTypeID(@Param("materialTypeID")long MaterialType);

    @Query("select mt from MaterialType mt where mt.parentMaterialType is not null and mt.parentMaterialType.materialTypeID =:parentMaterialTypeID")
    List<MaterialType> findChildMaterialTypes(@Param("parentMaterialTypeID") long parentMaterialType);

    @Query("select m from MaterialType m where m.parentMaterialType.materialTypeID is null")
    List<MaterialType> findRootMaterialTypes();

}

