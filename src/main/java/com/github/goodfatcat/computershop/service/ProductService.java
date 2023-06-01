package com.github.goodfatcat.computershop.service;

import com.github.goodfatcat.computershop.DTO.*;
import com.github.goodfatcat.computershop.model.Product;

public interface ProductService {
    Product save(Product product);
    Product save(AbstractProduct computer);
}
