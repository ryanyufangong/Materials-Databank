package com.ladakh.databanking.service;

import com.ladakh.databanking.dao.MaterialTypeDAO;
import com.ladakh.databanking.domain.MaterialType;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialTypeServiceImpl implements MaterialTypeService{

    @Resource
    private MaterialTypeDAO materialTypeDAO;

    public List<MaterialType> getChildMaterialTypes(long parentMaterialTypeID) {

        //        for (MaterialType type: materialTypes) {
//            Optional<MaterialType> parent = materialTypeDAO.findById(type.getParentMaterialType().getMaterialTypeID());
//            type.setParentMaterialType(parent.get());
//        }

//        materialTypes.forEach(t -> {
//            Optional<MaterialType> parent = materialTypeDAO.findById(t.getParentMaterialType().getMaterialTypeID());
//            t.setParentMaterialType(parent.get());
//        });

        return materialTypeDAO.findChildMaterialTypes(parentMaterialTypeID);
    }

    public List<MaterialType> getRootMaterialTypes() {
        return materialTypeDAO.findRootMaterialTypes();
    }

}
