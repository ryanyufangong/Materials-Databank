package com.ladakh.databanking.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Material_Type")
public class MaterialType {

    private long materialTypeID;
    private String name;
    private MaterialType parentMaterialType;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @JoinColumn(name = "parent_material_type")
    public MaterialType getParentMaterialType() {
        return parentMaterialType;
    }
    public void setParentMaterialType(MaterialType parentMaterialType) {
        this.parentMaterialType = parentMaterialType;
    }
}
