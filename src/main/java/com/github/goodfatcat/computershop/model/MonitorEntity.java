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
@ToString(callSuper = true)
@Table(name = "monitor")
public class MonitorEntity extends ProductEntity{
    private double monitorSize;

    public MonitorEntity(AbstractProductDTO product, ProducerEntity producer, double monitorSize) {
        super(product, producer);
        this.monitorSize = monitorSize;
    }
}
