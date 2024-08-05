package com.ladakh.databanking.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "unit")
public class Unit {
    private long unitID;
    private String unitName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unit_id", nullable = false)
    public long getUnitID() {
        return unitID;
    }
    public void setUnitID(long unitID) {
        this.unitID = unitID;
    }

    @Column(name = "unit_name")
    public String getUnitName() {
        return unitName;
    }
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}
