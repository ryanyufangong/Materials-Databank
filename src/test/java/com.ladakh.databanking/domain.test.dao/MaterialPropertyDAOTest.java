package com.ladakh.databanking.domain.test.dao;

import com.ladakh.databanking.dao.MaterialPropertyDAO;
import com.ladakh.databanking.domain.Material;
import com.ladakh.databanking.domain.MaterialProperty;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class MaterialPropertyDAOTest {

    @Resource
    private MaterialPropertyDAO materialPropertyDAO;

    @Test
    public void testMaterialPropertyFunctions() {
        MaterialProperty materialProperty = new MaterialProperty();
        materialProperty.setPropertyId(1);
        materialProperty.setPropertyCategory("Magnetic Properties");

        MaterialProperty matProp = materialPropertyDAO.save(materialProperty);
        MaterialProperty matPropTest = materialPropertyDAO.findByPropertyID(matProp.getPropertyId());
        Assertions.assertEquals(matPropTest.getPropertyCategory(), "Magnetic Properties");

        matProp.setPropertyCategory("Equivalent Grades");
        matProp = materialPropertyDAO.save(matProp);
        matPropTest = materialPropertyDAO.findByPropertyID(matProp.getPropertyId());
        Assertions.assertEquals(matPropTest.getPropertyCategory(), "Equivalent Grades");

        materialPropertyDAO.delete(matProp);
        matPropTest = materialPropertyDAO.findByPropertyID(matProp.getPropertyId());
        Assertions.assertNull(matPropTest);
    }
}
