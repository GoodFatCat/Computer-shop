package com.github.goodfatcat.computershop.DTO;

import com.github.goodfatcat.computershop.model.LaptopSize;
import jakarta.validation.constraints.NotNull;

public class Laptop extends AbstractProduct{
    @NotNull(message = "laptopSize must be not null")
    private LaptopSize laptopSize;

    public Laptop(String seriesNumber, int price, int count, String producerName, LaptopSize laptopSize) {
        super(seriesNumber, price, count, producerName);
        this.laptopSize = laptopSize;
    }

    public LaptopSize getLaptopSize() {
        return laptopSize;
    }

    public void setLaptopSize(LaptopSize laptopSize) {
        this.laptopSize = laptopSize;
    }
}
