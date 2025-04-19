package com.ladakh.databanking.domain.test.dao;

import com.ladakh.databanking.dao.MaterialDAO;
import com.ladakh.databanking.dao.MaterialTypeDAO;
import com.ladakh.databanking.domain.Material;
import com.ladakh.databanking.domain.MaterialType;
import com.ladakh.databanking.test.BaseSpringTest;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class MaterialDAOTest extends BaseSpringTest {

    @Resource
    private MaterialDAO materialDAO;

    @Resource
    private MaterialTypeDAO materialTypeDAO;

    @Test
    @Transactional
    public void testMaterialFunctions() {
        MaterialType materialType = new MaterialType();
        materialType.setName("Corrosion Resistant Alloys");
        MaterialType savedMaterialType = materialTypeDAO.save(materialType);

        Material material = new Material();
        material.setMaterialID(1);
        material.setName("Alloy 20");
        material.setMaterialType(savedMaterialType);

        Material savedMaterial = materialDAO.save(material);
        Material materialTest = materialDAO.findByMaterialID(savedMaterial.getMaterialID());
        Assertions.assertEquals(materialTest.getName(), "Alloy 20");
        Assertions.assertEquals(materialTest.getMaterialType().getName(), "Corrosion Resistant Alloys");

        materialDAO.delete(savedMaterial);
        materialTest = materialDAO.findByMaterialID(savedMaterial.getMaterialID());
        Assertions.assertNull(materialTest);
    }

    @Test
    public void testMaterialType() {
        MaterialType materialType = new MaterialType();
        materialType.setName("Cast Superalloy");
        MaterialType savedMaterialType = materialTypeDAO.save(materialType);

        Material material = new Material();
        material.setMaterialID(1);
        material.setName("K213");
        material.setMaterialType(savedMaterialType);

        Material savedMaterial = materialDAO.save(material);
        Material materialTest = materialDAO.findByMaterialID(savedMaterial.getMaterialID());
        Assertions.assertEquals(materialTest.getName(), "K213");
        Assertions.assertEquals(materialTest.getMaterialType().getName(), "Cast Superalloy");

        materialDAO.delete(savedMaterial);
        materialTest = materialDAO.findByMaterialID(savedMaterial.getMaterialID());
        Assertions.assertNull(materialTest);
    }

    @Test
    @Transactional
    public void testGetMaterialsFromTypeID() {
        MaterialType materialType = new MaterialType();
        materialType.setName("Corrosion Resistant Alloys");
        MaterialType savedMaterialType = materialTypeDAO.save(materialType);

        Material material1 = new Material();
        material1.setMaterialID(1);
        material1.setName("Alloy 20");
        material1.setMaterialType(savedMaterialType);

        Material material2 = new Material();
        material2.setMaterialID(2);
        material2.setName("Alloy 30");
        material2.setMaterialType(savedMaterialType);

        Material savedMaterial1 = materialDAO.save(material1);
        Material savedMaterial2 = materialDAO.save(material2);

        List<Material> materialTest = materialDAO.findMaterialsByTypeID(savedMaterialType.getMaterialTypeID());
        Assertions.assertEquals(materialTest.size(), 2);


    }



}
