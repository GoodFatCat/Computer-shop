package com.github.goodfatcat.computershop.DTO;

import com.github.goodfatcat.computershop.model.MonitorEntity;
import jakarta.validation.constraints.Positive;

public class MonitorDTO extends AbstractProductDTO {
    @Positive(message = "monitorSize must be positive")
    private double monitorSize;

    public MonitorDTO(MonitorEntity monitor) {
        super(monitor.getSeriesNumber(),
                monitor.getPrice(),
                monitor.getProductCount(),
                monitor.getProducer().getName());
        monitorSize = monitor.getSize();
    }

    public double getMonitorSize() {
        return monitorSize;
    }

    public void setMonitorSize(double monitorSize) {
        this.monitorSize = monitorSize;
    }
}

