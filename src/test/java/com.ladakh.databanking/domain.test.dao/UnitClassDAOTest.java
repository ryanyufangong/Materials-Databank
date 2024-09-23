package com.ladakh.databanking.domain.test.dao;

import com.ladakh.databanking.dao.UnitClassDAO;
import com.ladakh.databanking.dao.UnitDAO;
import com.ladakh.databanking.domain.Unit;
import com.ladakh.databanking.domain.UnitClass;
import com.ladakh.databanking.test.BaseSpringTest;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UnitClassDAOTest extends BaseSpringTest {
    @Resource
    private UnitClassDAO unitClassDAO;
    @Resource
    private UnitDAO unitDAO;
    @Test
    public void UnitClassTest() {
        Unit unit = new Unit();
        unit.setUnitID(1);
        unit.setUnitName("Centimeter (cm)");
        Unit savedUnit = unitDAO.save(unit);

        UnitClass unitClass = new UnitClass();
        unitClass.setUnitClassName("length measurement");
        unitClass.setUnit(savedUnit);
        UnitClass savedUnitClass = unitClassDAO.save(unitClass);

        UnitClass unitClassTest = unitClassDAO.findByUnitClassID(savedUnitClass.getClassID());
        Assertions.assertEquals(unitClassTest.getUnitClassName(), "length measurement");

        savedUnitClass.setUnitClassName("percentage measurement");
        savedUnitClass = unitClassDAO.save(savedUnitClass);

        unitClassTest = unitClassDAO.findByUnitClassID(savedUnitClass.getClassID());
        Assertions.assertEquals(unitClassTest.getUnitClassName(), "percentage measurement");

        unitClassDAO.delete(savedUnitClass);
        unitClassTest = unitClassDAO.findByUnitClassID(savedUnitClass.getClassID());
        Assertions.assertNull(unitClassTest);
    }

    @Test
    public void UnitClassUnitTest() {
        Unit unit = new Unit();
        unit.setUnitID(1);
        unit.setUnitName("Centimeter (cm)");
        Unit savedUnit = unitDAO.save(unit);

        UnitClass unitClass = new UnitClass();
        unitClass.setUnitClassName("length measurement");
        unitClass.setUnit(savedUnit);
        UnitClass savedUnitClass = unitClassDAO.save(unitClass);

        UnitClass unitClassTest = unitClassDAO.findByUnitClassID(savedUnitClass.getClassID());
        Assertions.assertEquals(unitClassTest.getUnit().getUnitName(), "Centimeter (cm)");

        savedUnitClass.getUnit().setUnitName("Percentage (%)");
        savedUnitClass = unitClassDAO.save(savedUnitClass);

        unitClassTest = unitClassDAO.findByUnitClassID(savedUnitClass.getClassID());
        Assertions.assertEquals(unitClassTest.getUnit().getUnitName(), "Percentage (%)");
    }
}
