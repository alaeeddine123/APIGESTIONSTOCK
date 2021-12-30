package com.gestionstock.repository;


import com.gestionstock.model.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author CHARRIK ALAE-EDDINE
 * @version 1.0
 * @since 10/11/2021
 */

@Repository
public interface ProductRepo  extends JpaRepository<Product, Long> {

    Product findByName(String ProductName);

}
