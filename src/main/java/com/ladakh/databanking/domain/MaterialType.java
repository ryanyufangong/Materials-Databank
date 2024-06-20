package com.ladakh.databanking.domain;

import jakarta.persistence.*;

@Entity
@Table
public class MaterialType {

    private long materialTypeID;
    private String name;
    private Material material;

    @Id
    @Column(name = "type_id")
    public long getMaterialTypeID() {
        return materialTypeID;
    }
    public void setMaterialTypeID(long materialTypeID) {
        this.materialTypeID = materialTypeID;
    }

    @Column(name = "type_name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "material_id", nullable = false)
    public Material getMaterial() {
        return material;
    }
    public void setMaterial(Material material) {
        this.material = material;
    }
}
