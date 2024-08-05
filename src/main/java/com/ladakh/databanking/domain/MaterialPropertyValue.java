package com.ladakh.databanking.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "material_property_value")
public class MaterialPropertyValue {

    private long valueID;
    private String value;
    private Material material;
    private MaterialProperty materialProperty;

    @Id
    @Column(name = "property_value_id")
    public long getValueID() {
        return valueID;
    }
    public void setValueID(long valueID) {
        this.valueID = valueID;
    }

    @Column(name = "property_value")
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

    @ManyToOne
    @JoinColumn(name = "property_id")
    public MaterialProperty getMaterialProperty() {
        return materialProperty;
    }
    public void setMaterialProperty(MaterialProperty materialProperty) {
        this.materialProperty = materialProperty;
    }
}
