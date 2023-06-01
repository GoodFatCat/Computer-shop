package com.github.goodfatcat.computershop.DTO;

import com.github.goodfatcat.computershop.model.ProductType;
import jakarta.validation.constraints.Positive;

public class Monitor extends AbstractProduct{
    @Positive(message = "monitorSize must be positive")
    private double monitorSize;

    public Monitor(String seriesNumber, int price, int count, String producerName, double monitorSize) {
        super(ProductType.MONITOR, seriesNumber, price, count, producerName);
        this.monitorSize = monitorSize;
    }

    public double getMonitorSize() {
        return monitorSize;
    }

    public void setMonitorSize(double monitorSize) {
        this.monitorSize = monitorSize;
    }
}

