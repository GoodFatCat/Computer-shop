package com.github.goodfatcat.computershop.DTO;

import com.github.goodfatcat.computershop.model.ComputerForm;
import com.github.goodfatcat.computershop.model.ProductType;
import jakarta.validation.constraints.NotNull;

public class Computer extends AbstractProduct {
    @NotNull(message = "computerForm must be not null")
    private ComputerForm computerForm;

    public Computer(String seriesNumber,
                    int price,
                    int count,
                    String producerName,
                    ComputerForm computerForm) {
        super(ProductType.COMPUTER, seriesNumber, price, count, producerName);
        this.computerForm = computerForm;
    }

    public ComputerForm getComputerForm() {
        return computerForm;
    }

    public void setComputerForm(ComputerForm computerForm) {
        this.computerForm = computerForm;
    }
}
