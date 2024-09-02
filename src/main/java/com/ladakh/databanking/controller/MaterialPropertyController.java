package com.ladakh.databanking.controller;

import com.ladakh.databanking.service.MaterialPropertyService;
import jakarta.annotation.Resource;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaterialPropertyController {
    @Resource
    private MaterialPropertyService materialPropertyService;

    @RequestMapping(value = "materialProperty/getMaterialProperty", method = RequestMethod.GET)
    @ResponseBody
    public String getMaterialProperty(@Param("propertyID")long propertyID){
        return materialPropertyService.getMaterialProperty(propertyID);
    }
    @RequestMapping(value = "materialProperty/changeMaterialProperty", method = RequestMethod.GET)
    @ResponseBody
    public String changeMaterialProperty(@Param("propertyID")long propertyID, @Param("newProperty")String newProperty){
        return materialPropertyService.changeMaterialProperty(propertyID, newProperty);
    }
    @RequestMapping(value = "materialProperty/getMaterialPropertyCategory", method = RequestMethod.GET)
    @ResponseBody
    public String getMaterialPropertyCategory(@Param("propertyID")long propertyID){
        return materialPropertyService.getMaterialPropertyCategory(propertyID);
    }
    @RequestMapping(value = "materialProperty/getMaterialPropertyUnit", method = RequestMethod.GET)
    @ResponseBody
    public String getMaterialPropertyUnit(@Param("propertyID")long propertyID){
        return materialPropertyService.getMaterialPropertyUnit(propertyID);
    }
}
