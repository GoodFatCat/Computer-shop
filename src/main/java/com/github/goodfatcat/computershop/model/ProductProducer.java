package com.github.goodfatcat.computershop.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class ProductProducer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany(mappedBy = "producer")
    private List<Product> products;

    public ProductProducer(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
