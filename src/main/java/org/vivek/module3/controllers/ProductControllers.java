package org.vivek.module3.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vivek.module3.enitites.Product;
import org.vivek.module3.repositories.ProductRepositories;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductControllers {
    private final ProductRepositories productRepositories;

    public ProductControllers(ProductRepositories productRepositories){
        this.productRepositories = productRepositories;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepositories.findByOrderByPrice( );
    }
}
