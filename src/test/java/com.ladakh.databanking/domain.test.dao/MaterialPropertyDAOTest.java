package com.ladakh.databanking.domain.test.dao;

import com.ladakh.databanking.dao.MaterialPropertyCategoryDAO;
import com.ladakh.databanking.dao.MaterialPropertyDAO;
import com.ladakh.databanking.dao.UnitDAO;
import com.ladakh.databanking.domain.Material;
import com.ladakh.databanking.domain.MaterialProperty;
import com.ladakh.databanking.domain.MaterialPropertyCategory;
import com.ladakh.databanking.domain.Unit;
import com.ladakh.databanking.test.BaseSpringTest;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class MaterialPropertyDAOTest extends BaseSpringTest {

    @Resource
    private MaterialPropertyDAO materialPropertyDAO;
    @Resource
    private MaterialPropertyCategoryDAO materialPropertyCategoryDAO;
    @Resource
    private UnitDAO unitDAO;

    @Test
    public void testMaterialProperty() {
        MaterialProperty materialProperty = new MaterialProperty();
        materialProperty.setPropertyID(1);
        materialProperty.setPropertyCategory("Magnetic Properties");

        MaterialProperty matProp = materialPropertyDAO.save(materialProperty);
        MaterialProperty matPropTest = materialPropertyDAO.findByPropertyID(matProp.getPropertyID());
        Assertions.assertEquals(matPropTest.getPropertyCategory(), "Magnetic Properties");

        matProp.setPropertyCategory("Equivalent Grades");
        matProp = materialPropertyDAO.save(matProp);
        matPropTest = materialPropertyDAO.findByPropertyID(matProp.getPropertyID());
        Assertions.assertEquals(matPropTest.getPropertyCategory(), "Equivalent Grades");

        materialPropertyDAO.delete(matProp);
        matPropTest = materialPropertyDAO.findByPropertyID(matProp.getPropertyID());
        Assertions.assertNull(matPropTest);
    }

    @Test
    public void testMaterialPropertyCategory() {
        MaterialPropertyCategory materialPropertyCategory = new MaterialPropertyCategory();
        materialPropertyCategory.setCategoryId(1);
        materialPropertyCategory.setName("Chemical Composition");
        MaterialPropertyCategory savedMaterialPropertyCategory = materialPropertyCategoryDAO.save(materialPropertyCategory);

        MaterialPropertyCategory matPropCatTestVal = new MaterialPropertyCategory();
        matPropCatTestVal.setCategoryId(1);
        matPropCatTestVal.setName("Chemical Composition");
        MaterialPropertyCategory matPropCatTestValSaved = materialPropertyCategoryDAO.save(matPropCatTestVal);

        MaterialProperty materialProperty = new MaterialProperty();
        materialProperty.setPropertyID(1);
        materialProperty.setPropertyCategory("Magnetic Properties");
        materialProperty.setMaterialPropertyCategory(savedMaterialPropertyCategory);
        MaterialProperty savedMaterialProperty = materialPropertyDAO.save(materialProperty);
        MaterialProperty matPropTest = materialPropertyDAO.findByPropertyID(savedMaterialProperty.getPropertyID());

        Assertions.assertEquals(matPropTest.getMaterialPropertyCategory(), matPropCatTestValSaved);
    }

    @Test
    public void testMaterialPropertyUnit() {
        Unit materialPropertyUnit = new Unit();
        materialPropertyUnit.setUnitID(1);
        materialPropertyUnit.setUnitName("%");
        Unit savedMaterialPropertyUnit = unitDAO.save(materialPropertyUnit);

        Unit testUnit = new Unit();
        testUnit.setUnitID(1);
        testUnit.setUnitName("%");
        Unit savedTestUnit = unitDAO.save(testUnit);

        MaterialProperty materialProperty = new MaterialProperty();
        materialProperty.setPropertyID(1);
        materialProperty.setPropertyCategory("Magnetic Properties");
        materialProperty.setUnit(savedMaterialPropertyUnit);
        MaterialProperty savedMaterialProperty = materialPropertyDAO.save(materialProperty);
        MaterialProperty matPropTest = materialPropertyDAO.findByPropertyID(savedMaterialProperty.getPropertyID());

        Assertions.assertEquals(matPropTest.getUnit(), savedTestUnit);
    }
}
