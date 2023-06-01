package com.github.goodfatcat.computershop.DTO;

import com.github.goodfatcat.computershop.model.ProductType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public abstract class AbstractProduct {
    private final ProductType type;
    @NotNull(message = "seriesNumber must be not null")
    private String seriesNumber;
    @Positive(message = "price must be positive")
    @NotNull(message = "price must be not null")
    private int price;
    @Positive(message = "count must be positive")
    @NotNull(message = "count must be not null")
    private int count;
    @NotNull(message = "producerName must be not null")
    private String producerName;

    public AbstractProduct(ProductType type, String seriesNumber, int price, int count, String producerName) {
        this.type = type;
        this.seriesNumber = seriesNumber;
        this.price = price;
        this.count = count;
        this.producerName = producerName;
    }
}
