package com.ladakh.databanking.domain.test.dao;

import com.ladakh.databanking.dao.MaterialTypeDAO;
import com.ladakh.databanking.domain.MaterialType;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class MaterialTypeDAOTest {

    @Resource
    private MaterialTypeDAO materialTypeDAO;

    @Test
    public void testMaterialTypeFunction() {
        MaterialType materialType = new MaterialType();
        materialType.setMaterialTypeID(1);
        materialType.setName("Precision Alloys");

        MaterialType materialType1 = materialTypeDAO.save(materialType);
        MaterialType materialTypeTest = materialTypeDAO.findByMaterialTypeID(materialType1.getMaterialTypeID());
        Assertions.assertEquals(materialTypeTest.getName(), "Precision Alloys");

        materialType1.setName("Soft Magnetic Alloys");
        materialType1 =materialTypeDAO.save(materialType1);
        materialTypeTest = materialTypeDAO.findByMaterialTypeID(materialType1.getMaterialTypeID());
        Assertions.assertEquals(materialTypeTest.getName(), "Soft Magnetic Alloys");

        materialTypeDAO.delete(materialType1);
        materialTypeTest = materialTypeDAO.findByMaterialTypeID(materialType1.getMaterialTypeID());
        Assertions.assertNull(materialTypeTest);
    }
}
