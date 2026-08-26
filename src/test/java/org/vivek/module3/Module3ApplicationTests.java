package org.vivek.module3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.vivek.module3.enitites.Product;
import org.vivek.module3.repositories.ProductRepositories;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class Module3ApplicationTests {

    @Autowired
    ProductRepositories productRepositories;

    @Test
    void contextLoads() {

    }

    @Test
    void testRepository(){
        Product product = Product.builder()
                .sku("nestle234")
                .title("Nestle Chocolate")
                .price(BigDecimal.valueOf(123.45))
                .quantity(12)
                .build();
        Product savedProductEntity = productRepositories.save(product);
        System.out.println(savedProductEntity);
    }

    @Test
    void getRepository() {
//        List<Product> entities = productRepositories.findAll();
        List<Product> entities = productRepositories.findByCreatedAtAfter(LocalDateTime.of(2024, 1, 1 , 0, 0));
        System.out.println(entities);
    }

}
