package com.ladakh.databanking.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Unit {
    private long unitID;
    private String unitName;

    @Id
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
