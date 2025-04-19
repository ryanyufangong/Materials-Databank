package com.ladakh.databanking.service;

import com.ladakh.databanking.dao.MaterialDAO;
import com.ladakh.databanking.domain.Material;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService{
    @Resource
    private MaterialDAO materialDAO;

    public String getMaterialName(long materialID) {
        Material material = materialDAO.findByMaterialID(materialID);
        return material.getName();
    }

    public String changeMaterialName(long materialID, String newMaterialName) {
        Material material = materialDAO.findByMaterialID(materialID);
        material.setName(newMaterialName);
        material = materialDAO.save(material);
        return material.getName();
    }

    @Override
    public String getMaterialTypeName(long materialID) {
        Material material = materialDAO.findByMaterialID(materialID);
        return material.getMaterialType().getName();
    }

    public String getMaterialTypeParentName(long materialID) {
        Material material = materialDAO.findByMaterialID(materialID);
        return material.getMaterialType().getParentMaterialType().getName();
    }

    public List<Material> getMaterialsFromMaterialTypeID(long materialTypeID) {
        return materialDAO.findMaterialsByTypeID(materialTypeID);
    }
}
