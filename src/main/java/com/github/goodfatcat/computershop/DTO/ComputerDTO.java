package com.github.goodfatcat.computershop.DTO;

import com.github.goodfatcat.computershop.model.ComputerEntity;
import com.github.goodfatcat.computershop.model.ComputerForm;
import jakarta.validation.constraints.NotNull;

public class ComputerDTO extends AbstractProductDTO {
    @NotNull(message = "computerForm must be not null")
    private ComputerForm computerForm;

    public ComputerDTO(String seriesNumber, int price, int count, String producerName, ComputerForm computerForm) {
        super(seriesNumber, price, count, producerName);
        this.computerForm = computerForm;
    }

    public ComputerDTO(ComputerEntity computer) {
        super(computer.getSeriesNumber(),
                computer.getPrice(),
                computer.getProductCount(), computer.getProducer().getName());
        computerForm = computer.getForm();
    }

    public ComputerForm getComputerForm() {
        return computerForm;
    }

    public void setComputerForm(ComputerForm computerForm) {
        this.computerForm = computerForm;
    }
}
