package com.re.ss15btth;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Double price;
    private Integer stockQuantity;
    private String category;
    private Boolean status;
}