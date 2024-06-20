package com.ladakh.databanking.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Material {

    private long materialID;
    private String name;
    private long materialTypeID;

    @Id
    @Column(name = "material_id", nullable = false)
    public long getMaterialID() {
        return materialID;
    }
    public void setMaterialID(long materialID) {
        this.materialID = materialID;
    }

    @Column(name = "material_name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "material_type_id")
    public long getMaterialTypeID() {
        return materialTypeID;
    }
    public void setMaterialTypeID(long materialTypeID) {
        this.materialTypeID = materialTypeID;
    }
}
