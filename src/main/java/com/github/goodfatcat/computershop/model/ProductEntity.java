package com.github.goodfatcat.computershop.model;

import com.github.goodfatcat.computershop.DTO.AbstractProductDTO;
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
    private ProducerEntity producer;

    public ProductEntity(AbstractProductDTO product, ProducerEntity producer) {
        this.seriesNumber = product.getSeriesNumber();
        this.price = product.getPrice();
        this.productCount = product.getCount();
        this.producer = producer;
    }
}
