package com.gestionstock.service.implementations;

import com.gestionstock.model.Product;
import com.gestionstock.repository.ProductRepo;
import com.gestionstock.service.ProductService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Random;

import static java.lang.Boolean.TRUE;



@Service
@ComponentScan({"com.gestionstock"})
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImplementations implements ProductService {

    @Autowired
    private final ProductRepo productRepo ;

    @Override
    public Product create(Product product) {
        log.info("Saving new Product: {}",product.getProductName());
        product.setProductImageUrl(setProductImageUrl());
        return productRepo.save(product);
    }



    @Override
    public Collection<Product> list(int Limit) {
        log.info("Loading all Products: ");
        return productRepo.findAll(PageRequest.of(0,Limit)).toList();
    }

    @Override
    public  Product get(Long productId) {
        log.info("Loading Products by Id : {} ", productId);
        return productRepo.findById(productId).get();
    }


    @Override
    public Product update(Product product) {
        log.info("Updating  Product: {}",product.getProductName());
        product.setProductImageUrl(setProductImageUrl());
        return productRepo.save(product);

    }

    @Override
    public boolean delete(Long productId) {
        log.info("deleting Product: {}",productId);
        productRepo.deleteById(productId);
        return TRUE;
    }

    private String setProductImageUrl() {

        String[] productNames =  {"product1.png","product2.png","product3.png","product4.png"};
        return  ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/product/image" + productNames[new Random().nextInt(4)])
                .toUriString();
    }
}
