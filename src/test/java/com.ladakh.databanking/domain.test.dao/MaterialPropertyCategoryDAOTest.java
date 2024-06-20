package com.ladakh.databanking.domain.test.dao;

import com.ladakh.databanking.dao.MaterialPropertyCategoryDAO;
import com.ladakh.databanking.domain.MaterialPropertyCategory;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class MaterialPropertyCategoryDAOTest {

    @Resource
    private MaterialPropertyCategoryDAO matPropCatDAO;

    @Test
    public void testMatPropCatDAOFunctions() {
        MaterialPropertyCategory matPropCat = new MaterialPropertyCategory();
        matPropCat.setCategoryId(1);
        matPropCat.setName("GB");

        MaterialPropertyCategory matPropCat1 = matPropCatDAO.save(matPropCat);
        MaterialPropertyCategory matPropCatTest = matPropCatDAO.findBycategoryId(matPropCat1.getCategoryId());
        Assertions.assertEquals(matPropCatTest.getName(), "GB");

        matPropCat1.setName("Alloy");
        matPropCat1 = matPropCatDAO.save(matPropCat1);
        matPropCatTest = matPropCatDAO.findBycategoryId(matPropCat1.getCategoryId());
        Assertions.assertEquals(matPropCatTest.getName(), "Alloy");

        matPropCatDAO.delete(matPropCat1);
        matPropCatTest = matPropCatDAO.findBycategoryId(matPropCat1.getCategoryId());
        Assertions.assertNull(matPropCatTest);
    }

}
