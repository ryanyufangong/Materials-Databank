package com.ladakh.databanking.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "unit_class")
public class UnitClass {
    private long classID;
    private String unitClassName;
    private Unit unit;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unit_class_id", nullable = false)
    public long getClassID() {
        return classID;
    }
    public void setClassID(long classId) {
        this.classID = classId;
    }

    @Column(name = "unit_class_name")
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
