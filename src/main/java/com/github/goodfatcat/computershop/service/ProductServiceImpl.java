package com.github.goodfatcat.computershop.service;

import com.github.goodfatcat.computershop.DTO.*;
import com.github.goodfatcat.computershop.model.*;
import com.github.goodfatcat.computershop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private ProducerService producerService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProducerService producerService) {
        this.productRepository = productRepository;
        this.producerService = producerService;
    }

    @Override
    public ProductEntity save(ProductEntity entity) {
        return productRepository.save(entity);
    }

    @Override
    public ProductEntity save(ComputerDTO computerDTO) {
        ProducerEntity producer = producerService.getProducerOrCreateNew(computerDTO);

        ComputerEntity entity = new ComputerEntity(computerDTO, producer, computerDTO.getComputerForm());

        return productRepository.save(entity);
    }

    @Override
    public ProductEntity save(LaptopDTO laptopDTO) {
        ProducerEntity producer = producerService.getProducerOrCreateNew(laptopDTO);

        LaptopEntity entity = new LaptopEntity(laptopDTO, producer, laptopDTO.getLaptopSize());

        return productRepository.save(entity);
    }

    @Override
    public ProductEntity save(MonitorDTO monitorDTO) {
        ProducerEntity producer = producerService.getProducerOrCreateNew(monitorDTO);

        MonitorEntity entity = new MonitorEntity(monitorDTO, producer, monitorDTO.getMonitorSize());

        return productRepository.save(entity);
    }

    @Override
    public ProductEntity save(HardDriveDTO hardDriveDTO) {
        ProducerEntity producer = producerService.getProducerOrCreateNew(hardDriveDTO);

        HardDriveEntity entity = new HardDriveEntity(hardDriveDTO, producer, hardDriveDTO.getHardDriveCapacity());

        return productRepository.save(entity);
    }

    @Override
    public List<AbstractProductDTO> findAllByType(ProductType type) {
        switch (type) {
            case COMPUTER -> {
                return productRepository.findAllByClass(ComputerEntity.class)
                        .stream()
                        .map(ComputerDTO::new)
                        .collect(Collectors.toList());
            }
            case LAPTOP -> {
                return productRepository.findAllByClass(LaptopEntity.class)
                        .stream()
                        .map(LaptopDTO::new)
                        .collect(Collectors.toList());
            }
            case MONITOR -> {
                return productRepository.findAllByClass(MonitorEntity.class)
                        .stream()
                        .map(MonitorDTO::new)
                        .collect(Collectors.toList());
            }
            case HARD_DRIVE -> {
                return productRepository.findAllByClass(HardDriveEntity.class)
                        .stream()
                        .map(HardDriveDTO::new)
                        .collect(Collectors.toList());
            }
            default -> throw new NoSuchElementException("No such type " + type);
        }
    }

    @Override
    public Optional<ProductEntity> findById(long id) {
        return productRepository.findById(id);
    }
}
