package com.ladakh.databanking.controller;

import com.ladakh.databanking.service.MaterialPropertyCategoryService;
import jakarta.annotation.Resource;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaterialPropertyCategoryController {
    @Resource
    private MaterialPropertyCategoryService materialPropertyCategoryService;

    @RequestMapping(value = "Category/getCategoryName", method = RequestMethod.GET)
    @ResponseBody
    public String getCategoryName(@Param("categoryID")long categoryID){
        return materialPropertyCategoryService.getCategoryName(categoryID);
    }

    @RequestMapping(value = "Category/changeCategoryName", method = RequestMethod.GET)
    @ResponseBody
    public String changeCategoryName(@Param("categoryID")long categoryID, @Param("newCategoryID")String newCategoryID){
        return materialPropertyCategoryService.changeCategoryName(categoryID, newCategoryID);
    }
}
