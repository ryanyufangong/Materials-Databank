package com.ladakh.databanking.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class MaterialPropertyCategory {

    private int categoryId;
    private String name;

    @Id
    @Column(name = "category_id")
    public int getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(int categoryId) {
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
