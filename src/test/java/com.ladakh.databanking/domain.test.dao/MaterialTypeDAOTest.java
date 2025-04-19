package com.ladakh.databanking.domain.test.dao;

import com.ladakh.databanking.controller.MaterialTypeController;
import com.ladakh.databanking.dao.MaterialTypeDAO;
import com.ladakh.databanking.domain.MaterialType;
import com.ladakh.databanking.test.BaseSpringTest;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
public class MaterialTypeDAOTest extends BaseSpringTest {

    @Resource
    private MaterialTypeDAO materialTypeDAO;
    @Resource
    private MaterialTypeController materialTypeController;

    @Test
    public void testMaterialType() {
        MaterialType materialType = new MaterialType();
        materialType.setMaterialTypeID(1);
        materialType.setName("Precision Alloys");

        MaterialType materialType1 = materialTypeDAO.save(materialType);
        MaterialType materialTypeTest = materialTypeDAO.findByMaterialTypeID(materialType1.getMaterialTypeID());
        assertEquals(materialTypeTest.getName(), "Precision Alloys");

        materialType1.setName("Soft Magnetic Alloys");
        materialType1 = materialTypeDAO.save(materialType1);
        materialTypeTest = materialTypeDAO.findByMaterialTypeID(materialType1.getMaterialTypeID());
        assertEquals(materialTypeTest.getName(), "Soft Magnetic Alloys");

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
        assertEquals(materialTypeTest.getParentMaterialType().getName(), "Precision Alloys");

        savedMaterialType.getParentMaterialType().setName("Soft Magnetic Alloys");
        savedMaterialType = materialTypeDAO.save(savedMaterialType);
        materialTypeTest = materialTypeDAO.findByMaterialTypeID(savedMaterialType.getMaterialTypeID());
        assertEquals(materialTypeTest.getParentMaterialType().getName(), "Soft Magnetic Alloys");

        materialTypeDAO.delete(savedMaterialType);
        materialTypeTest = materialTypeDAO.findByMaterialTypeID(savedMaterialType.getMaterialTypeID());
        Assertions.assertNull(materialTypeTest);
    }

    @Test
    @Transactional
    public void testGetMaterialTypeByParentMaterialTypeID() {
        MaterialType parentMaterialType = new MaterialType();
        parentMaterialType.setMaterialTypeID(100);
        parentMaterialType.setName("Precision Alloys");
        parentMaterialType.setParentMaterialType(null);
        MaterialType savedParentMaterialType = materialTypeDAO.save(parentMaterialType);

        MaterialType materialType = new MaterialType();
        materialType.setMaterialTypeID(1);
        materialType.setName("Nickel Alloys");
        materialType.setParentMaterialType(savedParentMaterialType);
        MaterialType savedMaterialType = materialTypeDAO.save(materialType);

        List<MaterialType> foundMaterialTypes = materialTypeDAO.findChildMaterialTypes(savedParentMaterialType.getMaterialTypeID());

        assertNotNull(foundMaterialTypes);
        assertFalse(foundMaterialTypes.isEmpty());
        assertEquals(2, foundMaterialTypes.size());
        assertEquals(savedMaterialType.getMaterialTypeID(), foundMaterialTypes.get(0).getMaterialTypeID());
        assertEquals("Nickel Alloys", foundMaterialTypes.get(0).getName());
        assertEquals(savedParentMaterialType.getMaterialTypeID(), foundMaterialTypes.get(0).getParentMaterialType().getMaterialTypeID());

    }

    @Test
    public void testGetMaterialTypeByParentMaterialTypeID2() {
        HashMap<String, Long> map = new HashMap<>();
        map.put("parent_material_type", 100L);
        List<MaterialType> materialTypes = materialTypeController.getChildMaterialTypes(map);
        assertFalse(materialTypes.isEmpty());
    }

    @Test
    public void testGetAllParentMaterialTypeIds() {
        List<MaterialType> parentMaterialTypes = materialTypeController.getRootMaterialTypes();
        assertFalse(parentMaterialTypes.isEmpty());
    }

}
