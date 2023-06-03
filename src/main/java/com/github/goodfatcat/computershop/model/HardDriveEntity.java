package com.github.goodfatcat.computershop.model;

import com.github.goodfatcat.computershop.DTO.AbstractProduct;
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

    public HardDriveEntity(AbstractProduct product, ProductProducer producer, int capacity) {
        super(product, producer);
        this.capacity = capacity;
    }
}
