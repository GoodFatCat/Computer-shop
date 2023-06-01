package com.github.goodfatcat.computershop.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private ProductType type;
    private String seriesNumber;
    private int price;
    private int productCount;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "producer_id")
    private ProductProducer producer;
    @Nullable
    private ComputerForm computerForm;
    @Nullable
    private LaptopSize laptopSize;
    @Nullable
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "monitor_size")
    private MonitorSize monitorSize;
    @Nullable
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hard_drive_capacity")
    private HardDriveCapacity hardDriveCapacity;
}
