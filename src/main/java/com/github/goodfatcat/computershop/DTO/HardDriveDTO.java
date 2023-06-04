package com.github.goodfatcat.computershop.DTO;

import com.github.goodfatcat.computershop.model.HardDriveEntity;
import jakarta.validation.constraints.Positive;

public class HardDriveDTO extends AbstractProductDTO {
    @Positive(message = "hardDriveCapacity must be positive")
    private int hardDriveCapacity;

    public HardDriveDTO(String seriesNumber, int price, int count, String producerName, int hardDriveCapacity) {
        super(seriesNumber, price, count, producerName);
        this.hardDriveCapacity = hardDriveCapacity;
    }

    public HardDriveDTO(HardDriveEntity hardDrive) {
        super(hardDrive.getSeriesNumber(),
                hardDrive.getPrice(),
                hardDrive.getProductCount(),
                hardDrive.getProducer().getName());
        hardDriveCapacity = hardDrive.getCapacity();
    }

    public int getHardDriveCapacity() {
        return hardDriveCapacity;
    }

    public void setHardDriveCapacity(int hardDriveCapacity) {
        this.hardDriveCapacity = hardDriveCapacity;
    }
}

