package com.ladakh.databanking.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MaterialPropertyCategory")
public class MaterialPropertyCategory {

    private long categoryId;
    private String name;

    @Id
    @Column(name = "category_id")
    public long getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    @Column(name = "category_name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
