package com.ladakh.databanking.domain;

import jakarta.persistence.*;

@Entity
@Table
public class UnitClass {
    private int classId;
    private String unitClassName;
    private Unit unit;

    @Id
    @Column(name = "class_id", nullable = false)
    public int getClassId() {
        return classId;
    }
    public void setClassId(int classId) {
        this.classId = classId;
    }

    @Column(name = "unitClass_name")
    public String getUnitClassName() {
        return unitClassName;
    }
    public void setUnitClassName(String unitClassName) {
        this.unitClassName = unitClassName;
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
