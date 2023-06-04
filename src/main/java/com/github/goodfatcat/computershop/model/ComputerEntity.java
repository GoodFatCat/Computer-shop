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
@NoArgsConstructor
@Table(name = "computer")
@ToString(callSuper = true)
public class ComputerEntity extends ProductEntity{
    private ComputerForm form;

    public ComputerEntity(AbstractProductDTO product, ProducerEntity producer, ComputerForm form) {
        super(product, producer);
        this.form = form;
    }
}
