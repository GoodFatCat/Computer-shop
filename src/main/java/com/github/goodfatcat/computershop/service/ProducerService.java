package com.github.goodfatcat.computershop.service;

import com.github.goodfatcat.computershop.DTO.AbstractProductDTO;
import com.github.goodfatcat.computershop.model.ProducerEntity;

public interface ProducerService {
    ProducerEntity getProducerOrCreateNew(AbstractProductDTO product);
}
