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
    private double size;

    public MonitorEntity(AbstractProductDTO product, ProductProducer producer, double size) {
        super(product, producer);
        this.size = size;
    }
}
