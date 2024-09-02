package com.ladakh.databanking.service;

import com.ladakh.databanking.dao.MaterialPropertyCategoryDAO;
import com.ladakh.databanking.domain.MaterialPropertyCategory;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class MaterialPropertyCategoryServiceImpl implements MaterialPropertyCategoryService{
    @Resource
    private MaterialPropertyCategoryDAO materialPropertyCategoryDAO;

    public String getCategoryName(long categoryID) {
        MaterialPropertyCategory materialPropertyCategory = materialPropertyCategoryDAO.findBycategoryId(categoryID);
        return  materialPropertyCategory.getName();
    }

    public String changeCategoryName(long categoryID, String newCategoryName) {
        MaterialPropertyCategory materialPropertyCategory = materialPropertyCategoryDAO.findBycategoryId(categoryID);
        materialPropertyCategory.setName(newCategoryName);
        materialPropertyCategory = materialPropertyCategoryDAO.save(materialPropertyCategory);
        return materialPropertyCategory.getName();
    }
}
