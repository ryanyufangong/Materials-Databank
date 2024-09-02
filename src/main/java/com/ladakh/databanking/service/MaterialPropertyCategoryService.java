package com.ladakh.databanking.service;

public interface MaterialPropertyCategoryService {
     String getCategoryName(long categoryID);
     String changeCategoryName(long categoryID, String newCategoryName);
}
