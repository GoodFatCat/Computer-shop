package com.github.goodfatcat.computershop.DTO;

import jakarta.validation.constraints.Positive;

public class HardDrive extends AbstractProduct{
    @Positive(message = "hardDriveCapacity must be positive")
    private int hardDriveCapacity;

    public HardDrive(String seriesNumber, int price, int count, String producerName, int hardDriveCapacity) {
        super(seriesNumber, price, count, producerName);
        this.hardDriveCapacity = hardDriveCapacity;
    }

    public int getHardDriveCapacity() {
        return hardDriveCapacity;
    }

    public void setHardDriveCapacity(int hardDriveCapacity) {
        this.hardDriveCapacity = hardDriveCapacity;
    }
}

