package com.gestionstock.service;

import com.gestionstock.model.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Collection;


public interface ProductService  {

    Product create(Product product);
    Collection<Product> list(int Limit);
    Object get(Long productId);
    Product update(Product product);
    boolean delete(Long productId);
}
