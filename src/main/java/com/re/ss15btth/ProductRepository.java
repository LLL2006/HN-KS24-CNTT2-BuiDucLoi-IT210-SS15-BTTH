package com.re.ss15btth;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    List<Product> findByCategoryAndStatus(String category, boolean status);

    @Query("SELECT p FROM Product p WHERE p.status = true ORDER BY p.price DESC")
    Page<Product> findHotProducts(Pageable pageable);

    List<ProductView> findByStatusTrue();
}