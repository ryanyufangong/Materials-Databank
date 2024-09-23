package com.ladakh.databanking.domain.test.dao;

import com.ladakh.databanking.dao.UnitDAO;
import com.ladakh.databanking.domain.Unit;
import com.ladakh.databanking.test.BaseSpringTest;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UnitDAOTest extends BaseSpringTest {
    @Resource
    private UnitDAO unitDAO;
    @Test
    public void UnitTest() {
        Unit unit = new Unit();
        unit.setUnitName("Centimeter (cm)");
        Unit savedUnit = unitDAO.save(unit);

        Unit unitTest = unitDAO.findByUnitID(savedUnit.getUnitID());
        Assertions.assertEquals(unitTest.getUnitName(), "Centimeter (cm)");

        savedUnit.setUnitName("Meter (m)");
        savedUnit = unitDAO.save(savedUnit);

        unitTest = unitDAO.findByUnitID(savedUnit.getUnitID());
        Assertions.assertEquals(unitTest.getUnitName(), "Meter (m)");

        unitDAO.delete(savedUnit);
        unitTest = unitDAO.findByUnitID(savedUnit.getUnitID());
        Assertions.assertNull(unitTest);

    }
}
