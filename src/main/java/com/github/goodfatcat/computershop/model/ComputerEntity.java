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
@NoArgsConstructor
@Table(name = "computer")
@ToString(callSuper = true)
public class ComputerEntity extends ProductEntity{
    private ComputerForm form;

    public ComputerEntity(String seriesNumber, int price, int productCount, ProductProducer producer, ComputerForm form) {
        super(seriesNumber, price, productCount, producer);
        this.form = form;
    }
}
