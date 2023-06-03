package com.github.goodfatcat.computershop.service;

import com.github.goodfatcat.computershop.DTO.*;
import com.github.goodfatcat.computershop.model.ProductEntity;

public interface ProductService {
    ProductEntity save(ProductEntity product);
    ProductEntity save(Computer computer);
    ProductEntity save(Laptop laptop);
    ProductEntity save(Monitor monitor);
    ProductEntity save(HardDrive hardDrive);
}
