package com.re.ss15btth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/category")
    public List<Product> getByCategory(@RequestParam String category) {
        return service.getByCategory(category);
    }

    @GetMapping("/hot")
    public Page<Product> getHotProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return service.getHotProducts(page, size);
    }

    @GetMapping("/mobile")
    public List<ProductView> getMobileProducts() {
        return service.getMobileProducts();
    }

    @GetMapping("/search")
    public List<Product> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double min,
            @RequestParam(required = false) Double max) {

        return service.search(name, min, max);
    }
}
