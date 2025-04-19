package com.ladakh.databanking.dao;

import com.ladakh.databanking.domain.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MaterialDAO extends JpaRepository<Material, Long>{

    @Query("select m from Material m where m.materialID =:materialID")
    Material findByMaterialID(@Param("materialID")long Material);

    @Query("select mt from Material mt where mt.materialType.materialTypeID =:materialTypeID")
    List<Material> findMaterialsByTypeID(@Param("materialTypeID")long MaterialType);



}
