package com.github.goodfatcat.computershop.service;

import com.github.goodfatcat.computershop.DTO.AbstractProductDTO;
import com.github.goodfatcat.computershop.model.ProducerEntity;
import com.github.goodfatcat.computershop.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerServiceImpl implements ProducerService {
    private final ProducerRepository producerRepository;

    @Autowired
    public ProducerServiceImpl(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }

    @Override
    public ProducerEntity getProducerOrCreateNew(AbstractProductDTO product) {
        ProducerEntity producer = new ProducerEntity(product.getProducerName());
        producer = producerRepository.findByName(product.getProducerName()).orElse(producer);
        return producer;
    }
}
