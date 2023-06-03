package com.github.goodfatcat.computershop.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "product")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String seriesNumber;
    private int price;
    private int productCount;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "producer_id")
    private ProductProducer producer;

    public ProductEntity(String seriesNumber, int price, int productCount, ProductProducer producer) {
        this.seriesNumber = seriesNumber;
        this.price = price;
        this.productCount = productCount;
        this.producer = producer;
    }
}
