package com.ladakh.databanking.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Material")
public class Material {

    private long materialID;
    private String name;
    private MaterialType materialType;

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

    @ManyToOne
    @JoinColumn(name = "material_type_id", nullable = false)
    public MaterialType getMaterialType() {
        return materialType;
    }
    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
    }
}
