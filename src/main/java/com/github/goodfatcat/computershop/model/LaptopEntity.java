package com.github.goodfatcat.computershop.model;

import com.github.goodfatcat.computershop.DTO.AbstractProductDTO;
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
    private LaptopSize laptopSize;

    public LaptopEntity(AbstractProductDTO product, ProducerEntity producer, LaptopSize laptopSize) {
        super(product, producer);
        this.laptopSize = laptopSize;
    }
}
