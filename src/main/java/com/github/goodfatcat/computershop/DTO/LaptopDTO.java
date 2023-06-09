package com.github.goodfatcat.computershop.DTO;

import com.github.goodfatcat.computershop.model.LaptopEntity;
import com.github.goodfatcat.computershop.model.LaptopSize;
import jakarta.validation.constraints.NotNull;

public class LaptopDTO extends AbstractProductDTO {
    @NotNull(message = "laptopSize must be not null")
    private LaptopSize laptopSize;

    public LaptopDTO(String seriesNumber, int price, int count, String producerName, LaptopSize laptopSize) {
        super(seriesNumber, price, count, producerName);
        this.laptopSize = laptopSize;
    }

    public LaptopDTO(LaptopEntity laptop) {
        super(laptop.getSeriesNumber(),
                laptop.getPrice(),
                laptop.getProductCount(),
                laptop.getProducer().getName());
        laptopSize = laptop.getLaptopSize();
    }

    public LaptopSize getLaptopSize() {
        return laptopSize;
    }

    public void setLaptopSize(LaptopSize laptopSize) {
        this.laptopSize = laptopSize;
    }
}
