package com.ladakh.databanking.service;

import com.ladakh.databanking.dao.MaterialPropertyDAO;
import com.ladakh.databanking.domain.MaterialProperty;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class MaterialPropertyServiceImpl implements MaterialPropertyService {
    @Resource
    private MaterialPropertyDAO materialPropertyDAO;

    @Override
    public String getMaterialProperty(long propertyID) {
        MaterialProperty materialProperty = materialPropertyDAO.findByPropertyID(propertyID);
        return materialProperty.getPropertyCategory();
    }

    public String changeMaterialProperty(long propertyID, String newProperty) {
        MaterialProperty materialProperty = materialPropertyDAO.findByPropertyID(propertyID);
        materialProperty.setPropertyCategory(newProperty);
        materialProperty = materialPropertyDAO.save(materialProperty);
        return materialProperty.getPropertyCategory();
    }

    public String getMaterialPropertyCategory(long propertyID) {
        MaterialProperty materialProperty = materialPropertyDAO.findByPropertyID(propertyID);
        return materialProperty.getMaterialPropertyCategory().getName();
    }

    public String getMaterialPropertyUnit(long propertyID) {
        MaterialProperty materialProperty = materialPropertyDAO.findByPropertyID(propertyID);
        return materialProperty.getUnit().getUnitName();
    }
}
