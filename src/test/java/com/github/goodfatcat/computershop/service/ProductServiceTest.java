package com.github.goodfatcat.computershop.service;

import com.github.goodfatcat.computershop.DTO.ComputerDTO;
import com.github.goodfatcat.computershop.model.*;
import com.github.goodfatcat.computershop.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

class ProductServiceTest {
    private final ProductRepository productRepository = Mockito.mock(ProductRepository.class);
    private final ProducerService producerService = Mockito.mock(ProducerService.class);
    private final ProductService productService = new ProductServiceImpl(productRepository, producerService);
    @Test
    void testSaveProduct() {
        ComputerEntity computerEntity = new ComputerEntity();
        productService.save(computerEntity);
        Mockito.verify(productRepository).save(computerEntity);
    }

    @Test
    void testSaveComputerDTO() {
        ComputerDTO computerDTO = new ComputerDTO("Series", 123, 123, "Producer", ComputerForm.DESKTOP);

        Mockito.when(producerService.getProducerOrCreateNew(computerDTO)).thenReturn(new ProducerEntity("Producer"));

        productService.save(computerDTO);

        ComputerEntity computerEntity = new ComputerEntity(computerDTO, new ProducerEntity("Producer"), computerDTO.getComputerForm());

        Mockito.verify(productRepository).save(computerEntity);
        Mockito.verify(producerService).getProducerOrCreateNew(computerDTO);
    }

    @Test
    void findAllByType() {
        initMocks();

        productService.findAllByType(ProductType.COMPUTER);
        productService.findAllByType(ProductType.LAPTOP);
        productService.findAllByType(ProductType.MONITOR);
        productService.findAllByType(ProductType.HARD_DRIVE);


        Mockito.verify(productRepository).findAllByClass(ComputerEntity.class);
        Mockito.verify(productRepository).findAllByClass(LaptopEntity.class);
        Mockito.verify(productRepository).findAllByClass(MonitorEntity.class);
        Mockito.verify(productRepository).findAllByClass(HardDriveEntity.class);
    }

    private void initMocks() {
        ComputerEntity computerEntity = new ComputerEntity();
        initProductEntity(computerEntity);

        computerEntity.setForm(ComputerForm.DESKTOP);
        List<ComputerEntity> computers = List.of(computerEntity);

        Mockito.when(productRepository.findAllByClass(ComputerEntity.class)).thenReturn(computers);

        LaptopEntity laptopEntity = new LaptopEntity();
        initProductEntity(laptopEntity);
        laptopEntity.setLaptopSize(LaptopSize.SIZE17);
        List<LaptopEntity> laptops = List.of(laptopEntity);

        Mockito.when(productRepository.findAllByClass(LaptopEntity.class)).thenReturn(laptops);

        MonitorEntity monitorEntity = new MonitorEntity();
        initProductEntity(monitorEntity);
        monitorEntity.setMonitorSize(24.2);
        List<MonitorEntity> monitors = List.of(monitorEntity);

        Mockito.when(productRepository.findAllByClass(MonitorEntity.class)).thenReturn(monitors);

        HardDriveEntity hardDriveEntity = new HardDriveEntity();
        initProductEntity(hardDriveEntity);
        hardDriveEntity.setHardDriveCapacity(24);
        List<HardDriveEntity> hardDrives = List.of(hardDriveEntity);

        Mockito.when(productRepository.findAllByClass(HardDriveEntity.class)).thenReturn(hardDrives);
    }

    private static void initProductEntity(ProductEntity product) {
        product.setPrice(1);
        product.setProductCount(123);
        product.setSeriesNumber("Series");
        product.setProducer(new ProducerEntity("Producer"));
    }

    @Test
    void findById() {
    }
}