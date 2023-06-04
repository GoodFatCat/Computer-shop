package com.github.goodfatcat.computershop.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public abstract class AbstractProductDTO {
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

    public AbstractProductDTO(String seriesNumber, int price, int count, String producerName) {
        this.seriesNumber = seriesNumber;
        this.price = price;
        this.count = count;
        this.producerName = producerName;
    }
}
