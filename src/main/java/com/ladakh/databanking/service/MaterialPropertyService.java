package com.ladakh.databanking.service;

public interface MaterialPropertyService {
    String getMaterialProperty(long propertyID);
    String changeMaterialProperty(long propertyID, String newProperty);
    String getMaterialPropertyCategory(long propertyID);
    String getMaterialPropertyUnit(long propertyID);

}
