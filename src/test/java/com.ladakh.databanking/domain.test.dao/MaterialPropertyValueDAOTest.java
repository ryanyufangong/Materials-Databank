package com.ladakh.databanking.domain.test.dao;

import com.ladakh.databanking.dao.MaterialPropertyValueDAO;
import com.ladakh.databanking.domain.Material;
import com.ladakh.databanking.domain.MaterialPropertyValue;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class MaterialPropertyValueDAOTest {

    @Resource
    private MaterialPropertyValueDAO matPropValDAO;

    @Test
    public void testMatPropValFunctions() {
        MaterialPropertyValue matPropVal = new MaterialPropertyValue();
        matPropVal.setValue("200");

        MaterialPropertyValue matPropVal1 = matPropValDAO.save(matPropVal);
        MaterialPropertyValue matPropValTest = matPropValDAO.findByMaterialIDAndPropertyID(matPropVal1.getValue());
        Assertions.assertEquals(materialTest.getName(), "Aluminum");

        matPropVal1.setName("Iron");
        matPropVal1 = materialDAO.save(matPropVal1);
        materialTest = materialDAO.findByMaterialID(matPropVal1.getMaterialID());
        Assertions.assertEquals(materialTest.getName(), "Iron");

        materialDAO.delete(material1);
        materialTest = materialDAO.findByMaterialID(matPropVal1.getMaterialID());
        Assertions.assertNull(materialTest);
    }

}
