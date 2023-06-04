package com.github.goodfatcat.computershop.service;

import com.github.goodfatcat.computershop.DTO.*;
import com.github.goodfatcat.computershop.model.ProductEntity;
import com.github.goodfatcat.computershop.model.ProductType;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    ProductEntity save(ProductEntity entity);
    ProductEntity save(ComputerDTO computerDTO);
    ProductEntity save(LaptopDTO laptopDTO);
    ProductEntity save(MonitorDTO monitorDTO);
    ProductEntity save(HardDriveDTO hardDriveDTO);
    List<AbstractProductDTO> findAllByType(ProductType type);
    Optional<ProductEntity> findById(long id);
}
