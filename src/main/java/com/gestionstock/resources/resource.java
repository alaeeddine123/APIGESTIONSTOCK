package com.gestionstock.resources;


import com.gestionstock.model.Product;
import com.gestionstock.model.Response;
import com.gestionstock.service.implementations.ProductServiceImplementations;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

@RestController
@RequestMapping("/product")
@ComponentScan({"com.gestionstock"})
@RequiredArgsConstructor
public class resource {

    //@Autowired
    private final ProductServiceImplementations productService;

    @GetMapping("/list")
    public ResponseEntity<Response> getProducts() {

        return ResponseEntity.ok(
                Response.builder().
                        timeStamp(LocalDateTime.now())
                        .data(Map.of("Products", productService.list(30)))
                        .message("product Loading")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
    @PostMapping("/saveproducts")
    public ResponseEntity<Response> saveProduct(@RequestBody @Valid Product product) {

        return ResponseEntity.ok(
                Response.builder().
                        timeStamp(LocalDateTime.now())
                        .data(Map.of("Product", product))
                        .message(" function to look for a product if exist to add later now its not working")
                        .status(CREATED)
                        .statusCode(CREATED.value()).message(" if 201 -> created")
                        .build()
        );
    }

    @GetMapping("/get/{productId}")
    public ResponseEntity<Response> getProductbyid(@PathVariable("productId") long productId) {

        return ResponseEntity.ok(
                Response.builder().
                        timeStamp(LocalDateTime.now())
                        .data(Map.of("Products", productService.get(productId)))
                        .message("product is retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<Response> deleteProduct(@PathVariable("productId") long productId) {

        return ResponseEntity.ok(
                Response.builder().
                        timeStamp(LocalDateTime.now())
                        .data(Map.of("deleted", productService.delete(productId)))
                        .message("product is retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }


    @GetMapping(path = "/image/{fileName}", produces = IMAGE_PNG_VALUE)
    public byte[] getProductImage(@PathVariable("fileName") String fileName) throws IOException {

        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "Downloads/images/" + fileName ));
    }




}
