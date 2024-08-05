package com.ladakh.databanking.domain.test.dao;

import com.ladakh.databanking.dao.UnitDAO;
import com.ladakh.databanking.domain.Multiplier;
import com.ladakh.databanking.domain.Unit;
import com.ladakh.databanking.test.BaseSpringTest;
import com.ladakh.databanking.dao.MultiplierDAO;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public class MultiplierDAOTest extends BaseSpringTest {

    @Resource
    private MultiplierDAO multiplierDAO ;
    @Resource
    private UnitDAO unitDAO;

    @Test
    public void multiplierTest() {
        Unit unit1 = new Unit();
        unit1.setUnitID(1);
        unit1.setUnitName("Centimeter (cm)");
        Unit savedUnit1 = unitDAO.save(unit1);

        Unit unit2 = new Unit();
        unit2.setUnitID(2);
        unit2.setUnitName("Meter (m)");
        Unit savedUnit2 = unitDAO.save(unit2);

        Multiplier multiplier = new Multiplier();
        multiplier.setUnit1Multiplier(0.304800610);
        multiplier.setUnit2Multiplier(0.914401830);
        multiplier.setUnit1ID(savedUnit1);
        multiplier.setUnit2ID(savedUnit2);
        Multiplier savedMultiplier = multiplierDAO.save(multiplier);

        Multiplier multiplierTest = multiplierDAO.findByMultiplierID(savedMultiplier.getMultiplierID());
        Assertions.assertEquals(multiplierTest.getUnit1Multiplier(), 0.304800610);
        Assertions.assertEquals(multiplierTest.getUnit2Multiplier(), 0.914401830);

        savedMultiplier.setUnit1Multiplier(0.111111);
        savedMultiplier.setUnit2Multiplier(0.222222);
        savedMultiplier = multiplierDAO.save(savedMultiplier);

        multiplierTest = multiplierDAO.findByMultiplierID(savedMultiplier.getMultiplierID());
        Assertions.assertEquals(multiplierTest.getUnit1Multiplier(), 0.111111);
        Assertions.assertEquals(multiplierTest.getUnit2Multiplier(), 0.222222);

        multiplierDAO.delete(savedMultiplier);
        multiplierTest = multiplierDAO.findByMultiplierID(savedMultiplier.getMultiplierID());
        Assertions.assertNull(multiplierTest);
    }

    @Test
    public void multiplierTestUnit() {
        Unit unit1 = new Unit();
        unit1.setUnitID(1);
        unit1.setUnitName("Centimeter (cm)");
        Unit savedUnit1 = unitDAO.save(unit1);

        Unit unit2 = new Unit();
        unit2.setUnitID(2);
        unit2.setUnitName("Meter (m)");
        Unit savedUnit2 = unitDAO.save(unit2);

        Multiplier multiplier = new Multiplier();
        multiplier.setUnit1Multiplier(0.304800610);
        multiplier.setUnit2Multiplier(0.914401830);
        multiplier.setUnit1ID(savedUnit1);
        multiplier.setUnit2ID(savedUnit2);
        Multiplier savedMultiplier = multiplierDAO.save(multiplier);

        Multiplier multiplierTest = multiplierDAO.findByMultiplierID(savedMultiplier.getMultiplierID());
        Assertions.assertEquals(multiplierTest.getUnit1ID().getUnitName(), "Centimeter (cm)");
        Assertions.assertEquals(multiplierTest.getUnit2ID().getUnitName(), "Meter (m)");

        savedMultiplier.getUnit1ID().setUnitName("Millimeter (mm)");
        savedMultiplier.getUnit2ID().setUnitName("Centimeter (cm)");
        savedMultiplier = multiplierDAO.save(savedMultiplier);

        multiplierTest = multiplierDAO.findByMultiplierID(savedMultiplier.getMultiplierID());
        Assertions.assertEquals(multiplierTest.getUnit1ID().getUnitName(), "Millimeter (mm)");
        Assertions.assertEquals(multiplierTest.getUnit2ID().getUnitName(), "Centimeter (cm)");

    }
}
