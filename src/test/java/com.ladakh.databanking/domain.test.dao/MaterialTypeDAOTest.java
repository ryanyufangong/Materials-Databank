package com.ladakh.databanking.domain.test.dao;

import com.ladakh.databanking.dao.MaterialTypeDAO;
import com.ladakh.databanking.domain.MaterialType;
import com.ladakh.databanking.test.BaseSpringTest;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class MaterialTypeDAOTest extends BaseSpringTest {

    @Resource
    private MaterialTypeDAO materialTypeDAO;

    @Test
    public void testMaterialType() {
        MaterialType materialType = new MaterialType();
        materialType.setMaterialTypeID(1);
        materialType.setName("Precision Alloys");

        MaterialType materialType1 = materialTypeDAO.save(materialType);
        MaterialType materialTypeTest = materialTypeDAO.findByMaterialTypeID(materialType1.getMaterialTypeID());
        Assertions.assertEquals(materialTypeTest.getName(), "Precision Alloys");

        materialType1.setName("Soft Magnetic Alloys");
        materialType1 = materialTypeDAO.save(materialType1);
        materialTypeTest = materialTypeDAO.findByMaterialTypeID(materialType1.getMaterialTypeID());
        Assertions.assertEquals(materialTypeTest.getName(), "Soft Magnetic Alloys");

        materialTypeDAO.delete(materialType1);
        materialTypeTest = materialTypeDAO.findByMaterialTypeID(materialType1.getMaterialTypeID());
        Assertions.assertNull(materialTypeTest);
    }

    @Test
    public void testMaterialTypeParent() {
        MaterialType parentMaterialType = new MaterialType();
        parentMaterialType.setMaterialTypeID(1);
        parentMaterialType.setName("Precision Alloys");
        parentMaterialType.setParentMaterialType(null);
        MaterialType savedParentMaterialType = materialTypeDAO.save(parentMaterialType);

        MaterialType materialType = new MaterialType();
        materialType.setMaterialTypeID(2);
        materialType.setName("Soft Magnetic Alloys");
        materialType.setParentMaterialType(savedParentMaterialType);
        MaterialType savedMaterialType = materialTypeDAO.save(materialType);

        MaterialType materialTypeTest = materialTypeDAO.findByMaterialTypeID(savedMaterialType.getMaterialTypeID());
        Assertions.assertEquals(materialTypeTest.getParentMaterialType().getName(), "Precision Alloys");

        savedMaterialType.getParentMaterialType().setName("Soft Magnetic Alloys");
        savedMaterialType = materialTypeDAO.save(savedMaterialType);
        materialTypeTest = materialTypeDAO.findByMaterialTypeID(savedMaterialType.getMaterialTypeID());
        Assertions.assertEquals(materialTypeTest.getParentMaterialType().getName(), "Soft Magnetic Alloys");

        materialTypeDAO.delete(savedMaterialType);
        materialTypeTest = materialTypeDAO.findByMaterialTypeID(savedMaterialType.getMaterialTypeID());
        Assertions.assertNull(materialTypeTest);
    }
}
