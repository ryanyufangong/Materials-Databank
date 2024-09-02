package com.ladakh.databanking.service;

public interface MaterialPropertyValueService {
    String getPropertyValue(long materialID, long propertyID);
    String changePropertyValue(long materialID, long propertyID, String newValueName);
    String getValueMaterial(long materialID, long propertyID);
    String getValueMaterialProperty(long materialID, long propertyID);
}
