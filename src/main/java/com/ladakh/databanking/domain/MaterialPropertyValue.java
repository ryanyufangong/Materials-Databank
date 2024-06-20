package com.ladakh.databanking.domain;

import jakarta.persistence.*;


public class MaterialPropertyValue {

    //private long valueID;
    private String value;
    private Material material;
    private MaterialProperty materialProperty;


    @Column(name = "values")
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    @ManyToOne
    @JoinColumn(name = "material_id")
    public Material getMaterial() {
        return material;
    }
    public void setMaterial(Material material) {
        this.material = material;
    }

    @OneToMany
    @JoinColumn(name = "property_id")
    public MaterialProperty getMaterialProperty() {
        return materialProperty;
    }
    public void setMaterialProperty(MaterialProperty materialProperty) {
        this.materialProperty = materialProperty;
    }
}
