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
        MaterialPropertyValue matPropValTest = matPropValDAO.findByMaterialIDAndPropertyID(matPropVal1.getMaterial().getMaterialID(), matPropVal1.getMaterialProperty().getPropertyId());
        Assertions.assertEquals(matPropValTest.getValue(), "Aluminum");

        matPropVal1.setValue("Iron");
        matPropVal1 = matPropValDAO.save(matPropVal1);
        matPropValTest = matPropValDAO.findByMaterialIDAndPropertyID(matPropVal1.getMaterial().getMaterialID(), matPropVal1.getMaterialProperty().getPropertyId());
        Assertions.assertEquals(matPropValTest.getValue(), "Iron");

        matPropValDAO.delete(matPropVal1);
        matPropValTest = matPropValDAO.findByMaterialIDAndPropertyID(matPropVal1.getMaterial().getMaterialID(), matPropVal1.getMaterialProperty().getPropertyId());
        Assertions.assertNull(matPropValTest);
    }

}
