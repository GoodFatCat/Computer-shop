package com.github.goodfatcat.computershop.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString(callSuper = true)
public class MonitorEntity extends ProductEntity{
    private double size;

    public MonitorEntity(String seriesNumber, int price, int productCount, ProductProducer producer, double size) {
        super(seriesNumber, price, productCount, producer);
        this.size = size;
    }
}
