package com.ladakh.databanking.domain;

import jakarta.persistence.*;

@Entity
@Table
public class Multiplier {
    private long multiplierID;
    private Unit unit1ID;
    private Unit unit2ID;
    private long unit1Multiplier;
    private long unit2Multiplier;

    @Id
    @Column(name = "multiplier_id", nullable = false)
    public long getMultiplierID() {
        return multiplierID;
    }
    public void setMultiplierID(long multiplierID) {
        this.multiplierID = multiplierID;
    }

    @OneToOne
    @JoinColumn(name = "unit1_id", nullable = false)
    public Unit getUnit1ID() {
        return unit1ID;
    }
    public void setUnit1ID(Unit unit1ID) {
        this.unit1ID = unit1ID;
    }

    @OneToOne
    @JoinColumn(name = "unit2_id", nullable = false)
    public Unit getUnit2ID() {
        return unit2ID;
    }
    public void setUnit2ID(Unit unit2ID) {
        this.unit2ID = unit2ID;
    }

    @Column(name = "unit1_multiplier")
    public long getUnit1Multiplier() {
        return unit1Multiplier;
    }
    public void setUnit1Multiplier(long unit1Multiplier) {
        this.unit1Multiplier = unit1Multiplier;
    }

    @Column(name = "unit2_multiplier")
    public long getUnit2Multiplier() {
        return unit2Multiplier;
    }
    public void setUnit2Multiplier(long unit2Multiplier) {
        this.unit2Multiplier = unit2Multiplier;
    }
}
