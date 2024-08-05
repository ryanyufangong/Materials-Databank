package com.ladakh.databanking.domain.test.dao;

import com.ladakh.databanking.dao.MaterialDAO;
import com.ladakh.databanking.dao.MaterialPropertyDAO;
import com.ladakh.databanking.dao.MaterialPropertyValueDAO;
import com.ladakh.databanking.dao.MaterialTypeDAO;
import com.ladakh.databanking.domain.Material;
import com.ladakh.databanking.domain.MaterialProperty;
import com.ladakh.databanking.domain.MaterialPropertyValue;
import com.ladakh.databanking.domain.MaterialType;
import com.ladakh.databanking.test.BaseSpringTest;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class MaterialPropertyValueDAOTest extends BaseSpringTest {

    @Resource
    private MaterialPropertyValueDAO matPropValDAO;
    @Resource
    private MaterialDAO materialDAO;
    @Resource
    private MaterialPropertyDAO materialPropertyDAO;
    @Resource
    private MaterialTypeDAO materialTypeDAO;

    @Test
    @Transactional
    public void testMatPropVal() {
        MaterialType materialType = new MaterialType();
        materialType.setMaterialTypeID(1);
        materialType.setName("Cast Superalloy");
        MaterialType savedMaterialType = materialTypeDAO.save(materialType);

        Material material = new Material();
        material.setMaterialID(1);
        material.setName("K213");
        material.setMaterialType(savedMaterialType);
        Material savedMaterial = materialDAO.save(material);

        MaterialProperty materialProperty = new MaterialProperty();
        materialProperty.setPropertyID(1);
        materialProperty.setPropertyCategory("Si Silicon");
        MaterialProperty savedMaterialProperty = materialPropertyDAO.save(materialProperty);

        MaterialPropertyValue matPropVal = new MaterialPropertyValue();
        matPropVal.setValueID(1);
        matPropVal.setValue("200");
        matPropVal.setMaterial(savedMaterial);
        matPropVal.setMaterialProperty(savedMaterialProperty);
        MaterialPropertyValue savedMatPropVal = matPropValDAO.save(matPropVal);
        MaterialPropertyValue matPropValTest = matPropValDAO.findByMaterialIDAndPropertyID(savedMatPropVal.getMaterial().getMaterialID(), savedMatPropVal.getMaterialProperty().getPropertyID());

        Assertions.assertEquals(matPropValTest.getValue(), "200");
    }

    @Test
    public void testMatPropValMaterial() {
        MaterialType materialType = new MaterialType();
        materialType.setMaterialTypeID(1);
        materialType.setName("Cast Superalloy");
        MaterialType savedMaterialType = materialTypeDAO.save(materialType);

        Material material = new Material();
        material.setMaterialID(1);
        material.setName("K213");
        material.setMaterialType(savedMaterialType);
        Material savedMaterial = materialDAO.save(material);

        MaterialProperty materialProperty = new MaterialProperty();
        materialProperty.setPropertyID(1);
        materialProperty.setPropertyCategory("Si Silicon");
        MaterialProperty savedMaterialProperty = materialPropertyDAO.save(materialProperty);

        MaterialPropertyValue matPropVal = new MaterialPropertyValue();
        matPropVal.setValueID(1);
        matPropVal.setValue("200");
        matPropVal.setMaterial(savedMaterial);
        matPropVal.setMaterialProperty(savedMaterialProperty);
        MaterialPropertyValue savedMatPropVal = matPropValDAO.save(matPropVal);
        MaterialPropertyValue matPropValTest = matPropValDAO.findByMaterialIDAndPropertyID(savedMatPropVal.getMaterial().getMaterialID(), savedMatPropVal.getMaterialProperty().getPropertyID());

        Assertions.assertEquals(matPropValTest.getMaterial(), savedMaterial);
        Assertions.assertEquals(matPropValTest.getMaterial().getName(), "K213");
        Assertions.assertEquals(matPropValTest.getMaterial().getMaterialType().getName(), "Cast Superalloy");
    }

    @Test
    public void testMatPropValMaterialProperty() {
        MaterialType materialType = new MaterialType();
        materialType.setMaterialTypeID(1);
        materialType.setName("Cast Superalloy");
        MaterialType savedMaterialType = materialTypeDAO.save(materialType);

        Material material = new Material();
        material.setMaterialID(1);
        material.setName("K213");
        material.setMaterialType(savedMaterialType);
        Material savedMaterial = materialDAO.save(material);

        MaterialProperty materialProperty = new MaterialProperty();
        materialProperty.setPropertyID(1);
        materialProperty.setPropertyCategory("Si Silicon");
        MaterialProperty savedMaterialProperty = materialPropertyDAO.save(materialProperty);

        MaterialPropertyValue matPropVal = new MaterialPropertyValue();
        matPropVal.setValueID(1);
        matPropVal.setValue("200");
        matPropVal.setMaterial(savedMaterial);
        matPropVal.setMaterialProperty(savedMaterialProperty);
        MaterialPropertyValue savedMatPropVal = matPropValDAO.save(matPropVal);
        MaterialPropertyValue matPropValTest = matPropValDAO.findByMaterialIDAndPropertyID(savedMatPropVal.getMaterial().getMaterialID(), savedMatPropVal.getMaterialProperty().getPropertyID());

        Assertions.assertEquals(matPropValTest.getMaterialProperty(), savedMaterialProperty);
        Assertions.assertEquals(matPropValTest.getMaterialProperty().getPropertyCategory(), "Si Silicon");
    }
}
