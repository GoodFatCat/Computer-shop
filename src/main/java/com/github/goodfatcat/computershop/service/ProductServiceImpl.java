package com.github.goodfatcat.computershop.service;

import com.github.goodfatcat.computershop.DTO.*;
import com.github.goodfatcat.computershop.model.*;
import com.github.goodfatcat.computershop.repository.HardDriveRepository;
import com.github.goodfatcat.computershop.repository.MonitorRepository;
import com.github.goodfatcat.computershop.repository.ProducerRepository;
import com.github.goodfatcat.computershop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProducerRepository producerRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProducerRepository producerRepository) {
        this.productRepository = productRepository;
        this.producerRepository = producerRepository;
    }

    @Override
    public ProductEntity save(ProductEntity product) {
        return productRepository.save(product);
    }

    @Override
    public ProductEntity save(Computer computer) {
        ProductProducer producer = getProducer(computer);

        ComputerEntity entity = new ComputerEntity(computer, producer, computer.getComputerForm());

        return productRepository.save(entity);
    }

    private ProductProducer getProducer(AbstractProduct product) {
        ProductProducer producer = new ProductProducer(product.getProducerName());
        producer = producerRepository.findByName(product.getProducerName()).orElse(producer);
        return producer;
    }

    @Override
    public ProductEntity save(Laptop laptop) {
        ProductProducer producer = getProducer(laptop);

        LaptopEntity entity = new LaptopEntity(laptop, producer, laptop.getLaptopSize());

        return productRepository.save(entity);
    }

    @Override
    public ProductEntity save(Monitor monitor) {
        ProductProducer producer = getProducer(monitor);

        MonitorEntity entity = new MonitorEntity(monitor, producer, monitor.getMonitorSize());

        return productRepository.save(entity);
    }

    @Override
    public ProductEntity save(HardDrive hardDrive) {
        ProductProducer producer = getProducer(hardDrive);

        HardDriveEntity entity = new HardDriveEntity(hardDrive, producer, hardDrive.getHardDriveCapacity());

        return productRepository.save(entity);
    }
}
