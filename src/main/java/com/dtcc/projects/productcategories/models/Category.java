package com.dtcc.projects.productcategories.models;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor

public class Category {
    @Id
    @GeneratedValue
    @Column(name = "Category_Id")
    private Integer categoryId;

    @Column (name = "Category_name")
    private String categoryName;

    @Column (name = "Created_At")
    private Date createdAt;

    @Column (name = "updatedAt")
    private Date updatedAt;

    @ManyToMany
    @JoinTable(name = "categories_products", joinColumns = @JoinColumn (name = "category_id"), inverseJoinColumns = @JoinColumn(name = "product_Id"))
    private List<Product> productList;

    public Category(String categoryName, Date createdAt, Date updatedAt) {
        this.categoryName = categoryName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
