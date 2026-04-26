package com.re.ss15btth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> getByCategory(String category) {
        return repo.findByCategoryAndStatus(category, true);
    }

    public Page<Product> getHotProducts(int page, int size) {

        if (page < 0) page = 0;

        Pageable pageable = PageRequest.of(page, size);
        return repo.findHotProducts(pageable);
    }

    public List<ProductView> getMobileProducts() {
        return repo.findByStatusTrue();
    }

    public List<Product> search(String name, Double min, Double max) {

        if (min != null && max != null && min > max) {
            throw new RuntimeException("Khoảng giá không hợp lệ!");
        }

        return repo.findAll(ProductSpecification.filter(name, min, max));
    }
}