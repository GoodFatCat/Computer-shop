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
@Table(name = "hard_drive")
@ToString(callSuper = true)
public class HardDriveEntity extends ProductEntity{
    private int capacity;

    public HardDriveEntity(String seriesNumber, int price, int productCount, ProductProducer producer, int capacity) {
        super(seriesNumber, price, productCount, producer);
        this.capacity = capacity;
    }
}
