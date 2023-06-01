package com.github.goodfatcat.computershop.service;

import com.github.goodfatcat.computershop.DTO.*;
import com.github.goodfatcat.computershop.model.HardDriveCapacity;
import com.github.goodfatcat.computershop.model.MonitorSize;
import com.github.goodfatcat.computershop.model.Product;
import com.github.goodfatcat.computershop.model.ProductProducer;
import com.github.goodfatcat.computershop.repository.HardDriveCapacityRepository;
import com.github.goodfatcat.computershop.repository.MonitorSizeRepository;
import com.github.goodfatcat.computershop.repository.ProducerRepository;
import com.github.goodfatcat.computershop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProducerRepository producerRepository;
    private final MonitorSizeRepository monitorSizeRepository;
    private final HardDriveCapacityRepository hardDriveCapacityRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProducerRepository producerRepository, MonitorSizeRepository monitorSizeRepository, HardDriveCapacityRepository hardDriveCapacityRepository) {
        this.productRepository = productRepository;
        this.producerRepository = producerRepository;
        this.monitorSizeRepository = monitorSizeRepository;
        this.hardDriveCapacityRepository = hardDriveCapacityRepository;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product save(AbstractProduct abstractProduct) {
        Product product = getProduct(abstractProduct);
        return productRepository.save(product);
    }

    private Product getProduct(AbstractProduct abstractProduct) {
        Product product = initProperties(abstractProduct);

        initAdditionalProperties(abstractProduct, product);

        return product;
    }

    private Product initProperties(AbstractProduct abstractProduct) {
        Product product = new Product();
        product.setSeriesNumber(abstractProduct.getSeriesNumber());
        product.setPrice(abstractProduct.getPrice());
        product.setProductCount(abstractProduct.getCount());

        String producerName = abstractProduct.getProducerName();
        product.setProducer(getProducer(producerName));

        product.setType(abstractProduct.getType());
        return product;
    }
    private void initAdditionalProperties(AbstractProduct abstractProduct, Product product) {
        switch (abstractProduct.getType()) {
            case COMPUTER -> {
                Computer computer = (Computer) abstractProduct;
                product.setComputerForm(computer.getComputerForm());
            }
            case LAPTOP -> {
                Laptop laptop = (Laptop) abstractProduct;
                product.setLaptopSize(laptop.getLaptopSize());
            }
            case MONITOR -> {
                Monitor monitor = (Monitor) abstractProduct;
                product.setMonitorSize(getMonitorSize(monitor.getMonitorSize()));
            }
            case HARD_DRIVER -> {
                HardDrive hardDrive = (HardDrive) abstractProduct;
                product.setHardDriveCapacity(getHardDriveCapacity(hardDrive.getHardDriveCapacity()));
            }
        }
    }

    private ProductProducer getProducer(String producerName) {
        ProductProducer productProducer = new ProductProducer();
        productProducer.setName(producerName);
        return producerRepository.findByName(producerName).orElse(productProducer);
    }

    private MonitorSize getMonitorSize(double size) {
        MonitorSize monitorSize = new MonitorSize();
        monitorSize.setSize(size);
        return monitorSizeRepository.findBySize(size).orElse(monitorSize);
    }

    private HardDriveCapacity getHardDriveCapacity(int capacity) {
        HardDriveCapacity hardDriveCapacity = new HardDriveCapacity();
        hardDriveCapacity.setCapacity(capacity);
        return hardDriveCapacityRepository.findByCapacity(capacity).orElse(hardDriveCapacity);
    }
}
