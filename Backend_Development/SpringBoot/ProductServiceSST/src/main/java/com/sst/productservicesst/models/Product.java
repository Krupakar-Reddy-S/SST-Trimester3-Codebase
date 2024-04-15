package com.sst.productservicesst.models;

import jakarta.persistence.*;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Double price;
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;
    private String imageUrl;
    // private int quantity;
}
