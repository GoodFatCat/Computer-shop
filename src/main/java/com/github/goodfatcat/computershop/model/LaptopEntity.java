package com.github.goodfatcat.computershop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "laptop")
@NoArgsConstructor
@ToString(callSuper = true)
public class LaptopEntity extends ProductEntity{
    private LaptopSize size;

    public LaptopEntity(String seriesNumber, int price, int productCount, ProductProducer producer, LaptopSize size) {
        super(seriesNumber, price, productCount, producer);
        this.size = size;
    }
}
