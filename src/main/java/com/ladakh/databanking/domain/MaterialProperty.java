package com.ladakh.databanking.domain;

import jakarta.persistence.*;

@Entity
@Table
public class MaterialProperty {

    private int propertyId;
    private String propertyCategory;
    private MaterialPropertyCategory categoryId;

    @Id
    @Column(name = "property_id")
    public int getPropertyId() {
        return propertyId;
    }
    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    @Column(name = "property_Category")
    public String getPropertyCategory() {
        return propertyCategory;
    }
    public void setPropertyCategory(String propertyCategory) {
        this.propertyCategory = propertyCategory;
    }

    @ManyToOne
    @JoinColumn(name = "category_id")
    public MaterialPropertyCategory getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(MaterialPropertyCategory categoryId) {
        this.categoryId = categoryId;
    }
}
