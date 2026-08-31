package org.vivek.module3.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vivek.module3.enitites.Product;
import org.vivek.module3.repositories.ProductRepositories;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductControllers {
    private final ProductRepositories productRepositories;

    private final int PAGE_SIZE = 5;

    public ProductControllers(ProductRepositories productRepositories){
        this.productRepositories = productRepositories;
    }
//    @GetMapping
//    public List<Product> getAllProducts() {
//        return productRepositories.findByOrderByPrice( );
//    }

    //to get the details in the sorting order
//    @GetMapping
//    public List<Product> getAllProducts(@RequestParam(defaultValue = "id") String sortBy){
////        return productRepositories.findBy(Sort.by(sortBy));
//        return productRepositories.findBy(Sort.by(Sort.Direction.DESC, sortBy));// we can add multiple field for the conditions if two fields have same properties then it will be sorted on the basis of other field
//
//    }

    //for pagination and pageable
    @GetMapping
    public List<Product> getAllProducts(@RequestParam(defaultValue = "id")String sortBy, @RequestParam(defaultValue = "0") Integer pageNumber){
        Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE);
        return productRepositories.findAll(pageable).getContent();
    }
}
