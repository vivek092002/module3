package org.vivek.module3.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.vivek.module3.enitites.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepositories extends JpaRepository<Product, Long> {

    List<Product> findBy(Sort sort);

    List<Product>  findByOrderByPrice();

    List<Product> findByCreatedAtAfter(LocalDateTime after);

    @Query("select e from Product e where e.title = ?1 and e.price=?2" )
    Optional<Product> findByTitleAndPrice(String title, BigDecimal price);
}
