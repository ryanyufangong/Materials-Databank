package com.ladakh.databanking.service;

public interface UnitService {
    String getUnitName(long unitID);
    String changeUnitName(long unitID, String newUnitName);
}
