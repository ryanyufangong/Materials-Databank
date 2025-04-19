package com.ladakh.databanking.controller;

import com.ladakh.databanking.domain.Material;
import com.ladakh.databanking.domain.MaterialType;
import com.ladakh.databanking.service.MaterialService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class MaterialController {
    @Resource
    private MaterialService materialService;

    @RequestMapping(value = "material/getMaterialName", method = RequestMethod.GET)
    @ResponseBody
    public String getMaterialName(@RequestParam("materialID")long materialID) {
        return materialService.getMaterialName(materialID);
    }

    @RequestMapping(value = "material/changeMaterialName", method = RequestMethod.GET)
    @ResponseBody
    public String changeMaterialName(@RequestParam("materialID")long materialID, @RequestParam("newMaterialName")String newMaterialName) {
        return materialService.changeMaterialName(materialID, newMaterialName);
    }

    @RequestMapping(value = "material/getMaterialTypeName", method = RequestMethod.GET)
    @ResponseBody
    public String getMaterialTypeName(@RequestParam("materialID")long materialID) {
        return materialService.getMaterialTypeName(materialID);
    }

    @RequestMapping(value = "material/getMaterialTypeParentName", method = RequestMethod.GET)
    @ResponseBody
    public String getMaterialTypeParentName(@RequestParam("materialID")long materialID) {
        return materialService.getMaterialTypeParentName(materialID);
    }

    @CrossOrigin
    @RequestMapping(value = "material/getMaterialsFromMaterialTypeID", method = RequestMethod.POST)
    @ResponseBody
    public List<Material> getMaterialsFromMaterialTypeID(@RequestBody Map<String, Long> requestBody) {
        Long materialTypeId = requestBody.get("material_type_id");
        return materialService.getMaterialsFromMaterialTypeID(materialTypeId);
    }





}
