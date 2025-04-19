package com.ladakh.databanking.service;

import com.ladakh.databanking.domain.MaterialType;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public interface MaterialTypeService {
    List<MaterialType> getChildMaterialTypes(long parentMaterialTypeID);
    List<MaterialType> getRootMaterialTypes();

}
