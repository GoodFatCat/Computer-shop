package com.github.goodfatcat.computershop.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class HardDriveCapacity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int capacity;
    @OneToMany(mappedBy = "hardDriveCapacity")
    private List<Product> products;

    public HardDriveCapacity(long id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }
}
