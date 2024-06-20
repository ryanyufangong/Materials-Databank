package com.ladakh.databanking.dao;

import com.ladakh.databanking.domain.Material;
import com.ladakh.databanking.domain.MaterialPropertyCategory;
import com.ladakh.databanking.domain.MaterialType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MaterialPropertyCategoryDAO extends JpaRepository<MaterialPropertyCategory, Long> {
    @Query("select c from MaterialPropertyCategory c where categoryId =:categoryId")
    MaterialPropertyCategory findBycategoryId(@Param("categoryId")long MaterialPropertyCategory);
}
