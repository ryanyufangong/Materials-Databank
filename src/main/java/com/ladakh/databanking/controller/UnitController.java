package com.ladakh.databanking.controller;

import com.ladakh.databanking.service.UnitService;
import jakarta.annotation.Resource;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnitController {
    @Resource
    private UnitService unitService;

    @RequestMapping(value = "unit/getUnitName", method = RequestMethod.GET)
    @ResponseBody
    public String getUnitName(@Param("unitID")long unitID) {
        return unitService.getUnitName(unitID);
    }

    @RequestMapping(value = "unit/changeUnitName", method = RequestMethod.GET)
    @ResponseBody
    public String changeUnitName(@Param("unitID")long unitID, @Param("newUnitName")String newUnitName) {
        return unitService.changeUnitName(unitID, newUnitName);
    }
}
