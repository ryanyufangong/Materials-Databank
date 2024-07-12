package com.ladakh.databanking.domain.test.dao;

import com.ladakh.databanking.dao.MaterialDAO;
import com.ladakh.databanking.domain.Material;
import com.ladakh.databanking.domain.User;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class MaterialDAOTest {

    @Resource
    private MaterialDAO materialDAO;

    @Test
    public void testMaterialFunctions() {
        Material material = new Material();
        material.setMaterialID(1);
        material.setName("Aluminum");
        material.setMaterialID(1);

        Material material1 = materialDAO.save(material);
        Material materialTest = materialDAO.findByMaterialID(material1.getMaterialID());
        Assertions.assertEquals(materialTest.getName(), "Aluminum");

        material1.setName("Iron");
        material1 = materialDAO.save(material1);
        materialTest = materialDAO.findByMaterialID(material1.getMaterialID());
        Assertions.assertEquals(materialTest.getName(), "Iron");

        materialDAO.delete(material1);
        materialTest = materialDAO.findByMaterialID(material1.getMaterialID());
        Assertions.assertNull(materialTest);
    }

}
