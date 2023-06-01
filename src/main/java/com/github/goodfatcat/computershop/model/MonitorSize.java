package com.github.goodfatcat.computershop.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class MonitorSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double size;
    @OneToMany(mappedBy = "monitorSize")
    private List<Product> products;

    public MonitorSize(long id, double size) {
        this.id = id;
        this.size = size;
    }
}
