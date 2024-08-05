package com.ladakh.databanking.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "material_property")
public class MaterialProperty {

    private long propertyID;
    private String propertyCategory;
    private MaterialPropertyCategory materialPropertyCategory;
    private Unit unit;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "property_id")
    public long getPropertyID() {
        return propertyID;
    }
    public void setPropertyID(long propertyID) {
        this.propertyID = propertyID;
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
    public MaterialPropertyCategory getMaterialPropertyCategory() {
        return materialPropertyCategory;
    }
    public void setMaterialPropertyCategory(MaterialPropertyCategory categoryId) {
        this.materialPropertyCategory = categoryId;
    }

    @ManyToOne
    @JoinColumn(name = "unit_id")
    public Unit getUnit() {
        return unit;
    }
    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
