package com.ladakh.databanking.service;

import com.ladakh.databanking.domain.Material;
import com.ladakh.databanking.domain.MaterialType;

import java.util.List;

public interface MaterialService {
    String getMaterialName(long materialID);
    String changeMaterialName(long materialID, String newMaterialName);
    String getMaterialTypeName(long materialID);
    String getMaterialTypeParentName(long materialID);
    List<Material> getMaterialsFromMaterialTypeID(long materialTypeID);
}
