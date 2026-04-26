package com.re.ss15btth;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class ProductSpecification {

    public static Specification<Product> filter(String name, Double min, Double max) {

        return (root, query, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (name != null && !name.isEmpty()) {
                predicates.add(cb.like(root.get("productName"), "%" + name + "%"));
            }

            if (min != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("price"), min));
            }

            if (max != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("price"), max));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
