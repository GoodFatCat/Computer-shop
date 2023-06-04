package com.github.goodfatcat.computershop.model;

import com.github.goodfatcat.computershop.DTO.AbstractProductDTO;
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
    private int hardDriveCapacity;

    public HardDriveEntity(AbstractProductDTO product, ProducerEntity producer, int hardDriveCapacity) {
        super(product, producer);
        this.hardDriveCapacity = hardDriveCapacity;
    }
}
