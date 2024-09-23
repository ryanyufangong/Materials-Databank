package com.ladakh.databanking.service;

import com.ladakh.databanking.dao.UnitDAO;
import com.ladakh.databanking.domain.Unit;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UnitServiceImpl implements UnitService{
    @Resource
    private UnitDAO unitDAO;

    @Override
    public String getUnitName(long unitID) {
        Unit unit = unitDAO.findByUnitID(unitID);
        return unit.getUnitName();
    }

    public String changeUnitName(long unitID, String newUnitName) {
        Unit unit = unitDAO.findByUnitID(unitID);
        unit.setUnitName(newUnitName);
        unit = unitDAO.save(unit);
        return unit.getUnitName();
    }
}
