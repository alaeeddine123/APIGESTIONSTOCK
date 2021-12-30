package com.gestionstock.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * @author CHARRIK ALAE-EDDINE
 * @version 1.0
 * @since 10/11/2021
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public
class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long  productId;
    @Column(unique = true)
    @NotEmpty(message = "product Name can't be empty or Null")
    private String productName;
    @Column(name = "product_color")
    private String productColor;
    @Column(name = "product_type")
    private String productType;
    @Column(name = "product_category")
    private String productCategory;
    @Column(name = "product_cost")
    private double productCost;
    @Column(name = "product_selling_price")
    private double productSellingPrice;
    @Column(name = "product_quantity")
    private int   productQuantity;

    private String productImageUrl;

}
