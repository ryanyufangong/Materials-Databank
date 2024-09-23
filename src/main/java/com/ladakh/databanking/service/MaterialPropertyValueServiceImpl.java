package com.ladakh.databanking.service;

import com.ladakh.databanking.dao.MaterialPropertyValueDAO;
import com.ladakh.databanking.domain.MaterialPropertyValue;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class MaterialPropertyValueServiceImpl implements MaterialPropertyValueService{
    @Resource
    private MaterialPropertyValueDAO materialPropertyValueDAO;

    public String getPropertyValue(long materialID, long propertyID) {
        MaterialPropertyValue materialPropertyValue = materialPropertyValueDAO.findByMaterialIDAndPropertyID(materialID, propertyID);
        return materialPropertyValue.getValue();
    }
    public String changePropertyValue(long materialID, long propertyID, String newCategoryName) {
        MaterialPropertyValue materialPropertyValue = materialPropertyValueDAO.findByMaterialIDAndPropertyID(materialID, propertyID);
        materialPropertyValue.setValue(newCategoryName);
        materialPropertyValue = materialPropertyValueDAO.save(materialPropertyValue);
        return materialPropertyValue.getValue();
    }

    public String getValueMaterial(long materialID, long propertyID) {
        MaterialPropertyValue materialPropertyValue = materialPropertyValueDAO.findByMaterialIDAndPropertyID(materialID, propertyID);
        return materialPropertyValue.getMaterial().getName();
    }

    public String getValueMaterialProperty(long materialID, long propertyID) {
        MaterialPropertyValue materialPropertyValue = materialPropertyValueDAO.findByMaterialIDAndPropertyID(materialID, propertyID);
        return materialPropertyValue.getMaterialProperty().getPropertyCategory();
    }
}
