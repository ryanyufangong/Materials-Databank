package com.ladakh.databanking.controller;

import com.ladakh.databanking.domain.Material;
import com.ladakh.databanking.domain.MaterialType;
import com.ladakh.databanking.service.MaterialTypeService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class MaterialTypeController {

    @Resource
    private MaterialTypeService materialTypeService;

    @CrossOrigin
    @RequestMapping(value = "materialType/getChildMaterialTypes", method = RequestMethod.POST)
    @ResponseBody
    public List<MaterialType> getChildMaterialTypes(@RequestBody Map<String, Long> requestBody) {
        Long parentMaterialTypeID = requestBody.get("parent_material_type");
        if (parentMaterialTypeID == null) {
            return new ArrayList<>();
        }
        return materialTypeService.getChildMaterialTypes(parentMaterialTypeID);
    }

    @CrossOrigin
    @RequestMapping(value = "materialType/getRootMaterialTypes", method = RequestMethod.POST)
    @ResponseBody
    public List<MaterialType> getRootMaterialTypes() {
        return materialTypeService.getRootMaterialTypes();
    }


}
